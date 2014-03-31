package com.baidu.tieba.im.group;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2007002 || customResponsedMessage2.a() == null) {
            return;
        }
        ((com.baidu.tbadk.mainTab.e) customResponsedMessage2.a()).a(new EnterGroupDelegateStatic());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(2007002);
    }
}
