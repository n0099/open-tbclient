package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.db.as;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.cc;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        LinkedList<CommonMsgPojo> a;
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.m)) {
            com.baidu.adp.lib.h.e.a("message error");
            return a(-105);
        }
        com.baidu.tieba.im.message.m mVar = (com.baidu.tieba.im.message.m) oVar;
        com.baidu.tieba.im.message.n nVar = new com.baidu.tieba.im.message.n();
        if (mVar.f() == 0) {
            a = com.baidu.tieba.im.db.d.a().a(mVar.d(), mVar.b(), mVar.a(), mVar.c());
        } else {
            a = as.a().a(mVar.e(), mVar.b(), mVar.a(), mVar.c());
        }
        LinkedList linkedList = new LinkedList();
        if (a == null) {
            com.baidu.adp.lib.h.e.a("read DB error");
            return a(mVar.u());
        }
        Iterator<CommonMsgPojo> it = a.iterator();
        while (it.hasNext()) {
            linkedList.add(0, it.next().toChatMessage());
        }
        if (mVar.b() == null) {
            nVar.a(true);
        } else {
            nVar.a(false);
        }
        nVar.a(mVar.d());
        nVar.a(mVar.e());
        nVar.a(linkedList);
        nVar.a(mVar.f());
        return nVar;
    }

    private com.baidu.tieba.im.message.n a(int i) {
        com.baidu.tieba.im.message.n nVar = new com.baidu.tieba.im.message.n();
        nVar.e(i);
        nVar.g(-18);
        return nVar;
    }
}
