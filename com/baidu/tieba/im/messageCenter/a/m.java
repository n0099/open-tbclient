package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.message.cd;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof cd)) {
            cd cdVar = (cd) sVar;
            if (!cdVar.l() && (cdVar.o() instanceof aq) && ((aq) cdVar.o()).f()) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                n.a(com.baidu.tieba.c.a.a().f(), "p_hot_groups_info" + str, dVar);
            }
        }
        return null;
    }
}
