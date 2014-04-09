package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class df extends com.baidu.adp.framework.c.b {
    final /* synthetic */ de a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df(de deVar, int i) {
        super(1014000);
        this.a = deVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        dg dgVar5;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1014000) {
            return;
        }
        if (httpResponsedMessage2.d() != 200 || !(httpResponsedMessage2 instanceof PraiseResponseMessage)) {
            dgVar = this.a.a;
            if (dgVar != null) {
                dgVar2 = this.a.a;
                dgVar2.a(null);
                return;
            }
            return;
        }
        PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage2;
        if (praiseResponseMessage.e() == 0) {
            dgVar5 = this.a.a;
            praiseResponseMessage.i();
            dgVar5.a();
            return;
        }
        dgVar3 = this.a.a;
        if (dgVar3 != null) {
            dgVar4 = this.a.a;
            dgVar4.a(praiseResponseMessage.i());
        }
    }
}
