package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class b extends com.baidu.adp.framework.c.a {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity, int i) {
        super(0);
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        com.baidu.tieba.im.a aVar;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        tVar = this.a.b;
        tVar.a(false);
        if (customResponsedMessage2 == null || !(customResponsedMessage2 instanceof com.baidu.adp.framework.message.f)) {
            return;
        }
        int g = customResponsedMessage2.g();
        if (2001136 == g || 2001137 == g || 2001134 == g || 2001133 == g || 2001141 == g) {
            aVar = this.a.d;
            p.a(aVar);
        }
    }
}
