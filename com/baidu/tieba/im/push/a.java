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
    private static a iJa = null;
    private final CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler iJb;
    private ConcurrentHashMap<Long, GroupMsgData> iJc;
    private ConcurrentHashMap<Long, NewpushGroupRepair> iJd;
    private ConcurrentHashMap<Long, Runnable> iJe;
    private Vector<Long> iJf;
    private Handler mHandler;

    public static a coY() {
        if (iJa == null) {
            synchronized (a.class) {
                if (iJa == null) {
                    iJa = new a();
                }
            }
        }
        return iJa;
    }

    private a() {
        this.mHandler = null;
        this.iJb = null;
        this.iJc = null;
        this.iJd = null;
        this.iJe = null;
        this.iJf = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.iIm);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            a.this.iJf.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iJb = new Handler(Looper.myLooper());
        this.iJc = new ConcurrentHashMap<>();
        this.iJd = new ConcurrentHashMap<>();
        this.iJe = new ConcurrentHashMap<>();
        this.iJf = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo bc = j.clV().bc(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(bc != null)) {
                if (!this.iJf.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = bc.getSid();
            long eO = com.baidu.tieba.im.util.d.eO(bc.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.iJc.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.iJc.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> eF = eF(groupId);
            if (eF != null && eF.size() > 0) {
                if (z || sid <= 0 || eF.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(eF);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    eO = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(eF);
                }
            }
            if (z) {
                this.iJf.remove(Long.valueOf(groupId));
            }
            if (!this.iJf.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), eO);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.iJd.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.iJf.add(Long.valueOf(j));
            eG(j);
        }
    }

    private List<ChatMessage> eF(long j) {
        GroupMsgData groupMsgData = this.iJc.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.iJc.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                eI(j2);
            } else if (!this.iJe.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.iJc.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.eI(j2);
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
                a.this.eI(j2);
                if (j5 > j) {
                    a.this.iJd.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.coH().a(j2, 1L, 0L, true);
                    a.this.iJf.add(Long.valueOf(j2));
                    a.this.eG(j2);
                }
            }
        };
        this.iJb.postDelayed(runnable, b.coZ().jM().getTimeOutAuto());
        this.iJe.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eG(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair eH(long j) {
        if (this.iJd.containsKey(Long.valueOf(j))) {
            return this.iJd.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(long j) {
        Runnable remove = this.iJe.remove(Long.valueOf(j));
        if (remove != null) {
            this.iJb.removeCallbacks(remove);
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
        if (this.iJb != null) {
            this.iJb.removeCallbacksAndMessages(null);
        }
        if (this.iJe != null) {
            for (Map.Entry<Long, Runnable> entry : this.iJe.entrySet()) {
                eI(entry.getKey().longValue());
            }
            this.iJe.clear();
        }
        if (this.iJc != null) {
            this.iJc.clear();
        }
        if (this.iJf != null) {
            this.iJf.clear();
        }
    }
}
