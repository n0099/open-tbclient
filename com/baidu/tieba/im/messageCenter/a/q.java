package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bs;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        bs bsVar;
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.w)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_enter_forum_group_info_" + str);
        bs bsVar2 = new bs();
        if (a != null) {
            try {
                bsVar = (bs) l.a(103011, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bsVar.e(-114);
            return bsVar;
        }
        bsVar = bsVar2;
        bsVar.e(-114);
        return bsVar;
    }
}
