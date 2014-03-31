package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ImSystemShowNotifyMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.framework.c.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(2001128);
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        switch (customResponsedMessage2.g()) {
            case 2001128:
                if (customResponsedMessage2 instanceof ImSystemShowNotifyMessage) {
                    a.c(((ImSystemShowNotifyMessage) customResponsedMessage2).b());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
