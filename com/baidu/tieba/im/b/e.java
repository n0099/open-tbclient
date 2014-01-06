package com.baidu.tieba.im.b;

import com.baidu.tieba.im.c.m;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.bo;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.o;
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
    public void a(o oVar) {
        Map a;
        if (oVar != null) {
            if (oVar.u() == 1003) {
                if ((oVar instanceof cc) && !((cc) oVar).i()) {
                    this.a.m();
                }
            } else if (oVar.u() == 202003) {
                this.a.j = System.currentTimeMillis();
                a = this.a.a(oVar);
                if (a == null || a.size() <= 0) {
                    this.a.k();
                } else {
                    this.a.a(a);
                }
            } else if (oVar.u() == 1001) {
                if (!(oVar instanceof bo)) {
                    this.a.a(oVar.u(), -1, (String) null);
                    return;
                }
                bo boVar = (bo) oVar;
                if (boVar.i()) {
                    this.a.a(oVar.u(), boVar.j(), boVar.k());
                    return;
                }
                LinkedList linkedList = new LinkedList();
                LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                LinkedList linkedList2 = new LinkedList();
                this.a.j();
                com.baidu.tieba.log.a.b(i.a(1001, 0, null, "online succ", null, boVar.j(), boVar.k()));
                if (boVar.a() != null) {
                    com.baidu.tieba.im.c.a.h().a(boVar.a());
                    for (GroupUpdateMessage groupUpdateMessage : boVar.a()) {
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
                ad.a().a(new f(this, boVar, linkedList2, linkedList));
            } else if (oVar.u() == -11 && (oVar instanceof com.baidu.tieba.im.message.a)) {
                if (((com.baidu.tieba.im.message.a) oVar).a()) {
                    this.a.g();
                } else {
                    this.a.f();
                }
            }
        }
    }
}
