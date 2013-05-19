package com.baidu.tieba.c;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ax a;
    private com.baidu.tieba.b.b b = null;
    private int c;

    public ay(ax axVar, int i) {
        this.a = axVar;
        this.c = 0;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.ax a(Object... objArr) {
        com.baidu.tieba.a.ax axVar;
        com.baidu.tieba.a.ax axVar2;
        com.baidu.tieba.a.ax axVar3;
        String str;
        String str2;
        String str3;
        Context context;
        this.b = new com.baidu.tieba.b.b();
        try {
            axVar = this.a.i;
            int f = axVar.f();
            if (f == 0) {
                f++;
            } else if (this.c == 0) {
                f++;
            } else if (this.c == 2) {
                axVar2 = this.a.i;
                int size = axVar2.b().size();
                axVar3 = this.a.i;
                if (size % axVar3.e() == 0) {
                    f++;
                }
            }
            com.baidu.tieba.b.b bVar = this.b;
            str = this.a.e;
            str2 = this.a.g;
            int i = this.c;
            str3 = this.a.f;
            String a = bVar.a(str, str2, i, str3, f);
            if (!this.b.a()) {
                return null;
            }
            com.baidu.tieba.a.ax axVar4 = new com.baidu.tieba.a.ax();
            axVar4.a(a);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= axVar4.b().size()) {
                    return axVar4;
                }
                context = this.a.h;
                ((com.baidu.tieba.a.aq) axVar4.b().get(i3)).b(context);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.toString());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.d();
        }
        cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.ax axVar) {
        com.baidu.tieba.a.ax axVar2;
        com.baidu.tieba.a.ax axVar3;
        az azVar;
        az azVar2;
        com.baidu.tieba.a.ax axVar4;
        az azVar3;
        az azVar4;
        if (axVar == null) {
            azVar3 = this.a.k;
            if (azVar3 != null) {
                azVar4 = this.a.k;
                azVar4.a(false, this.b.c(), this.b.b(), null);
                return;
            }
            return;
        }
        if (axVar.a() != null) {
            this.a.f = axVar.a().d();
        }
        if (axVar.l() != null) {
            this.a.e = axVar.l().a();
        }
        if (this.c == 1) {
            this.a.i = axVar;
        } else if (this.c == 2) {
            axVar3 = this.a.i;
            axVar3.a(axVar, true);
        } else {
            axVar2 = this.a.i;
            axVar2.a(axVar, false);
        }
        azVar = this.a.k;
        if (azVar != null) {
            azVar2 = this.a.k;
            int c = this.b.c();
            String b = this.b.b();
            axVar4 = this.a.i;
            azVar2.a(true, c, b, axVar4);
        }
        this.b = null;
    }
}
