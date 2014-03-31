package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class av extends com.baidu.adp.framework.c.a {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(FrsActivity frsActivity, int i) {
        super(2003003);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        cm cmVar;
        cm cmVar2;
        if (customResponsedMessage != null) {
            cmVar = this.a.r;
            if (cmVar != null) {
                cmVar2 = this.a.r;
                cmVar2.O();
            }
        }
    }
}
