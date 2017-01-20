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
    private static a dcF = null;
    private final CustomMessageListener dbR = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler dcG;
    private ConcurrentHashMap<Long, GroupMsgData> dcH;
    private ConcurrentHashMap<Long, NewpushGroupRepair> dcI;
    private ConcurrentHashMap<Long, Runnable> dcJ;
    private Vector<Long> dcK;
    private Handler mHandler;

    public static a atK() {
        if (dcF == null) {
            synchronized (a.class) {
                if (dcF == null) {
                    dcF = new a();
                }
            }
        }
        return dcF;
    }

    private a() {
        this.mHandler = null;
        this.dcG = null;
        this.dcH = null;
        this.dcI = null;
        this.dcJ = null;
        this.dcK = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.dcG = new Handler(Looper.myLooper());
        this.dcH = new ConcurrentHashMap<>();
        this.dcI = new ConcurrentHashMap<>();
        this.dcJ = new ConcurrentHashMap<>();
        this.dcK = new Vector<>();
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
            ImMessageCenterPojo ab = i.aqq().ab(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ab != null)) {
                if (!this.dcK.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ab.getSid();
            long bM = com.baidu.tieba.im.util.g.bM(ab.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.dcH.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.dcH.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bE = bE(groupId);
            if (bE != null && bE.size() > 0) {
                if (z || sid <= 0 || bE.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bE);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bM = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.dcK.remove(Long.valueOf(groupId));
                    }
                    if (this.dcK.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bM);
                        return;
                    }
                    return;
                }
                groupMsgData2.getListMessage().addAll(bE);
            }
            j = sid;
            if (z) {
            }
            if (this.dcK.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.dcI.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.dcK.add(Long.valueOf(j));
            bF(j);
        }
    }

    private List<ChatMessage> bE(long j) {
        GroupMsgData groupMsgData = this.dcH.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.dcH.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bH(j2);
            } else if (!this.dcJ.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.dcG.postDelayed(dVar, e.atL().cm().cn());
        this.dcJ.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(long j) {
        Message message = new Message();
        message.what = IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bG(long j) {
        if (this.dcI.containsKey(Long.valueOf(j))) {
            return this.dcI.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        Runnable remove = this.dcJ.remove(Long.valueOf(j));
        if (remove != null) {
            this.dcG.removeCallbacks(remove);
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
        if (this.dcG != null) {
            this.dcG.removeCallbacksAndMessages(null);
        }
        if (this.dcJ != null) {
            for (Map.Entry<Long, Runnable> entry : this.dcJ.entrySet()) {
                bH(entry.getKey().longValue());
            }
            this.dcJ.clear();
        }
        if (this.dcH != null) {
            this.dcH.clear();
        }
        if (this.dcK != null) {
            this.dcK.clear();
        }
    }
}
