package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.a {
    final /* synthetic */ f a;
    private com.baidu.tieba.d.t b = null;
    private String c = null;
    private int d;
    private com.baidu.tieba.a.ba e;

    public h(f fVar, int i) {
        this.a = fVar;
        this.d = 0;
        this.e = null;
        this.d = i;
        this.e = new com.baidu.tieba.a.ba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public f a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/post/threadstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.C());
        this.b.a("offset", String.valueOf(this.d));
        this.b.a("rn", String.valueOf(20));
        this.c = this.b.i();
        this.e.a(this.c);
        f fVar = new f();
        if (this.b.b() || this.e.a() == 0) {
            fVar.a(this.c);
            if (this.d == 0) {
                com.baidu.tieba.d.k.h(this.c);
            }
        } else {
            this.c = com.baidu.tieba.d.k.d();
            fVar.a(this.c);
        }
        return fVar;
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
    public void a(f fVar) {
        String f;
        this.a.b = null;
        this.a.f = fVar.c();
        this.a.b(fVar.b());
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
