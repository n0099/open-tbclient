package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ak;
import com.baidu.tieba.im.message.bu;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof ak)) {
            return a(-116, qVar);
        }
        int w = ((ak) qVar).w();
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().f().a("p_hot_groups_info" + str);
        if (a != null) {
            cr a2 = l.a(103012, a);
            if (a2 == null) {
                return a(w, qVar);
            }
            a2.e(w);
            a2.a(qVar);
            return a2;
        }
        return a(w, qVar);
    }

    private bu a(int i, com.baidu.tieba.im.message.q qVar) {
        bu buVar = new bu();
        buVar.e(i);
        buVar.a(qVar);
        buVar.g(-18);
        return buVar;
    }
}
