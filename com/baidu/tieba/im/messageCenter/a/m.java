package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bx;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        bx bxVar;
        if (qVar == null || !(qVar instanceof com.baidu.tieba.im.message.j)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_nearby_group_info" + str);
        bx bxVar2 = new bx();
        if (a != null) {
            try {
                bxVar = (bx) l.a(103009, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bxVar.e(-115);
            return bxVar;
        }
        bxVar = bxVar2;
        bxVar.e(-115);
        return bxVar;
    }
}
