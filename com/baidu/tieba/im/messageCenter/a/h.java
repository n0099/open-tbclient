package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bc;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.z;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof z)) {
            return null;
        }
        z zVar = (z) nVar;
        bz a = l.a(103002, com.baidu.tieba.b.a.a().e().a("pb_" + zVar.e() + "_" + zVar.d()));
        if (a == null) {
            a = new bc();
        }
        a.e(-201);
        a.a(nVar);
        return a;
    }
}
