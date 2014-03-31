package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class b extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        Object a;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || (a = customResponsedMessage2.a()) == null || !(a instanceof Boolean)) {
            return;
        }
        a.l = ((Boolean) a).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(2008004);
    }
}
