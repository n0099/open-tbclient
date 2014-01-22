package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.ck;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof av)) {
            return null;
        }
        long b = ((av) qVar).b();
        ck ckVar = new ck();
        ckVar.e(-204);
        ckVar.a(qVar);
        ckVar.g(0);
        ckVar.a(b);
        String str = b + "";
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
        h.a(str, h.a(str));
        return ckVar;
    }
}
