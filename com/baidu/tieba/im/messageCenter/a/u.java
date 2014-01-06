package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ap;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ap)) {
            return null;
        }
        long b = ((ap) oVar).b();
        by byVar = new by();
        byVar.e(-204);
        byVar.a(oVar);
        byVar.g(0);
        byVar.a(b);
        String str = b + "";
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
        h.a(str, h.a(str));
        return byVar;
    }
}
