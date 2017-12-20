package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.i;
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
    private static a dTi = null;
    private final CustomMessageListener dSx = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler dTj;
    private ConcurrentHashMap<Long, GroupMsgData> dTk;
    private ConcurrentHashMap<Long, NewpushGroupRepair> dTl;
    private ConcurrentHashMap<Long, Runnable> dTm;
    private Vector<Long> dTn;
    private Handler mHandler;

    public static a aCH() {
        if (dTi == null) {
            synchronized (a.class) {
                if (dTi == null) {
                    dTi = new a();
                }
            }
        }
        return dTi;
    }

    private a() {
        this.mHandler = null;
        this.dTj = null;
        this.dTk = null;
        this.dTl = null;
        this.dTm = null;
        this.dTn = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.dSx);
                        return;
                    case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                        if (message.getData() != null && message.getData().containsKey("groupId")) {
                            a.this.dTn.remove(Long.valueOf(message.getData().getLong("groupId")));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dTj = new Handler(Looper.myLooper());
        this.dTk = new ConcurrentHashMap<>();
        this.dTl = new ConcurrentHashMap<>();
        this.dTm = new ConcurrentHashMap<>();
        this.dTn = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo ae = i.azy().ae(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ae != null)) {
                if (!this.dTn.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ae.getSid();
            long bY = com.baidu.tieba.im.util.d.bY(ae.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.dTk.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.dTk.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bQ = bQ(groupId);
            if (bQ != null && bQ.size() > 0) {
                if (z || sid <= 0 || bQ.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bQ);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    bY = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(bQ);
                }
            }
            if (z) {
                this.dTn.remove(Long.valueOf(groupId));
            }
            if (!this.dTn.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), bY);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.dTl.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.dTn.add(Long.valueOf(j));
            bR(j);
        }
    }

    private List<ChatMessage> bQ(long j) {
        GroupMsgData groupMsgData = this.dTk.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.dTk.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bT(j2);
            } else if (!this.dTm.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.dTk.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.bT(j2);
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
                a.this.bT(j2);
                if (j5 > j) {
                    a.this.dTl.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.aCq().a(j2, 1L, 0L, true);
                    a.this.dTn.add(Long.valueOf(j2));
                    a.this.bR(j2);
                }
            }
        };
        this.dTj.postDelayed(runnable, b.aCI().dv().dw());
        this.dTm.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bS(long j) {
        if (this.dTl.containsKey(Long.valueOf(j))) {
            return this.dTl.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(long j) {
        Runnable remove = this.dTm.remove(Long.valueOf(j));
        if (remove != null) {
            this.dTj.removeCallbacks(remove);
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
        if (this.dTj != null) {
            this.dTj.removeCallbacksAndMessages(null);
        }
        if (this.dTm != null) {
            for (Map.Entry<Long, Runnable> entry : this.dTm.entrySet()) {
                bT(entry.getKey().longValue());
            }
            this.dTm.clear();
        }
        if (this.dTk != null) {
            this.dTk.clear();
        }
        if (this.dTn != null) {
            this.dTn.clear();
        }
    }
}
