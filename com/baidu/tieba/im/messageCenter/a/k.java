package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.al;
import com.baidu.tieba.im.message.bx;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar == null || !(sVar instanceof bx)) {
            return null;
        }
        bx bxVar = (bx) sVar;
        com.baidu.tieba.im.message.s o = bxVar.o();
        if (o != null && (o instanceof al) && !bxVar.l()) {
            al alVar = (al) o;
            n.a(com.baidu.tieba.c.a.a().e(), "pb_" + alVar.c() + "_" + alVar.b(), dVar);
            return sVar;
        }
        return sVar;
    }
}
