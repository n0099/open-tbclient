package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof am)) {
            return null;
        }
        long b = ((am) nVar).b();
        bv bvVar = new bv();
        bvVar.e(-204);
        bvVar.a(nVar);
        bvVar.c(0);
        bvVar.a(b);
        String str = b + "";
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
        h.a(str, h.a(str));
        return bvVar;
    }
}
