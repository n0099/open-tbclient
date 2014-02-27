package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.al;
import com.baidu.tieba.im.message.bx;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.c {
    @Override // com.baidu.tieba.im.messageCenter.c
    public final da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof al)) {
            return null;
        }
        al alVar = (al) sVar;
        da a = n.a(103002, com.baidu.tieba.c.a.a().e().a("pb_" + alVar.c() + "_" + alVar.b()));
        if (a == null) {
            a = new bx();
        }
        a.e(-201);
        a.a(sVar);
        return a;
    }
}
