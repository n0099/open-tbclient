package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bb;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.messageCenter.c {
    @Override // com.baidu.tieba.im.messageCenter.c
    public final da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof bb)) {
            return null;
        }
        com.baidu.tieba.c.a.a().i();
        ct ctVar = new ct();
        ctVar.e(-203);
        ctVar.a(sVar);
        ctVar.g(0);
        return ctVar;
    }
}
