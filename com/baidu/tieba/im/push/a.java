package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
    private static a cVu = null;
    private final CustomMessageListener cUH = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler cVv;
    private ConcurrentHashMap<Long, GroupMsgData> cVw;
    private ConcurrentHashMap<Long, NewpushGroupRepair> cVx;
    private ConcurrentHashMap<Long, Runnable> cVy;
    private Vector<Long> cVz;
    private Handler mHandler;

    public static a asE() {
        if (cVu == null) {
            synchronized (a.class) {
                if (cVu == null) {
                    cVu = new a();
                }
            }
        }
        return cVu;
    }

    private a() {
        this.mHandler = null;
        this.cVv = null;
        this.cVw = null;
        this.cVx = null;
        this.cVy = null;
        this.cVz = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.cVv = new Handler(Looper.myLooper());
        this.cVw = new ConcurrentHashMap<>();
        this.cVx = new ConcurrentHashMap<>();
        this.cVy = new ConcurrentHashMap<>();
        this.cVz = new Vector<>();
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
            ImMessageCenterPojo ab = i.apj().ab(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ab != null)) {
                if (!this.cVz.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ab.getSid();
            long bR = com.baidu.tieba.im.util.g.bR(ab.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.cVw.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.cVw.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bJ = bJ(groupId);
            if (bJ != null && bJ.size() > 0) {
                if (z || sid <= 0 || bJ.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bJ);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bR = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.cVz.remove(Long.valueOf(groupId));
                    }
                    if (this.cVz.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bR);
                        return;
                    }
                    return;
                }
                groupMsgData2.getListMessage().addAll(bJ);
            }
            j = sid;
            if (z) {
            }
            if (this.cVz.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.cVx.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.cVz.add(Long.valueOf(j));
            bK(j);
        }
    }

    private List<ChatMessage> bJ(long j) {
        GroupMsgData groupMsgData = this.cVw.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.cVw.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bM(j2);
            } else if (!this.cVy.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.cVv.postDelayed(dVar, e.asF().co().cp());
        this.cVy.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bL(long j) {
        if (this.cVx.containsKey(Long.valueOf(j))) {
            return this.cVx.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(long j) {
        Runnable remove = this.cVy.remove(Long.valueOf(j));
        if (remove != null) {
            this.cVv.removeCallbacks(remove);
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
        if (this.cVv != null) {
            this.cVv.removeCallbacksAndMessages(null);
        }
        if (this.cVy != null) {
            for (Map.Entry<Long, Runnable> entry : this.cVy.entrySet()) {
                bM(entry.getKey().longValue());
            }
            this.cVy.clear();
        }
        if (this.cVw != null) {
            this.cVw.clear();
        }
        if (this.cVz != null) {
            this.cVz.clear();
        }
    }
}
