package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.util.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes.dex */
public class a {
    private static a bZC = null;
    private final CustomMessageListener bYQ = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler bZD;
    private ConcurrentHashMap<Long, GroupMsgData> bZE;
    private ConcurrentHashMap<Long, NewpushGroupRepair> bZF;
    private ConcurrentHashMap<Long, Runnable> bZG;
    private Vector<Long> bZH;
    private Handler mHandler;

    public static a abt() {
        if (bZC == null) {
            synchronized (a.class) {
                if (bZC == null) {
                    bZC = new a();
                }
            }
        }
        return bZC;
    }

    private a() {
        this.mHandler = null;
        this.bZD = null;
        this.bZE = null;
        this.bZF = null;
        this.bZG = null;
        this.bZH = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.bZD = new Handler(Looper.myLooper());
        this.bZE = new ConcurrentHashMap<>();
        this.bZF = new ConcurrentHashMap<>();
        this.bZG = new ConcurrentHashMap<>();
        this.bZH = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        long j;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            BdLog.e("groupId " + groupId + " userType " + groupMsgData.getGroupInfo().getUserType());
            ImMessageCenterPojo K = i.Yr().K(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(K != null)) {
                if (!this.bZH.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = K.getSid();
            long bd = g.bd(K.getPulled_msgId());
            BdLog.e("pojo lastSid is " + sid);
            GroupMsgData groupMsgData3 = this.bZE.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.bZE.put(Long.valueOf(groupId), groupMsgData4);
                groupMsgData2 = groupMsgData4;
            } else {
                groupMsgData2 = groupMsgData3;
            }
            Iterator<ChatMessage> it = listMessage.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                long sid2 = next.getSid();
                BdLog.e("sid is " + sid2);
                if (sid2 > sid) {
                    a(next, groupMsgData2);
                }
            }
            listMessage.clear();
            List<ChatMessage> aW = aW(groupId);
            if (aW != null && aW.size() > 0) {
                BdLog.e("seriesData.get(0).getSid() " + aW.get(0).getSid());
                if (z || sid <= 0 || aW.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(aW);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bd = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.bZH.remove(Long.valueOf(groupId));
                    }
                    if (this.bZH.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bd);
                        return;
                    }
                    return;
                }
                BdLog.e("need repair");
                groupMsgData2.getListMessage().addAll(aW);
            }
            j = sid;
            if (z) {
            }
            if (this.bZH.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.bZF.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.bZH.add(Long.valueOf(j));
            aX(j);
        }
    }

    private List<ChatMessage> aW(long j) {
        GroupMsgData groupMsgData = this.bZE.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.bZE.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                aZ(j2);
            } else if (!this.bZG.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.bZD.postDelayed(dVar, e.abu().eW().eX());
        this.bZG.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair aY(long j) {
        if (this.bZF.containsKey(Long.valueOf(j))) {
            return this.bZF.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(long j) {
        Runnable remove = this.bZG.remove(Long.valueOf(j));
        if (remove != null) {
            this.bZD.removeCallbacks(remove);
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
        if (this.bZD != null) {
            this.bZD.removeCallbacksAndMessages(null);
        }
        if (this.bZG != null) {
            for (Map.Entry<Long, Runnable> entry : this.bZG.entrySet()) {
                aZ(entry.getKey().longValue());
            }
            this.bZG.clear();
        }
        if (this.bZE != null) {
            this.bZE.clear();
        }
        if (this.bZH != null) {
            this.bZH.clear();
        }
    }
}
