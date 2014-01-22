package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.m;
import com.baidu.tieba.im.message.r;
import com.baidu.tieba.util.by;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        long j;
        boolean z;
        LinkedList linkedList;
        boolean z2;
        r n;
        LinkedList linkedList2;
        LinkedList linkedList3;
        String str;
        LinkedList linkedList4;
        long j2;
        long j3;
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        if (concurrentHashMap != null) {
            j = this.a.t;
            if (j > 0) {
                j4 = this.a.u;
                if (j4 > 0) {
                    j5 = this.a.u;
                    long b = ba.b(j5 - 1);
                    j6 = this.a.t;
                    ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(String.valueOf(j6));
                    if (imMessageCenterPojo == null) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        j7 = this.a.t;
                        imMessageCenterPojo2.setGid(String.valueOf(j7));
                        imMessageCenterPojo2.setPulled_msgId(b);
                        j8 = this.a.t;
                        concurrentHashMap.put(String.valueOf(j8), imMessageCenterPojo2);
                    } else if (0 == imMessageCenterPojo.getPulled_msgId() || imMessageCenterPojo.getIs_delete() == 1) {
                        imMessageCenterPojo.setPulled_msgId(b);
                    }
                }
            }
            if (m.a() > 10) {
                com.baidu.adp.lib.g.e.c("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
                handler = this.a.p;
                handler2 = this.a.p;
                handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
                return;
            }
            this.a.f = com.baidu.tieba.im.messageCenter.e.a().b(202003);
            z = this.a.f;
            if (!z) {
                if (TiebaApplication.h().aA()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.a.l;
                    if (currentTimeMillis - j2 > 60000) {
                        j3 = this.a.j;
                        if (currentTimeMillis - j3 < 180000) {
                            i = this.a.k;
                            if (i < 20) {
                                a.i(this.a);
                                StringBuilder append = new StringBuilder().append("----background pull skip. no pull count ");
                                i2 = this.a.k;
                                com.baidu.adp.lib.g.e.c(append.append(i2).toString());
                                return;
                            }
                        }
                    }
                }
                com.baidu.adp.lib.g.e.c("----real pull msg.");
                this.a.k = 0;
                linkedList = this.a.h;
                linkedList.clear();
                z2 = this.a.s;
                if (z2) {
                    this.a.i = "active";
                } else {
                    this.a.i = "passive";
                }
                n = this.a.n();
                this.a.h = new LinkedList();
                for (String str2 : concurrentHashMap.keySet()) {
                    ImMessageCenterPojo imMessageCenterPojo3 = concurrentHashMap.get(str2);
                    if (imMessageCenterPojo3.getIs_delete() == 0) {
                        long c = ba.c(imMessageCenterPojo3.getPulled_msgId());
                        com.baidu.adp.lib.g.e.d("see online1 see pull1:" + imMessageCenterPojo3.getGid() + "lastMsgId:" + c);
                        if (c != 0) {
                            GroupMidData groupMidData = new GroupMidData();
                            groupMidData.setGroupId(Integer.parseInt(imMessageCenterPojo3.getGid()));
                            groupMidData.setLastMsgId(c);
                            com.baidu.adp.lib.g.e.d("see online1 see pull2:" + groupMidData.getGroupId() + " mid:" + c);
                            linkedList4 = this.a.h;
                            linkedList4.add(groupMidData);
                        }
                    }
                }
                List<GroupMidData> g = n.g();
                linkedList2 = this.a.h;
                g.addAll(linkedList2);
                this.a.g = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder(200);
                linkedList3 = this.a.h;
                Iterator it = linkedList3.iterator();
                while (it.hasNext()) {
                    GroupMidData groupMidData2 = (GroupMidData) it.next();
                    sb.append(groupMidData2.getGroupId());
                    sb.append("-");
                    sb.append(groupMidData2.getLastMsgId());
                    sb.append("|");
                }
                int v = n.v();
                str = this.a.i;
                by.a(202003, v, str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb.toString());
                com.baidu.tieba.im.messageCenter.e.a().a(n);
            }
        }
    }
}
