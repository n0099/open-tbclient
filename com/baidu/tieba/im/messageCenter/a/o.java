package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cg;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        cg cgVar;
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.k)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
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
