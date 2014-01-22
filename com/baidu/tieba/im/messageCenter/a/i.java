package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ag;
import com.baidu.tieba.im.message.bp;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar == null || !(qVar instanceof bp)) {
            return null;
        }
        bp bpVar = (bp) qVar;
        com.baidu.tieba.im.message.q n = bpVar.n();
        if (n != null && (n instanceof ag) && !bpVar.k()) {
            ag agVar = (ag) n;
            l.a(com.baidu.tieba.b.a.a().e(), "pb_" + agVar.e() + "_" + agVar.d(), dVar);
            return qVar;
        }
        return qVar;
    }
}
