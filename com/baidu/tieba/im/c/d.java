package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.tieba.im.chat.aa;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.m;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.util.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f1395a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, boolean z) {
        this.d = aVar;
        this.f1395a = j;
        this.b = j2;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        LinkedList linkedList;
        MessageSyncMessage r;
        LinkedList linkedList2;
        LinkedList linkedList3;
        String str;
        int i;
        LinkedList linkedList4;
        Handler handler;
        Handler handler2;
        if (concurrentHashMap != null) {
            if (this.f1395a > 0 && this.b > 0) {
                long b = aa.b(this.b - 1);
                ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(String.valueOf(this.f1395a));
                if (imMessageCenterPojo == null) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setGid(String.valueOf(this.f1395a));
                    imMessageCenterPojo2.setLast_msgId(b);
                    imMessageCenterPojo2.setPulled_msgId(b);
                    concurrentHashMap.put(String.valueOf(this.f1395a), imMessageCenterPojo2);
                } else if (0 == imMessageCenterPojo.getPulled_msgId() || imMessageCenterPojo.getIs_delete() == 1) {
                    imMessageCenterPojo.setPulled_msgId(b);
                }
            }
            if (m.a() <= 10) {
                linkedList = this.d.w;
                linkedList.clear();
                if (this.c) {
                    this.d.y = "active";
                } else {
                    this.d.y = "passive";
                }
                r = this.d.r();
                this.d.w = new LinkedList();
                for (String str2 : concurrentHashMap.keySet()) {
                    ImMessageCenterPojo imMessageCenterPojo3 = concurrentHashMap.get(str2);
                    if (imMessageCenterPojo3.getIs_delete() == 0) {
                        long c = aa.c(imMessageCenterPojo3.getPulled_msgId());
                        if (c != 0) {
                            GroupMidData groupMidData = new GroupMidData();
                            groupMidData.setGroupId(Long.parseLong(imMessageCenterPojo3.getGid()));
                            groupMidData.setLastMsgId(c);
                            linkedList4 = this.d.w;
                            linkedList4.add(groupMidData);
                        }
                    }
                }
                List<GroupMidData> groupMids = r.getGroupMids();
                linkedList2 = this.d.w;
                groupMids.addAll(linkedList2);
                this.d.v = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder(200);
                linkedList3 = this.d.w;
                Iterator it = linkedList3.iterator();
                while (it.hasNext()) {
                    GroupMidData groupMidData2 = (GroupMidData) it.next();
                    sb.append(groupMidData2.getGroupId());
                    sb.append("-");
                    sb.append(groupMidData2.getLastMsgId());
                    sb.append("|");
                }
                str = this.d.y;
                o.a(202003, 0, str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb.toString());
                com.baidu.tieba.im.messageCenter.f a2 = com.baidu.tieba.im.messageCenter.f.a();
                i = a.q;
                a2.a(r, true, 0, 1, i);
                return;
            }
            com.baidu.adp.lib.h.d.c("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
            handler = this.d.D;
            handler2 = this.d.D;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
