package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class a {
    private static a esI = null;
    private final CustomMessageListener erW = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler esJ;
    private ConcurrentHashMap<Long, GroupMsgData> esK;
    private ConcurrentHashMap<Long, NewpushGroupRepair> esL;
    private ConcurrentHashMap<Long, Runnable> esM;
    private Vector<Long> esN;
    private Handler mHandler;

    public static a aLm() {
        if (esI == null) {
            synchronized (a.class) {
                if (esI == null) {
                    esI = new a();
                }
            }
        }
        return esI;
    }

    private a() {
        this.mHandler = null;
        this.esJ = null;
        this.esK = null;
        this.esL = null;
        this.esM = null;
        this.esN = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.erW);
                        return;
                    case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                        if (message.getData() != null && message.getData().containsKey("groupId")) {
                            a.this.esN.remove(Long.valueOf(message.getData().getLong("groupId")));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.esJ = new Handler(Looper.myLooper());
        this.esK = new ConcurrentHashMap<>();
        this.esL = new ConcurrentHashMap<>();
        this.esM = new ConcurrentHashMap<>();
        this.esN = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo ao = j.aIb().ao(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ao != null)) {
                if (!this.esN.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ao.getSid();
            long cp = com.baidu.tieba.im.util.d.cp(ao.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.esK.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.esK.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> cf = cf(groupId);
            if (cf != null && cf.size() > 0) {
                if (z || sid <= 0 || cf.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(cf);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    cp = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(cf);
                }
            }
            if (z) {
                this.esN.remove(Long.valueOf(groupId));
            }
            if (!this.esN.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), cp);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.esL.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.esN.add(Long.valueOf(j));
            cg(j);
        }
    }

    private List<ChatMessage> cf(long j) {
        GroupMsgData groupMsgData = this.esK.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.esK.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                ci(j2);
            } else if (!this.esM.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.esK.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.ci(j2);
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
                a.this.ci(j2);
                if (j5 > j) {
                    a.this.esL.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.aKU().a(j2, 1L, 0L, true);
                    a.this.esN.add(Long.valueOf(j2));
                    a.this.cg(j2);
                }
            }
        };
        this.esJ.postDelayed(runnable, b.aLn().fS().fT());
        this.esM.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair ch(long j) {
        if (this.esL.containsKey(Long.valueOf(j))) {
            return this.esL.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(long j) {
        Runnable remove = this.esM.remove(Long.valueOf(j));
        if (remove != null) {
            this.esJ.removeCallbacks(remove);
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
        if (this.esJ != null) {
            this.esJ.removeCallbacksAndMessages(null);
        }
        if (this.esM != null) {
            for (Map.Entry<Long, Runnable> entry : this.esM.entrySet()) {
                ci(entry.getKey().longValue());
            }
            this.esM.clear();
        }
        if (this.esK != null) {
            this.esK.clear();
        }
        if (this.esN != null) {
            this.esN.clear();
        }
    }
}
