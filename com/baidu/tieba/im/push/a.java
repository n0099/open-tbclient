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
/* loaded from: classes.dex */
public class a {
    private static a cXK = null;
    private final CustomMessageListener cWW = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler cXL;
    private ConcurrentHashMap<Long, GroupMsgData> cXM;
    private ConcurrentHashMap<Long, NewpushGroupRepair> cXN;
    private ConcurrentHashMap<Long, Runnable> cXO;
    private Vector<Long> cXP;
    private Handler mHandler;

    public static a aqV() {
        if (cXK == null) {
            synchronized (a.class) {
                if (cXK == null) {
                    cXK = new a();
                }
            }
        }
        return cXK;
    }

    private a() {
        this.mHandler = null;
        this.cXL = null;
        this.cXM = null;
        this.cXN = null;
        this.cXO = null;
        this.cXP = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.cXL = new Handler(Looper.myLooper());
        this.cXM = new ConcurrentHashMap<>();
        this.cXN = new ConcurrentHashMap<>();
        this.cXO = new ConcurrentHashMap<>();
        this.cXP = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
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
            ImMessageCenterPojo ad = i.anz().ad(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(ad != null)) {
                if (!this.cXP.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = ad.getSid();
            long bI = com.baidu.tieba.im.util.g.bI(ad.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.cXM.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.cXM.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bA = bA(groupId);
            if (bA != null && bA.size() > 0) {
                if (z || sid <= 0 || bA.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bA);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bI = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.cXP.remove(Long.valueOf(groupId));
                    }
                    if (this.cXP.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bI);
                        return;
                    }
                    return;
                }
                groupMsgData2.getListMessage().addAll(bA);
            }
            j = sid;
            if (z) {
            }
            if (this.cXP.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.cXN.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.cXP.add(Long.valueOf(j));
            bB(j);
        }
    }

    private List<ChatMessage> bA(long j) {
        GroupMsgData groupMsgData = this.cXM.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.cXM.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bD(j2);
            } else if (!this.cXO.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.cXL.postDelayed(dVar, e.aqW().bt().bu());
        this.cXO.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bC(long j) {
        if (this.cXN.containsKey(Long.valueOf(j))) {
            return this.cXN.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(long j) {
        Runnable remove = this.cXO.remove(Long.valueOf(j));
        if (remove != null) {
            this.cXL.removeCallbacks(remove);
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
        if (this.cXL != null) {
            this.cXL.removeCallbacksAndMessages(null);
        }
        if (this.cXO != null) {
            for (Map.Entry<Long, Runnable> entry : this.cXO.entrySet()) {
                bD(entry.getKey().longValue());
            }
            this.cXO.clear();
        }
        if (this.cXM != null) {
            this.cXM.clear();
        }
        if (this.cXP != null) {
            this.cXP.clear();
        }
    }
}
