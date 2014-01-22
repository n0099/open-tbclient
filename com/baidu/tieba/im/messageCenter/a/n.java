package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bx;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar != null && (qVar instanceof bx)) {
            bx bxVar = (bx) qVar;
            if (!bxVar.k() && (bxVar.a() == null || bxVar.a().getOffset() == 0)) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                l.a(com.baidu.tieba.b.a.a().r(), "p_nearby_group_info" + str, dVar);
            }
        }
        return null;
    }
}
