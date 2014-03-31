package com.baidu.tieba.im.c;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.d.m;
/* loaded from: classes.dex */
final class c extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2008017) {
            return;
        }
        m.a().d();
        b.a().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(2008017);
    }
}
