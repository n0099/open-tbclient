package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bk;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar != null && (nVar instanceof bk)) {
            bk bkVar = (bk) nVar;
            if (!bkVar.i() && (bkVar.a() == null || bkVar.a().getOffset() == 0)) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                l.a(com.baidu.tieba.b.a.a().r(), "p_nearby_group_info" + str, dVar);
            }
        }
        return null;
    }
}
