package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bj;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar != null && (oVar instanceof bj) && !((bj) oVar).i()) {
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            l.a(com.baidu.tieba.b.a.a().r(), "p_group_info" + str, dVar);
        }
        return null;
    }
}
