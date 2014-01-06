package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ag;
import com.baidu.tieba.im.message.bk;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar != null && (oVar instanceof bk)) {
            bk bkVar = (bk) oVar;
            if (!bkVar.i() && (bkVar.l() instanceof ag) && ((ag) bkVar.l()).f()) {
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
