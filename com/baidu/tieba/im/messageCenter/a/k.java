package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ak;
import com.baidu.tieba.im.message.bu;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar != null && (qVar instanceof bu)) {
            bu buVar = (bu) qVar;
            if (!buVar.k() && (buVar.n() instanceof ak) && ((ak) buVar.n()).f()) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                l.a(com.baidu.tieba.b.a.a().f(), "p_hot_groups_info" + str, dVar);
            }
        }
        return null;
    }
}
