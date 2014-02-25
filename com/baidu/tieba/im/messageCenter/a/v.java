package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bb;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.message.da;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof bb)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a = com.baidu.adp.lib.util.k.a(com.baidu.tieba.c.a.a().h());
        ct ctVar = new ct();
        ctVar.e(-202);
        ctVar.a(sVar);
        ctVar.b(a);
        return ctVar;
    }
}
