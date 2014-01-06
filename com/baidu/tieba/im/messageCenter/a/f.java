package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ae;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ae)) {
            return a(103004, oVar);
        }
        ae aeVar = (ae) oVar;
        int u = aeVar.u();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().q().a("group_info" + str + aeVar.b());
        if (a != null) {
            cc a2 = l.a(103004, a);
            if (a2 == null) {
                return a(u, oVar);
            }
            a2.e(u);
            a2.a(oVar);
            return a2;
        }
        return a(u, oVar);
    }

    private bh a(int i, com.baidu.tieba.im.message.o oVar) {
        bh bhVar = new bh();
        bhVar.e(i);
        bhVar.g(-18);
        bhVar.a(oVar);
        return bhVar;
    }
}
