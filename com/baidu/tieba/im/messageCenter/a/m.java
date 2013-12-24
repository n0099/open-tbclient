package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bk;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        bk bkVar;
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.g)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_nearby_group_info" + str);
        bk bkVar2 = new bk();
        if (a != null) {
            try {
                bkVar = (bk) l.a(103009, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bkVar.e(-115);
            return bkVar;
        }
        bkVar = bkVar2;
        bkVar.e(-115);
        return bkVar;
    }
}
