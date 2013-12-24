package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ab;
import com.baidu.tieba.im.message.be;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof ab)) {
            return a(103004, nVar);
        }
        ab abVar = (ab) nVar;
        int t = abVar.t();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().q().a("group_info" + str + abVar.b());
        if (a != null) {
            bz a2 = l.a(103004, a);
            if (a2 == null) {
                return a(t, nVar);
            }
            a2.e(t);
            a2.a(nVar);
            return a2;
        }
        return a(t, nVar);
    }

    private be a(int i, com.baidu.tieba.im.message.n nVar) {
        be beVar = new be();
        beVar.e(i);
        beVar.c(-18);
        beVar.a(nVar);
        return beVar;
    }
}
