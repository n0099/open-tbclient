package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bn;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar != null && (oVar instanceof bn)) {
            bn bnVar = (bn) oVar;
            if (!bnVar.i() && (bnVar.a() == null || bnVar.a().getOffset() == 0)) {
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
