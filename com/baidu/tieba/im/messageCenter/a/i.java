package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bc;
import com.baidu.tieba.im.message.z;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar == null || !(nVar instanceof bc)) {
            return null;
        }
        bc bcVar = (bc) nVar;
        com.baidu.tieba.im.message.n l = bcVar.l();
        if (l != null && (l instanceof z) && !bcVar.i()) {
            z zVar = (z) l;
            l.a(com.baidu.tieba.b.a.a().e(), "pb_" + zVar.e() + "_" + zVar.d(), dVar);
            return nVar;
        }
        return nVar;
    }
}
