package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.im.db.au;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.cr;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        LinkedList<CommonMsgPojo> a;
        if (qVar == null || !(qVar instanceof com.baidu.tieba.im.message.o)) {
            com.baidu.adp.lib.g.e.a("message error");
            return a(SapiErrorCode.GET_CERT_FAIL);
        }
        com.baidu.tieba.im.message.o oVar = (com.baidu.tieba.im.message.o) qVar;
        com.baidu.tieba.im.message.p pVar = new com.baidu.tieba.im.message.p();
        if (oVar.f() == 0) {
            a = com.baidu.tieba.im.db.d.a().a(oVar.d(), oVar.b(), oVar.a(), oVar.c());
        } else {
            a = au.a().a(oVar.e(), oVar.b(), oVar.a(), oVar.c());
        }
        LinkedList linkedList = new LinkedList();
        if (a == null) {
            com.baidu.adp.lib.g.e.a("read DB error");
            return a(oVar.w());
        }
        Iterator<CommonMsgPojo> it = a.iterator();
        while (it.hasNext()) {
            linkedList.add(0, it.next().toChatMessage());
        }
        if (oVar.b() == null) {
            pVar.a(true);
        } else {
            pVar.a(false);
        }
        pVar.a(oVar.d());
        pVar.a(oVar.e());
        pVar.a(linkedList);
        pVar.a(oVar.f());
        return pVar;
    }

    private com.baidu.tieba.im.message.p a(int i) {
        com.baidu.tieba.im.message.p pVar = new com.baidu.tieba.im.message.p();
        pVar.e(i);
        pVar.g(-18);
        return pVar;
    }
}
