package com.baidu.tieba.c;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ba a;
    private com.baidu.tieba.b.e b = null;
    private int c;

    public bb(ba baVar, int i) {
        this.a = baVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.ay a(Object... objArr) {
        com.baidu.tieba.a.ay ayVar;
        com.baidu.tieba.a.ay ayVar2;
        com.baidu.tieba.a.ay ayVar3;
        String str;
        String str2;
        String str3;
        Context context;
        Context context2;
        this.b = new com.baidu.tieba.b.e();
        try {
            ayVar = this.a.i;
            int f = ayVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                ayVar2 = this.a.i;
                int size = ayVar2.b().size();
                ayVar3 = this.a.i;
                if (size % ayVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.b.e eVar = this.b;
            str = this.a.e;
            str2 = this.a.g;
            int i = this.c;
            str3 = this.a.f;
            String a = eVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.a.ay ayVar4 = new com.baidu.tieba.a.ay();
            context = this.a.h;
            ayVar4.a(a, context);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= ayVar4.b().size()) {
                    return ayVar4;
                }
                context2 = this.a.h;
                ((com.baidu.tieba.a.ar) ayVar4.b().get(i3)).a(context2);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        this.a.j = null;
        if (this.b != null) {
            this.b.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.ay ayVar) {
        com.baidu.tieba.a.ay ayVar2;
        com.baidu.tieba.a.ay ayVar3;
        bc bcVar;
        bc bcVar2;
        com.baidu.tieba.a.ay ayVar4;
        bc bcVar3;
        bc bcVar4;
        this.a.j = null;
        if (ayVar == null) {
            bcVar3 = this.a.k;
            if (bcVar3 != null) {
                bcVar4 = this.a.k;
                bcVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (ayVar.a() != null) {
            this.a.f = ayVar.a().d();
        }
        if (ayVar.l() != null) {
            this.a.e = ayVar.l().a();
        }
        if (this.c == 1) {
            this.a.i = ayVar;
        } else if (this.c == 2) {
            ayVar3 = this.a.i;
            ayVar3.a(ayVar, true);
        } else {
            ayVar2 = this.a.i;
            ayVar2.a(ayVar, false);
        }
        bcVar = this.a.k;
        if (bcVar != null) {
            bcVar2 = this.a.k;
            int c = this.b.c();
            String b = this.b.b();
            ayVar4 = this.a.i;
            bcVar2.a(true, c, b, ayVar4);
        }
        this.b = null;
    }
}
