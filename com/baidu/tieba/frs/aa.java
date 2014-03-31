package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class aa extends com.baidu.adp.framework.c.a {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(FrsActivity frsActivity, int i) {
        super(0);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            if (customResponsedMessage2.g() == 2001124) {
                FrsActivity.a(this.a, customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001122) {
                FrsActivity.b(this.a, customResponsedMessage2);
            }
        }
    }
}
