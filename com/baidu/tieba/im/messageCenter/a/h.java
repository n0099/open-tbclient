package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ao;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof ao)) {
            return a(103004, sVar);
        }
        ao aoVar = (ao) sVar;
        int w = aoVar.w();
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.c.a.a().q().a("group_info" + str + aoVar.b());
        if (a != null) {
            da a2 = n.a(103004, a);
            if (a2 == null) {
                return a(w, sVar);
            }
            a2.e(w);
            a2.a(sVar);
            return a2;
        }
        return a(w, sVar);
    }

    private ca a(int i, com.baidu.tieba.im.message.s sVar) {
        ca caVar = new ca();
        caVar.e(i);
        caVar.g(-18);
        caVar.a(sVar);
        return caVar;
    }
}
