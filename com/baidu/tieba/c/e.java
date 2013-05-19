package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.a {
    final /* synthetic */ c a;
    private com.baidu.tieba.d.t b = null;
    private String c = null;
    private int d;
    private com.baidu.tieba.a.az e;

    public e(c cVar, int i) {
        this.a = cVar;
        this.d = 0;
        this.e = null;
        this.d = i;
        this.e = new com.baidu.tieba.a.az();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public c a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/post/threadstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.z());
        this.b.a("offset", String.valueOf(this.d));
        this.b.a("rn", String.valueOf(20));
        this.c = this.b.i();
        this.e.a(this.c);
        c cVar = new c();
        if (this.b.b() || this.e.a() == 0) {
            cVar.a(this.c);
            if (this.d == 0) {
                com.baidu.tieba.d.k.h(this.c);
            }
        } else {
            this.c = com.baidu.tieba.d.k.c();
            cVar.a(this.c);
        }
        return cVar;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        if (this.a.a != null) {
            this.a.a.a(0, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(c cVar) {
        String f;
        this.a.b = null;
        this.a.f = cVar.c();
        this.a.b(cVar.b());
        if (this.a.a != null) {
            if (this.b.b()) {
                f = this.e.b();
            } else {
                f = this.b.f();
            }
            this.a.a.a(0, f);
        }
    }
}
