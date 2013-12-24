package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ad;
import com.baidu.tieba.im.message.bh;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar != null && (nVar instanceof bh)) {
            bh bhVar = (bh) nVar;
            if (!bhVar.i() && (bhVar.l() instanceof ad) && ((ad) bhVar.l()).f()) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                l.a(com.baidu.tieba.b.a.a().f(), "p_hot_groups_info" + str, dVar);
            }
        }
        return null;
    }
}
