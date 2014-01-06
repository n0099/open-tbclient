package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ac;
import com.baidu.tieba.im.message.bf;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar == null || !(oVar instanceof bf)) {
            return null;
        }
        bf bfVar = (bf) oVar;
        com.baidu.tieba.im.message.o l = bfVar.l();
        if (l != null && (l instanceof ac) && !bfVar.i()) {
            ac acVar = (ac) l;
            l.a(com.baidu.tieba.b.a.a().e(), "pb_" + acVar.e() + "_" + acVar.d(), dVar);
            return oVar;
        }
        return oVar;
    }
}
