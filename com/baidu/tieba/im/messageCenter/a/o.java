package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bj;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        bj bjVar;
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.i)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_group_info" + str);
        bj bjVar2 = new bj();
        if (a != null) {
            try {
                bjVar = (bj) l.a(103003, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bjVar.e(-106);
            return bjVar;
        }
        bjVar = bjVar2;
        bjVar.e(-106);
        return bjVar;
    }
}
