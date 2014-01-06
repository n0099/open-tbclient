package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        bn bnVar;
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.h)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_nearby_group_info" + str);
        bn bnVar2 = new bn();
        if (a != null) {
            try {
                bnVar = (bn) l.a(103009, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bnVar.e(-115);
            return bnVar;
        }
        bnVar = bnVar2;
        bnVar.e(-115);
        return bnVar;
    }
}
