package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dd extends com.baidu.adp.framework.c.b {
    final /* synthetic */ dc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd(dc dcVar, int i) {
        super(1014000);
        this.a = dcVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        de deVar;
        de deVar2;
        de deVar3;
        de deVar4;
        de deVar5;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1014000) {
            return;
        }
        if (httpResponsedMessage2.d() != 200 || !(httpResponsedMessage2 instanceof PraiseResponseMessage)) {
            deVar = this.a.a;
            if (deVar != null) {
                deVar2 = this.a.a;
                deVar2.a(null);
                return;
            }
            return;
        }
        PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage2;
        if (praiseResponseMessage.e() == 0) {
            deVar5 = this.a.a;
            praiseResponseMessage.i();
            deVar5.a();
            return;
        }
        deVar3 = this.a.a;
        if (deVar3 != null) {
            deVar4 = this.a.a;
            deVar4.a(praiseResponseMessage.i());
        }
    }
}
