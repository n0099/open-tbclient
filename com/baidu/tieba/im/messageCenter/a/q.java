package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.y;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        cc ccVar;
        if (qVar == null || !(qVar instanceof y)) {
            return null;
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_enter_forum_group_info");
        cc ccVar2 = new cc();
        if (a != null) {
            try {
                ccVar = (cc) l.a(103011, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ccVar.e(-114);
            return ccVar;
        }
        ccVar = ccVar2;
        ccVar.e(-114);
        return ccVar;
    }
}
