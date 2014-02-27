package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.t;
import com.baidu.tieba.util.cb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.im.a<com.baidu.tieba.im.db.d> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(com.baidu.tieba.im.db.d dVar) {
        long j;
        boolean z;
        LinkedList linkedList;
        boolean z2;
        LinkedList linkedList2;
        LinkedList linkedList3;
        String str;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long j4;
        long j5;
        long j6;
        long j7;
        com.baidu.tieba.im.db.d dVar2 = dVar;
        if (dVar2 != null) {
            j = this.a.y;
            if (j > 0) {
                j4 = this.a.z;
                if (j4 > 0) {
                    j5 = this.a.z;
                    long j8 = (j5 - 1) * 100;
                    j6 = this.a.y;
                    ImMessageCenterPojo a = dVar2.a(String.valueOf(j6));
                    if (a == null) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        j7 = this.a.y;
                        imMessageCenterPojo.setGid(String.valueOf(j7));
                        imMessageCenterPojo.setPulled_msgId(j8);
                        dVar2.a(imMessageCenterPojo);
                    } else if (0 == a.getPulled_msgId() || a.getIs_delete() == 1) {
                        a.setPulled_msgId(j8);
                    }
                }
            }
            if (com.baidu.tieba.im.i.a() > 10) {
                com.baidu.adp.lib.util.e.d("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
                handler3 = this.a.u;
                handler4 = this.a.u;
                handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
            } else if (com.baidu.tieba.im.db.h.a().b()) {
                this.a.f = com.baidu.tieba.im.messageCenter.d.a().b(202003);
                z = this.a.f;
                if (z) {
                    return;
                }
                if (TiebaApplication.g().as()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.a.l;
                    if (currentTimeMillis - j2 > 60000) {
                        j3 = this.a.j;
                        if (currentTimeMillis - j3 < 180000) {
                            i = this.a.k;
                            if (i < 20) {
                                a aVar = this.a;
                                i2 = aVar.k;
                                aVar.k = i2 + 1;
                                StringBuilder sb = new StringBuilder("----background pull skip. no pull count ");
                                i3 = this.a.k;
                                com.baidu.adp.lib.util.e.d(sb.append(i3).toString());
                                return;
                            }
                        }
                    }
                }
                com.baidu.adp.lib.util.e.d("----real pull msg.");
                this.a.k = 0;
                linkedList = this.a.h;
                linkedList.clear();
                z2 = this.a.x;
                if (z2) {
                    this.a.i = "active";
                } else {
                    this.a.i = "passive";
                }
                t j9 = a.j(this.a);
                this.a.h = new LinkedList();
                dVar2.a(new d(this));
                List<GroupMidData> b = j9.b();
                linkedList2 = this.a.h;
                b.addAll(linkedList2);
                this.a.g = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(200);
                linkedList3 = this.a.h;
                Iterator it = linkedList3.iterator();
                while (it.hasNext()) {
                    GroupMidData groupMidData = (GroupMidData) it.next();
                    sb2.append(groupMidData.getGroupId());
                    sb2.append("-");
                    sb2.append(groupMidData.getLastMsgId());
                    sb2.append("|");
                }
                int v = j9.v();
                str = this.a.i;
                cb.a(202003, v, str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb2.toString());
                com.baidu.adp.lib.util.e.e(sb2.toString());
                com.baidu.tieba.im.messageCenter.d.a().a(j9);
            } else {
                com.baidu.adp.lib.util.e.d("----pull message, but cache is initing... ");
                handler = this.a.u;
                handler2 = this.a.u;
                handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
            }
        }
    }
}
