package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.message.cd;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof cd)) {
            cd cdVar = (cd) sVar;
            if (!cdVar.l() && (cdVar.o() instanceof aq) && ((aq) cdVar.o()).b()) {
                String str = "";
                if (TiebaApplication.y() != null) {
                    str = TiebaApplication.y().getID();
                }
                n.a(com.baidu.tieba.c.a.a().f(), "p_hot_groups_info" + str, dVar);
            }
        }
        return null;
    }
}
