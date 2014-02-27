package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.message.cd;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.im.messageCenter.c {
    @Override // com.baidu.tieba.im.messageCenter.c
    public final da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof aq)) {
            return a(-116, sVar);
        }
        int w = ((aq) sVar).w();
        String str = "";
        if (TiebaApplication.y() != null) {
            str = TiebaApplication.y().getID();
        }
        byte[] a = com.baidu.tieba.c.a.a().f().a("p_hot_groups_info" + str);
        if (a != null) {
            da a2 = n.a(103012, a);
            if (a2 == null) {
                return a(w, sVar);
            }
            a2.e(w);
            a2.a(sVar);
            return a2;
        }
        return a(w, sVar);
    }

    private static cd a(int i, com.baidu.tieba.im.message.s sVar) {
        cd cdVar = new cd();
        cdVar.e(i);
        cdVar.a(sVar);
        cdVar.g(-18);
        return cdVar;
    }
}
