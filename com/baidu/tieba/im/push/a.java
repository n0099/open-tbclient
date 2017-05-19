package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private static a cZL = null;
    private final CustomMessageListener cYY = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler cZM;
    private ConcurrentHashMap<Long, GroupMsgData> cZN;
    private ConcurrentHashMap<Long, NewpushGroupRepair> cZO;
    private ConcurrentHashMap<Long, Runnable> cZP;
    private Vector<Long> cZQ;
    private Handler mHandler;

    public static a aqT() {
        if (cZL == null) {
            synchronized (a.class) {
                if (cZL == null) {
                    cZL = new a();
                }
            }
        }
        return cZL;
    }

    private a() {
        this.mHandler = null;
        this.cZM = null;
        this.cZN = null;
        this.cZO = null;
        this.cZP = null;
        this.cZQ = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.cZM = new Handler(Looper.myLooper());
        this.cZN = new ConcurrentHashMap<>();
        this.cZO = new ConcurrentHashMap<>();
        this.cZP = new ConcurrentHashMap<>();
        this.cZQ = new Vector<>();
        this.mHandler.sendEmptyMessage(IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        long j;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo V = j.anx().V(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(V != null)) {
                if (!this.cZQ.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = V.getSid();
            long by = com.baidu.tieba.im.util.g.by(V.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.cZN.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.cZN.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bq = bq(groupId);
            if (bq != null && bq.size() > 0) {
                if (z || sid <= 0 || bq.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bq);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    by = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.cZQ.remove(Long.valueOf(groupId));
                    }
                    if (this.cZQ.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), by);
                        return;
                    }
                    return;
                }
                groupMsgData2.getListMessage().addAll(bq);
            }
            j = sid;
            if (z) {
            }
            if (this.cZQ.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.cZO.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.cZQ.add(Long.valueOf(j));
            br(j);
        }
    }

    private List<ChatMessage> bq(long j) {
        GroupMsgData groupMsgData = this.cZN.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.cZN.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bt(j2);
            } else if (!this.cZP.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.cZM.postDelayed(dVar, e.aqU().dv().dw());
        this.cZP.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bs(long j) {
        if (this.cZO.containsKey(Long.valueOf(j))) {
            return this.cZO.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(long j) {
        Runnable remove = this.cZP.remove(Long.valueOf(j));
        if (remove != null) {
            this.cZM.removeCallbacks(remove);
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
        if (this.cZM != null) {
            this.cZM.removeCallbacksAndMessages(null);
        }
        if (this.cZP != null) {
            for (Map.Entry<Long, Runnable> entry : this.cZP.entrySet()) {
                bt(entry.getKey().longValue());
            }
            this.cZP.clear();
        }
        if (this.cZN != null) {
            this.cZN.clear();
        }
        if (this.cZQ != null) {
            this.cZQ.clear();
        }
    }
}
