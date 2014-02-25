package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.al;
import com.baidu.tieba.im.message.bx;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof al)) {
            return null;
        }
        al alVar = (al) sVar;
        da a = n.a(103002, com.baidu.tieba.c.a.a().e().a("pb_" + alVar.e() + "_" + alVar.d()));
        if (a == null) {
            a = new bx();
        }
        a.e(-201);
        a.a(sVar);
        return a;
    }
}
