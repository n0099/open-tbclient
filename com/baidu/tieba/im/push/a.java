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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes.dex */
public class a {
    private static a cdX = null;
    private Handler cdY;
    private ConcurrentHashMap<Long, GroupMsgData> cdZ;
    private final CustomMessageListener cdk = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private ConcurrentHashMap<Long, NewpushGroupRepair> cea;
    private ConcurrentHashMap<Long, Runnable> ceb;
    private Vector<Long> cec;
    private Handler mHandler;

    public static a aet() {
        if (cdX == null) {
            synchronized (a.class) {
                if (cdX == null) {
                    cdX = new a();
                }
            }
        }
        return cdX;
    }

    private a() {
        this.mHandler = null;
        this.cdY = null;
        this.cdZ = null;
        this.cea = null;
        this.ceb = null;
        this.cec = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.cdY = new Handler(Looper.myLooper());
        this.cdZ = new ConcurrentHashMap<>();
        this.cea = new ConcurrentHashMap<>();
        this.ceb = new ConcurrentHashMap<>();
        this.cec = new Vector<>();
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
            ImMessageCenterPojo L = i.abc().L(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(L != null)) {
                if (!this.cec.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = L.getSid();
            long bf = com.baidu.tieba.im.util.g.bf(L.getPulled_msgId());
            BdLog.e("pojo lastSid is " + sid);
            GroupMsgData groupMsgData3 = this.cdZ.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.cdZ.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> aX = aX(groupId);
            if (aX != null && aX.size() > 0) {
                BdLog.e("seriesData.get(0).getSid() " + aX.get(0).getSid());
                if (z || sid <= 0 || aX.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(aX);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bf = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.cec.remove(Long.valueOf(groupId));
                    }
                    if (this.cec.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bf);
                        return;
                    }
                    return;
                }
                BdLog.e("need repair");
                groupMsgData2.getListMessage().addAll(aX);
            }
            j = sid;
            if (z) {
            }
            if (this.cec.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.cea.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.cec.add(Long.valueOf(j));
            aY(j);
        }
    }

    private List<ChatMessage> aX(long j) {
        GroupMsgData groupMsgData = this.cdZ.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.cdZ.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                ba(j2);
            } else if (!this.ceb.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.cdY.postDelayed(dVar, e.aeu().fc().fe());
        this.ceb.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair aZ(long j) {
        if (this.cea.containsKey(Long.valueOf(j))) {
            return this.cea.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(long j) {
        Runnable remove = this.ceb.remove(Long.valueOf(j));
        if (remove != null) {
            this.cdY.removeCallbacks(remove);
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
        if (this.cdY != null) {
            this.cdY.removeCallbacksAndMessages(null);
        }
        if (this.ceb != null) {
            for (Map.Entry<Long, Runnable> entry : this.ceb.entrySet()) {
                ba(entry.getKey().longValue());
            }
            this.ceb.clear();
        }
        if (this.cdZ != null) {
            this.cdZ.clear();
        }
        if (this.cec != null) {
            this.cec.clear();
        }
    }
}
