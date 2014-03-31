package com.baidu.tieba.im.groupActivity;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
/* loaded from: classes.dex */
final class n extends com.baidu.adp.framework.c.a {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupActivityActivity groupActivityActivity, int i) {
        super(2001127);
        this.a = groupActivityActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        r rVar;
        s sVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (!(customResponsedMessage2 instanceof ResponseGetGroupActivityLocalMessage)) {
            rVar7 = this.a.b;
            rVar8 = this.a.b;
            rVar7.c(rVar8.b());
            return;
        }
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = (ResponseGetGroupActivityLocalMessage) customResponsedMessage2;
        rVar = this.a.b;
        if (rVar.d() == responseGetGroupActivityLocalMessage.h()) {
            if (responseGetGroupActivityLocalMessage.e() == 0) {
                sVar = this.a.a;
                sVar.a(responseGetGroupActivityLocalMessage.b(), true);
                rVar2 = this.a.b;
                rVar2.a(responseGetGroupActivityLocalMessage.b());
                rVar3 = this.a.b;
                rVar4 = this.a.b;
                rVar3.c(rVar4.b());
                return;
            }
            rVar5 = this.a.b;
            rVar6 = this.a.b;
            rVar5.c(rVar6.b());
        }
    }
}
