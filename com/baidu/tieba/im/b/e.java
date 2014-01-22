package com.baidu.tieba.im.b;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.c.m;
import com.baidu.tieba.im.db.ae;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.im.message.cl;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.util.by;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ a a;

    private e(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, b bVar) {
        this(aVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        long j;
        long j2;
        Map a;
        if (qVar != null) {
            if (qVar.w() == 1003) {
                if ((qVar instanceof cr) && !((cr) qVar).k()) {
                    this.a.m();
                }
            } else if (qVar.w() == 202003) {
                this.a.j = System.currentTimeMillis();
                j = this.a.j;
                j2 = this.a.g;
                by.b(j - j2);
                if (qVar instanceof ca) {
                    int b = ((ca) qVar).b();
                    TiebaApplication.h().y(b == 1);
                    if (b == 1) {
                        com.baidu.tieba.im.messageCenter.e.a().d(new cl());
                    }
                }
                a = this.a.a(qVar);
                if (a == null || a.size() <= 0) {
                    this.a.k();
                } else {
                    this.a.a(a);
                }
            } else if (qVar.w() == 1001) {
                if (!(qVar instanceof com.baidu.tieba.im.message.by)) {
                    this.a.a(qVar.w(), -1, (String) null);
                    return;
                }
                com.baidu.tieba.im.message.by byVar = (com.baidu.tieba.im.message.by) qVar;
                if (byVar.k()) {
                    this.a.a(qVar.w(), byVar.l(), byVar.m());
                    return;
                }
                LinkedList linkedList = new LinkedList();
                LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                LinkedList linkedList2 = new LinkedList();
                this.a.j();
                by.a(1001, 0, null, "online succ", null, byVar.l(), byVar.m());
                if (byVar.a() != null) {
                    com.baidu.tieba.im.c.a.h().a(byVar.a());
                    for (GroupUpdateMessage groupUpdateMessage : byVar.a()) {
                        if (groupUpdateMessage != null) {
                            linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            if (groupUpdateMessage.getGroupType() == 6) {
                                if (groupUpdateMessage.getGroupId() != 0 && com.baidu.tieba.im.chat.q.a != groupUpdateMessage.getGroupId()) {
                                    com.baidu.tieba.im.chat.q.a(groupUpdateMessage.getGroupId());
                                    com.baidu.adp.lib.g.e.d("see online1 gid Online=" + groupUpdateMessage.getGroupId());
                                }
                            } else {
                                linkedHashMap.put(String.valueOf(groupUpdateMessage.getGroupId()), Long.valueOf(groupUpdateMessage.getLastMsgId()));
                            }
                            if (groupUpdateMessage.getGroupType() == 1) {
                                m.a().a(String.valueOf(groupUpdateMessage.getGroupId()));
                            }
                        }
                    }
                    com.baidu.tieba.im.db.d.a().a(linkedHashMap, (com.baidu.tieba.im.a<Void>) null);
                }
                ae.a().a(new f(this, byVar, linkedList2, linkedList));
            } else if (qVar.w() == -11 && (qVar instanceof com.baidu.tieba.im.message.a)) {
                if (((com.baidu.tieba.im.message.a) qVar).a()) {
                    this.a.h();
                } else {
                    this.a.g();
                }
            }
        }
    }
}
