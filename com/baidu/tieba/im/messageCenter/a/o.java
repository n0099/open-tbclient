package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        bg bgVar;
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.h)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_group_info" + str);
        bg bgVar2 = new bg();
        if (a != null) {
            try {
                bgVar = (bg) l.a(103003, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bgVar.e(-106);
            return bgVar;
        }
        bgVar = bgVar2;
        bgVar.e(-106);
        return bgVar;
    }
}
