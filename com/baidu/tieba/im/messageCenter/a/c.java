package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.db.ar;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.bz;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        LinkedList<CommonMsgPojo> a;
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.l)) {
            com.baidu.adp.lib.h.e.a("message error");
            return a(-105);
        }
        com.baidu.tieba.im.message.l lVar = (com.baidu.tieba.im.message.l) nVar;
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        if (lVar.f() == 0) {
            a = com.baidu.tieba.im.db.d.a().a(lVar.d(), lVar.b(), lVar.a(), lVar.c());
        } else {
            a = ar.a().a(lVar.e(), lVar.b(), lVar.a(), lVar.c());
        }
        LinkedList linkedList = new LinkedList();
        if (a == null) {
            com.baidu.adp.lib.h.e.a("read DB error");
            return a(lVar.t());
        }
        Iterator<CommonMsgPojo> it = a.iterator();
        while (it.hasNext()) {
            linkedList.add(0, it.next().toChatMessage());
        }
        if (lVar.b() == null) {
            mVar.a(true);
        } else {
            mVar.a(false);
        }
        mVar.a(lVar.d());
        mVar.a(lVar.e());
        mVar.a(linkedList);
        mVar.a(lVar.f());
        return mVar;
    }

    private com.baidu.tieba.im.message.m a(int i) {
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        mVar.e(i);
        mVar.c(-18);
        return mVar;
    }
}
