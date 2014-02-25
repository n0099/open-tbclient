package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.da;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        LinkedList<CommonMsgPojo> a;
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.q)) {
            com.baidu.adp.lib.util.f.b("message error");
            return a(SapiErrorCode.GET_CERT_FAIL);
        }
        com.baidu.tieba.im.message.q qVar = (com.baidu.tieba.im.message.q) sVar;
        com.baidu.tieba.im.message.r rVar = new com.baidu.tieba.im.message.r();
        if (qVar.f() == 0) {
            a = com.baidu.tieba.im.db.b.a().a(qVar.d(), qVar.b(), qVar.a(), qVar.c());
        } else {
            a = com.baidu.tieba.im.db.q.a().a(qVar.e(), qVar.b(), qVar.a(), qVar.c());
        }
        LinkedList linkedList = new LinkedList();
        if (a == null) {
            com.baidu.adp.lib.util.f.b("read DB error");
            return a(qVar.w());
        }
        Iterator<CommonMsgPojo> it = a.iterator();
        while (it.hasNext()) {
            linkedList.add(0, it.next().toChatMessage());
        }
        if (qVar.b() == null) {
            rVar.a(true);
        } else {
            rVar.a(false);
        }
        rVar.a(qVar.d());
        rVar.a(qVar.e());
        rVar.a(linkedList);
        rVar.a(qVar.f());
        return rVar;
    }

    private com.baidu.tieba.im.message.r a(int i) {
        com.baidu.tieba.im.message.r rVar = new com.baidu.tieba.im.message.r();
        rVar.e(i);
        rVar.g(-18);
        return rVar;
    }
}
