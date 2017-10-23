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
    private static a dCw = null;
    private final CustomMessageListener dBL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private ConcurrentHashMap<Long, Runnable> dCA;
    private Vector<Long> dCB;
    private Handler dCx;
    private ConcurrentHashMap<Long, GroupMsgData> dCy;
    private ConcurrentHashMap<Long, NewpushGroupRepair> dCz;
    private Handler mHandler;

    public static a ayA() {
        if (dCw == null) {
            synchronized (a.class) {
                if (dCw == null) {
                    dCw = new a();
                }
            }
        }
        return dCw;
    }

    private a() {
        this.mHandler = null;
        this.dCx = null;
        this.dCy = null;
        this.dCz = null;
        this.dCA = null;
        this.dCB = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
                        MessageManager.getInstance().registerListener(a.this.dBL);
                        return;
                    case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                        if (message.getData() != null && message.getData().containsKey("groupId")) {
                            a.this.dCB.remove(Long.valueOf(message.getData().getLong("groupId")));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dCx = new Handler(Looper.myLooper());
        this.dCy = new ConcurrentHashMap<>();
        this.dCz = new ConcurrentHashMap<>();
        this.dCA = new ConcurrentHashMap<>();
        this.dCB = new Vector<>();
        this.mHandler.sendEmptyMessage(IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo V = i.ave().V(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(V != null)) {
                if (!this.dCB.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = V.getSid();
            long bP = com.baidu.tieba.im.util.d.bP(V.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.dCy.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.dCy.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bH = bH(groupId);
            if (bH != null && bH.size() > 0) {
                if (z || sid <= 0 || bH.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bH);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    bP = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(bH);
                }
            }
            if (z) {
                this.dCB.remove(Long.valueOf(groupId));
            }
            if (!this.dCB.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), bP);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.dCz.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.dCB.add(Long.valueOf(j));
            bI(j);
        }
    }

    private List<ChatMessage> bH(long j) {
        GroupMsgData groupMsgData = this.dCy.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.dCy.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bK(j2);
            } else if (!this.dCA.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.dCy.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.bK(j2);
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
                a.this.bK(j2);
                if (j5 > j) {
                    a.this.dCz.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.b.b.ayj().a(j2, 1L, 0L, true);
                    a.this.dCB.add(Long.valueOf(j2));
                    a.this.bI(j2);
                }
            }
        };
        this.dCx.postDelayed(runnable, b.ayB().dv().dw());
        this.dCA.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bJ(long j) {
        if (this.dCz.containsKey(Long.valueOf(j))) {
            return this.dCz.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(long j) {
        Runnable remove = this.dCA.remove(Long.valueOf(j));
        if (remove != null) {
            this.dCx.removeCallbacks(remove);
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
        if (this.dCx != null) {
            this.dCx.removeCallbacksAndMessages(null);
        }
        if (this.dCA != null) {
            for (Map.Entry<Long, Runnable> entry : this.dCA.entrySet()) {
                bK(entry.getKey().longValue());
            }
            this.dCA.clear();
        }
        if (this.dCy != null) {
            this.dCy.clear();
        }
        if (this.dCB != null) {
            this.dCB.clear();
        }
    }
}
