package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes.dex */
public class a {
    private static a jad = null;
    private final CustomMessageListener iZp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler jae;
    private ConcurrentHashMap<Long, GroupMsgData> jaf;
    private ConcurrentHashMap<Long, NewpushGroupRepair> jag;
    private ConcurrentHashMap<Long, Runnable> jah;
    private Vector<Long> jai;
    private Handler mHandler;

    public static a csN() {
        if (jad == null) {
            synchronized (a.class) {
                if (jad == null) {
                    jad = new a();
                }
            }
        }
        return jad;
    }

    private a() {
        this.mHandler = null;
        this.jae = null;
        this.jaf = null;
        this.jag = null;
        this.jah = null;
        this.jai = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.iZp);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            a.this.jai.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jae = new Handler(Looper.myLooper());
        this.jaf = new ConcurrentHashMap<>();
        this.jag = new ConcurrentHashMap<>();
        this.jah = new ConcurrentHashMap<>();
        this.jai = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo bb = j.cpK().bb(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(bb != null)) {
                if (!this.jai.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = bb.getSid();
            long eR = com.baidu.tieba.im.util.d.eR(bb.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.jaf.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.jaf.put(Long.valueOf(groupId), groupMsgData4);
                groupMsgData2 = groupMsgData4;
            } else {
                groupMsgData2 = groupMsgData3;
            }
            Iterator<ChatMessage> it = listMessage.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (next.getSid() > sid) {
                    a(next, groupMsgData2);
                }
            }
            listMessage.clear();
            List<ChatMessage> eI = eI(groupId);
            if (eI != null && eI.size() > 0) {
                if (z || sid <= 0 || eI.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(eI);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    eR = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(eI);
                }
            }
            if (z) {
                this.jai.remove(Long.valueOf(groupId));
            }
            if (!this.jai.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), eR);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.jag.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.jai.add(Long.valueOf(j));
            eJ(j);
        }
    }

    private List<ChatMessage> eI(long j) {
        GroupMsgData groupMsgData = this.jaf.get(Long.valueOf(j));
        if (groupMsgData == null) {
            return null;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage == null || listMessage.size() == 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<ChatMessage> it = listMessage.iterator();
        long sid = listMessage.get(0).getSid() - 1;
        while (true) {
            long j2 = sid;
            if (!it.hasNext()) {
                break;
            }
            ChatMessage next = it.next();
            if (next.getSid() != j2 + 1) {
                break;
            }
            it.remove();
            linkedList.add(next);
            sid = j2 + 1;
        }
        return linkedList;
    }

    private void a(long j, long j2, int i, long j3) {
        GroupMsgData groupMsgData = this.jaf.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                eL(j2);
            } else if (!this.jah.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.jaf.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.eL(j2);
                    return;
                }
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                long j4 = -1;
                if (listMessage != null && listMessage.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= listMessage.size()) {
                            break;
                        }
                        if (j4 < listMessage.get(i3).getSid()) {
                            j4 = listMessage.get(i3).getSid();
                        }
                        i2 = i3 + 1;
                    }
                    listMessage.clear();
                }
                long j5 = j4;
                a.this.eL(j2);
                if (j5 > j) {
                    a.this.jag.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.csw().a(j2, 1L, 0L, true);
                    a.this.jai.add(Long.valueOf(j2));
                    a.this.eJ(j2);
                }
            }
        };
        this.jae.postDelayed(runnable, b.csO().kc().getTimeOutAuto());
        this.jah.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair eK(long j) {
        if (this.jag.containsKey(Long.valueOf(j))) {
            return this.jag.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(long j) {
        Runnable remove = this.jah.remove(Long.valueOf(j));
        if (remove != null) {
            this.jae.removeCallbacks(remove);
        }
    }

    private boolean a(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        LinkedList<ChatMessage> listMessage;
        if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
            return false;
        }
        if (listMessage.contains(chatMessage)) {
            return true;
        }
        int size = listMessage.size();
        int i = 0;
        while (i < size) {
            ChatMessage chatMessage2 = listMessage.get(i);
            if (chatMessage2 != null) {
                if (chatMessage.getSid() == chatMessage2.getSid()) {
                    return true;
                }
                if (chatMessage.getSid() < chatMessage2.getSid()) {
                    break;
                }
            }
            i++;
        }
        listMessage.add(i, chatMessage);
        return true;
    }

    public void clearAll() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jae != null) {
            this.jae.removeCallbacksAndMessages(null);
        }
        if (this.jah != null) {
            for (Map.Entry<Long, Runnable> entry : this.jah.entrySet()) {
                eL(entry.getKey().longValue());
            }
            this.jah.clear();
        }
        if (this.jaf != null) {
            this.jaf.clear();
        }
        if (this.jai != null) {
            this.jai.clear();
        }
    }
}
