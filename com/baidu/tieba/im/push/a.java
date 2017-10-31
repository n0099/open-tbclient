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
    private static a dKk = null;
    private final CustomMessageListener dJz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler dKl;
    private ConcurrentHashMap<Long, GroupMsgData> dKm;
    private ConcurrentHashMap<Long, NewpushGroupRepair> dKn;
    private ConcurrentHashMap<Long, Runnable> dKo;
    private Vector<Long> dKp;
    private Handler mHandler;

    public static a aAV() {
        if (dKk == null) {
            synchronized (a.class) {
                if (dKk == null) {
                    dKk = new a();
                }
            }
        }
        return dKk;
    }

    private a() {
        this.mHandler = null;
        this.dKl = null;
        this.dKm = null;
        this.dKn = null;
        this.dKo = null;
        this.dKp = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
                        MessageManager.getInstance().registerListener(a.this.dJz);
                        return;
                    case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                        if (message.getData() != null && message.getData().containsKey("groupId")) {
                            a.this.dKp.remove(Long.valueOf(message.getData().getLong("groupId")));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dKl = new Handler(Looper.myLooper());
        this.dKm = new ConcurrentHashMap<>();
        this.dKn = new ConcurrentHashMap<>();
        this.dKo = new ConcurrentHashMap<>();
        this.dKp = new Vector<>();
        this.mHandler.sendEmptyMessage(IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo ab = i.axz().ab(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ab != null)) {
                if (!this.dKp.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ab.getSid();
            long bQ = com.baidu.tieba.im.util.d.bQ(ab.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.dKm.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.dKm.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bI = bI(groupId);
            if (bI != null && bI.size() > 0) {
                if (z || sid <= 0 || bI.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bI);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    bQ = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(bI);
                }
            }
            if (z) {
                this.dKp.remove(Long.valueOf(groupId));
            }
            if (!this.dKp.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), bQ);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.dKn.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.dKp.add(Long.valueOf(j));
            bJ(j);
        }
    }

    private List<ChatMessage> bI(long j) {
        GroupMsgData groupMsgData = this.dKm.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.dKm.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bL(j2);
            } else if (!this.dKo.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.dKm.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.bL(j2);
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
                a.this.bL(j2);
                if (j5 > j) {
                    a.this.dKn.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.b.b.aAE().a(j2, 1L, 0L, true);
                    a.this.dKp.add(Long.valueOf(j2));
                    a.this.bJ(j2);
                }
            }
        };
        this.dKl.postDelayed(runnable, b.aAW().dv().dw());
        this.dKo.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bK(long j) {
        if (this.dKn.containsKey(Long.valueOf(j))) {
            return this.dKn.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(long j) {
        Runnable remove = this.dKo.remove(Long.valueOf(j));
        if (remove != null) {
            this.dKl.removeCallbacks(remove);
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
        if (this.dKl != null) {
            this.dKl.removeCallbacksAndMessages(null);
        }
        if (this.dKo != null) {
            for (Map.Entry<Long, Runnable> entry : this.dKo.entrySet()) {
                bL(entry.getKey().longValue());
            }
            this.dKo.clear();
        }
        if (this.dKm != null) {
            this.dKm.clear();
        }
        if (this.dKp != null) {
            this.dKp.clear();
        }
    }
}
