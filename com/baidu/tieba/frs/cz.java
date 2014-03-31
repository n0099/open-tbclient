package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cz extends com.baidu.adp.framework.c.b {
    final /* synthetic */ cy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz(cy cyVar, int i) {
        super(1006003);
        this.a = cyVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        ci ciVar;
        ci ciVar2;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1006003) {
            return;
        }
        int d = httpResponsedMessage2.d();
        int e = httpResponsedMessage2.e();
        if (d == 200 && e == 0 && (httpResponsedMessage2 instanceof ImageForumResponsedMessage)) {
            ciVar = this.a.l;
            if (ciVar != null) {
                db a = cy.a(this.a, httpResponsedMessage2, d, e);
                int a2 = cy.a(this.a, httpResponsedMessage2);
                ciVar2 = this.a.l;
                ciVar2.a(a2, ((ImageForumResponsedMessage) httpResponsedMessage2).a, a);
            }
        }
    }
}
