package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.t;
import com.baidu.tieba.util.cb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<com.baidu.tieba.im.db.d> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(com.baidu.tieba.im.db.d dVar) {
        long j;
        boolean z;
        LinkedList linkedList;
        boolean z2;
        t q;
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
        if (dVar != null) {
            j = this.a.x;
            if (j > 0) {
                j4 = this.a.y;
                if (j4 > 0) {
                    j5 = this.a.y;
                    long b = be.b(j5 - 1);
                    j6 = this.a.x;
                    ImMessageCenterPojo a = dVar.a(String.valueOf(j6));
                    if (a == null) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        j7 = this.a.x;
                        imMessageCenterPojo.setGid(String.valueOf(j7));
                        imMessageCenterPojo.setPulled_msgId(b);
                        dVar.a(imMessageCenterPojo);
                    } else if (0 == a.getPulled_msgId() || a.getIs_delete() == 1) {
                        a.setPulled_msgId(b);
                    }
                }
            }
            if (com.baidu.tieba.im.j.a() > 10) {
                com.baidu.adp.lib.util.f.d("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
                handler3 = this.a.t;
                handler4 = this.a.t;
                handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
            } else if (!com.baidu.tieba.im.db.h.a().b()) {
                com.baidu.adp.lib.util.f.d("----pull message, but cache is initing... ");
                handler = this.a.t;
                handler2 = this.a.t;
                handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
            } else {
                this.a.f = com.baidu.tieba.im.messageCenter.e.a().b(202003);
                z = this.a.f;
                if (!z) {
                    if (TiebaApplication.g().az()) {
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
                                    com.baidu.adp.lib.util.f.d(sb.append(i3).toString());
                                    return;
                                }
                            }
                        }
                    }
                    com.baidu.adp.lib.util.f.d("----real pull msg.");
                    this.a.k = 0;
                    linkedList = this.a.h;
                    linkedList.clear();
                    z2 = this.a.w;
                    if (z2) {
                        this.a.i = "active";
                    } else {
                        this.a.i = "passive";
                    }
                    q = this.a.q();
                    this.a.h = new LinkedList();
                    dVar.a(new d(this));
                    List<GroupMidData> g = q.g();
                    linkedList2 = this.a.h;
                    g.addAll(linkedList2);
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
                    int v = q.v();
                    str = this.a.i;
                    cb.a(202003, v, str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb2.toString());
                    com.baidu.adp.lib.util.f.e(sb2.toString());
                    com.baidu.tieba.im.messageCenter.e.a().a(q);
                }
            }
        }
    }
}
