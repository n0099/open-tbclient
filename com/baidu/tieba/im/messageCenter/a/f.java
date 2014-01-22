package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ai;
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof ai)) {
            return a(103004, qVar);
        }
        ai aiVar = (ai) qVar;
        int w = aiVar.w();
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().q().a("group_info" + str + aiVar.b());
        if (a != null) {
            cr a2 = l.a(103004, a);
            if (a2 == null) {
                return a(w, qVar);
            }
            a2.e(w);
            a2.a(qVar);
            return a2;
        }
        return a(w, qVar);
    }

    private br a(int i, com.baidu.tieba.im.message.q qVar) {
        br brVar = new br();
        brVar.e(i);
        brVar.g(-18);
        brVar.a(qVar);
        return brVar;
    }
}
