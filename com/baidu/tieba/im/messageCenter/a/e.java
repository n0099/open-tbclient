package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.messageCenter.c {
    @Override // com.baidu.tieba.im.messageCenter.c
    public final da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof am)) {
            return a(-127, sVar);
        }
        am amVar = (am) sVar;
        int w = amVar.w();
        String str = "";
        if (TiebaApplication.y() != null) {
            str = TiebaApplication.y().getID();
        }
        byte[] a = com.baidu.tieba.c.a.a().r().a("group_activity" + str + amVar.b());
        if (a != null) {
            da a2 = n.a(103015, a);
            if (a2 == null) {
                return a(w, sVar);
            }
            a2.e(w);
            a2.a(sVar);
            return a2;
        }
        return a(w, sVar);
    }

    private static by a(int i, com.baidu.tieba.im.message.s sVar) {
        by byVar = new by();
        byVar.e(i);
        byVar.g(-18);
        byVar.a(sVar);
        return byVar;
    }
}
