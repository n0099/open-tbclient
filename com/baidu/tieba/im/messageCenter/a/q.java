package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bp;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        bp bpVar;
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.t)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_enter_forum_group_info_" + str);
        bp bpVar2 = new bp();
        if (a != null) {
            try {
                bpVar = (bp) l.a(103011, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bpVar.e(-114);
            return bpVar;
        }
        bpVar = bpVar2;
        bpVar.e(-114);
        return bpVar;
    }
}
