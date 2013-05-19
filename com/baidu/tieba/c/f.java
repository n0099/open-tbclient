package com.baidu.tieba.c;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.a.a {
    final /* synthetic */ c a;
    private com.baidu.tieba.d.t b;
    private com.baidu.tieba.a.az c;

    private f(c cVar) {
        this.a = cVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(c cVar, f fVar) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.c = new com.baidu.tieba.a.az();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(c... cVarArr) {
        c cVar = new c();
        try {
            cVar.e();
            this.b = new com.baidu.tieba.d.t();
            this.b.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/addstore");
            int h = this.a.h();
            if (cVar.c() - 1 <= h) {
                h = cVar.c() - 1;
            }
            while (h >= 0) {
                String a = cVar.a(h, 20);
                this.b.a(new ArrayList());
                this.b.a("data", a);
                this.c.a(this.b.i());
                if (!this.b.b() || this.c.a() != 0) {
                    break;
                }
                h -= 20;
            }
            this.a.b(h);
            if (h >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.a(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.b()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.a.a != null) {
            this.a.a.a(1, bool, str, Boolean.valueOf(z));
        }
    }
}
