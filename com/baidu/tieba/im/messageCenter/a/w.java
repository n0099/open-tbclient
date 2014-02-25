package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bb;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof bb)) {
            return null;
        }
        long b = ((bb) sVar).b();
        ct ctVar = new ct();
        ctVar.e(-204);
        ctVar.a(sVar);
        ctVar.g(0);
        ctVar.a(b);
        String sb = new StringBuilder(String.valueOf(b)).toString();
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.c.a.a().h();
        h.a(sb, h.a(sb));
        return ctVar;
    }
}
