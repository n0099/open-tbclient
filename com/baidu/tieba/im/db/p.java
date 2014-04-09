package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class p extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2008015 || customResponsedMessage2.a() == null) {
            return;
        }
        if (customResponsedMessage2.a() instanceof String) {
            g.a((String) customResponsedMessage2.a());
        }
        com.baidu.tieba.im.b.e.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i) {
        super(2008015);
    }
}
