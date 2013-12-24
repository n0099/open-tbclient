package com.baidu.tieba.im.b;

import com.baidu.tieba.im.c.m;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.bl;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.log.i;
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
    public void a(n nVar) {
        Map a;
        if (nVar != null) {
            if (nVar.t() == 1003) {
                if ((nVar instanceof bz) && !((bz) nVar).i()) {
                    this.a.m();
                }
            } else if (nVar.t() == 202003) {
                this.a.j = System.currentTimeMillis();
                a = this.a.a(nVar);
                if (a == null || a.size() <= 0) {
                    this.a.k();
                } else {
                    this.a.a(a);
                }
            } else if (nVar.t() == 1001) {
                if (!(nVar instanceof bl)) {
                    this.a.a(nVar.t(), -1, (String) null);
                    return;
                }
                bl blVar = (bl) nVar;
                if (blVar.i()) {
                    this.a.a(nVar.t(), blVar.j(), blVar.k());
                    return;
                }
                LinkedList linkedList = new LinkedList();
                LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                LinkedList linkedList2 = new LinkedList();
                this.a.j();
                com.baidu.tieba.log.a.b(i.a(1001, 0, null, "online succ", null, blVar.j(), blVar.k()));
                if (blVar.a() != null) {
                    com.baidu.tieba.im.c.a.h().a(blVar.a());
                    for (GroupUpdateMessage groupUpdateMessage : blVar.a()) {
                        if (groupUpdateMessage != null) {
                            linkedList.add(String.valueOf(groupUpdateMessage.getGroupId()));
                            if (groupUpdateMessage.getGroupType() == 6) {
                                if (groupUpdateMessage.getGroupId() != 0 && com.baidu.tieba.im.chat.a.a != groupUpdateMessage.getGroupId()) {
                                    com.baidu.tieba.im.chat.a.a(groupUpdateMessage.getGroupId());
                                    com.baidu.adp.lib.h.e.d("see online1 gid Online=" + groupUpdateMessage.getGroupId());
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
                ad.a().a(new f(this, blVar, linkedList2, linkedList));
            } else if (nVar.t() == -11 && (nVar instanceof com.baidu.tieba.im.message.a)) {
                if (((com.baidu.tieba.im.message.a) nVar).a()) {
                    this.a.g();
                } else {
                    this.a.f();
                }
            }
        }
    }
}
