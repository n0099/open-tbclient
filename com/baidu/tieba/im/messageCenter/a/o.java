package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cg;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.c {
    @Override // com.baidu.tieba.im.messageCenter.c
    public final da a(com.baidu.tieba.im.message.s sVar) {
        cg cgVar;
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.k)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.y() != null) {
            str = TiebaApplication.y().getID();
        }
        byte[] a = com.baidu.tieba.c.a.a().s().a("p_nearby_group_info" + str);
        cg cgVar2 = new cg();
        if (a != null) {
            try {
                cgVar = (cg) n.a(103009, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cgVar.e(-115);
            return cgVar;
        }
        cgVar = cgVar2;
        cgVar.e(-115);
        return cgVar;
    }
}
