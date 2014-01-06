package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ag;
import com.baidu.tieba.im.message.bk;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ag)) {
            return a(-116, oVar);
        }
        int u = ((ag) oVar).u();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().f().a("p_hot_groups_info" + str);
        if (a != null) {
            cc a2 = l.a(103012, a);
            if (a2 == null) {
                return a(u, oVar);
            }
            a2.e(u);
            a2.a(oVar);
            return a2;
        }
        return a(u, oVar);
    }

    private bk a(int i, com.baidu.tieba.im.message.o oVar) {
        bk bkVar = new bk();
        bkVar.e(i);
        bkVar.a(oVar);
        bkVar.g(-18);
        return bkVar;
    }
}
