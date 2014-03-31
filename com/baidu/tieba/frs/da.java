package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class da extends com.baidu.adp.framework.c.b {
    final /* synthetic */ cy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(cy cyVar, int i) {
        super(1006002);
        this.a = cyVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        ci ciVar;
        ci ciVar2;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1006002) {
            return;
        }
        int d = httpResponsedMessage2.d();
        int e = httpResponsedMessage2.e();
        if (d == 200 && e == 0 && (httpResponsedMessage2 instanceof ImageForumListResponsedMessage)) {
            ciVar = this.a.k;
            if (ciVar != null) {
                db a = cy.a(this.a, httpResponsedMessage2, d, e);
                int a2 = cy.a(this.a, httpResponsedMessage2);
                ImageForumListResponsedMessage imageForumListResponsedMessage = (ImageForumListResponsedMessage) httpResponsedMessage2;
                this.a.a = imageForumListResponsedMessage.a;
                this.a.b = imageForumListResponsedMessage.b;
                this.a.c = imageForumListResponsedMessage.c;
                this.a.d = imageForumListResponsedMessage.d;
                this.a.e = imageForumListResponsedMessage.e;
                this.a.f = imageForumListResponsedMessage.f;
                this.a.g = imageForumListResponsedMessage.g;
                this.a.h = imageForumListResponsedMessage.h;
                ciVar2 = this.a.k;
                ciVar2.a(a2, imageForumListResponsedMessage.i, a);
            }
        }
    }
}
