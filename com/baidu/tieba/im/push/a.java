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
    private static a coC = null;
    private final CustomMessageListener cnP = new b(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler coD;
    private ConcurrentHashMap<Long, GroupMsgData> coE;
    private ConcurrentHashMap<Long, NewpushGroupRepair> coF;
    private ConcurrentHashMap<Long, Runnable> coG;
    private Vector<Long> coH;
    private Handler mHandler;

    public static a ahM() {
        if (coC == null) {
            synchronized (a.class) {
                if (coC == null) {
                    coC = new a();
                }
            }
        }
        return coC;
    }

    private a() {
        this.mHandler = null;
        this.coD = null;
        this.coE = null;
        this.coF = null;
        this.coG = null;
        this.coH = null;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.coD = new Handler(Looper.myLooper());
        this.coE = new ConcurrentHashMap<>();
        this.coF = new ConcurrentHashMap<>();
        this.coG = new ConcurrentHashMap<>();
        this.coH = new Vector<>();
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
            ImMessageCenterPojo S = i.aey().S(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(S != null)) {
                if (!this.coH.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = S.getSid();
            long bl = com.baidu.tieba.im.util.g.bl(S.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.coE.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.coE.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> bd = bd(groupId);
            if (bd != null && bd.size() > 0) {
                if (z || sid <= 0 || bd.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(bd);
                    j = listMessage.get(listMessage.size() - 1).getSid();
                    bl = listMessage.get(listMessage.size() - 1).getMsgId();
                    if (z) {
                        this.coH.remove(Long.valueOf(groupId));
                    }
                    if (this.coH.contains(Long.valueOf(groupId))) {
                        a(j, groupId, groupMsgData.getGroupInfo().getUserType(), bl);
                        return;
                    }
                    return;
                }
                groupMsgData2.getListMessage().addAll(bd);
            }
            j = sid;
            if (z) {
            }
            if (this.coH.contains(Long.valueOf(groupId))) {
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.coF.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.coH.add(Long.valueOf(j));
            be(j);
        }
    }

    private List<ChatMessage> bd(long j) {
        GroupMsgData groupMsgData = this.coE.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.coE.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                bg(j2);
            } else if (!this.coG.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(long j, long j2, int i, long j3) {
        d dVar = new d(this, j2, j, i, j3);
        this.coD.postDelayed(dVar, e.ahN().fe().ff());
        this.coG.put(Long.valueOf(j2), dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair bf(long j) {
        if (this.coF.containsKey(Long.valueOf(j))) {
            return this.coF.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(long j) {
        Runnable remove = this.coG.remove(Long.valueOf(j));
        if (remove != null) {
            this.coD.removeCallbacks(remove);
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
        if (this.coD != null) {
            this.coD.removeCallbacksAndMessages(null);
        }
        if (this.coG != null) {
            for (Map.Entry<Long, Runnable> entry : this.coG.entrySet()) {
                bg(entry.getKey().longValue());
            }
            this.coG.clear();
        }
        if (this.coE != null) {
            this.coE.clear();
        }
        if (this.coH != null) {
            this.coH.clear();
        }
    }
}
