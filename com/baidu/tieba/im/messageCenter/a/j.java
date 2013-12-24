package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ad;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof ad)) {
            return a(-116, nVar);
        }
        int t = ((ad) nVar).t();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().f().a("p_hot_groups_info" + str);
        if (a != null) {
            bz a2 = l.a(103012, a);
            if (a2 == null) {
                return a(t, nVar);
            }
            a2.e(t);
            a2.a(nVar);
            return a2;
        }
        return a(t, nVar);
    }

    private bh a(int i, com.baidu.tieba.im.message.n nVar) {
        bh bhVar = new bh();
        bhVar.e(i);
        bhVar.a(nVar);
        bhVar.c(-18);
        return bhVar;
    }
}
