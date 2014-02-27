package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cg;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof cg)) {
            cg cgVar = (cg) sVar;
            if (!cgVar.l() && (cgVar.a() == null || cgVar.a().getOffset() == 0)) {
                String str = "";
                if (TiebaApplication.y() != null) {
                    str = TiebaApplication.y().getID();
                }
                n.a(com.baidu.tieba.c.a.a().s(), "p_nearby_group_info" + str, dVar);
            }
        }
        return null;
    }
}
