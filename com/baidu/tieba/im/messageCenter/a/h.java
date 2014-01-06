package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ac;
import com.baidu.tieba.im.message.bf;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ac)) {
            return null;
        }
        ac acVar = (ac) oVar;
        cc a = l.a(103002, com.baidu.tieba.b.a.a().e().a("pb_" + acVar.e() + "_" + acVar.d()));
        if (a == null) {
            a = new bf();
        }
        a.e(-201);
        a.a(oVar);
        return a;
    }
}
