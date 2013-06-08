package com.baidu.tieba.c;

import android.content.Context;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.b.d a = null;
    int b;
    final /* synthetic */ ax c;

    public az(ax axVar, int i) {
        this.c = axVar;
        this.b = 3;
        this.b = i;
        setSelfExecute(true);
        axVar.a((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.a.am amVar;
        com.baidu.tieba.a.am amVar2;
        com.baidu.tieba.a.am amVar3;
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.a.am amVar4;
        boolean z = false;
        super.b();
        this.c.C = System.nanoTime();
        amVar = this.c.x;
        ArrayList d = amVar.d();
        if (this.b == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.a.i.b()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                amVar3 = this.c.x;
                amVar3.e().f(1);
                ayVar = this.c.B;
                if (ayVar != null) {
                    ayVar2 = this.c.B;
                    amVar4 = this.c.x;
                    ayVar2.a(amVar4);
                }
            }
        } else if (this.b == 2) {
            while (d.size() + 30 > com.baidu.tieba.a.i.b()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                amVar2 = this.c.x;
                amVar2.e().e(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.am a(Object... objArr) {
        com.baidu.tieba.a.am amVar;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        long j;
        boolean z4;
        com.baidu.tieba.a.an anVar;
        com.baidu.tieba.a.am amVar2;
        com.baidu.tieba.a.an anVar2;
        com.baidu.tieba.a.an anVar3;
        long j2;
        com.baidu.tieba.a.an anVar4;
        com.baidu.tieba.a.an anVar5;
        Context context;
        int i5;
        int i6;
        long j3;
        Context context2;
        try {
            amVar = this.c.x;
            ArrayList d = amVar.d();
            switch (this.b) {
                case 1:
                    this.c.h = ((com.baidu.tieba.a.ar) d.get(d.size() - 1)).d();
                    break;
                case 2:
                    this.c.h = ((com.baidu.tieba.a.ar) d.get(0)).d();
                    break;
            }
            this.a = new com.baidu.tieba.b.d();
            com.baidu.tieba.b.d dVar = this.a;
            str = this.c.g;
            str2 = this.c.f;
            str3 = this.c.h;
            i = this.c.p;
            i2 = this.c.o;
            z = this.c.j;
            z2 = this.c.i;
            int i7 = this.b;
            i3 = this.c.n;
            i4 = this.c.q;
            z3 = this.c.w;
            j = this.c.v;
            z4 = this.c.u;
            anVar = ax.z;
            String a = dVar.a(str, str2, str3, i, i2, z, z2, i7, i3, i4, z3, j, z4, anVar);
            if (this.a.b()) {
                com.baidu.tieba.a.am amVar3 = new com.baidu.tieba.a.am();
                context = this.c.A;
                amVar3.a(a, context);
                com.baidu.tieba.a.bc b = amVar3.b();
                i5 = this.c.k;
                b.b(i5);
                i6 = this.c.l;
                b.a(i6);
                j3 = this.c.m;
                b.a(j3);
                for (int i8 = 0; i8 < amVar3.d().size(); i8++) {
                    com.baidu.tieba.a.ar arVar = (com.baidu.tieba.a.ar) amVar3.d().get(i8);
                    for (int i9 = 0; i9 < arVar.a().size(); i9++) {
                        context2 = this.c.A;
                        ((com.baidu.tieba.a.ar) arVar.a().get(i9)).a(context2);
                    }
                }
                amVar2 = amVar3;
            } else {
                this.c.a(this.a.e());
                this.c.a(this.a.f());
                amVar2 = null;
            }
            if (this.a.c()) {
                anVar3 = ax.z;
                anVar3.a();
                long nanoTime = System.nanoTime();
                j2 = this.c.C;
                anVar4 = ax.z;
                anVar4.a((int) ((nanoTime - j2) / 1000000));
                anVar5 = ax.z;
                anVar5.b(this.a.d());
                return amVar2;
            }
            anVar2 = ax.z;
            anVar2.c(1);
            return amVar2;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.am amVar) {
        int i;
        com.baidu.tieba.a.am amVar2;
        int size;
        com.baidu.tieba.a.am amVar3;
        com.baidu.tieba.a.am amVar4;
        boolean z;
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.a.am amVar5;
        String str;
        ay ayVar3;
        ay ayVar4;
        String str2;
        this.c.y = null;
        if (amVar != null) {
            this.c.w = false;
            this.c.f(amVar.e().d());
            this.c.q = amVar.e().a();
            ax axVar = this.c;
            i = this.c.q;
            axVar.q = i < 1 ? 1 : this.c.q;
            amVar2 = this.c.x;
            ArrayList d = amVar2.d();
            switch (this.b) {
                case 1:
                    amVar4 = this.c.x;
                    amVar4.a(amVar.e(), 1);
                    d.addAll(amVar.d());
                    size = 0;
                    break;
                case 2:
                    size = amVar.d().size() + 1;
                    amVar3 = this.c.x;
                    amVar3.a(amVar.e(), 2);
                    d.addAll(0, amVar.d());
                    break;
                case 3:
                    z = this.c.j;
                    if (!z) {
                        amVar.e().c(amVar.e().a());
                    }
                case 4:
                case 5:
                case 6:
                    this.c.x = amVar;
                    this.c.e(amVar.e().d());
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            ayVar = this.c.B;
            if (ayVar != null) {
                ayVar2 = this.c.B;
                int b = this.c.b();
                int i2 = this.b;
                amVar5 = this.c.x;
                str = this.c.d;
                ayVar2.a(true, b, i2, size, amVar5, str);
                return;
            }
            return;
        }
        ayVar3 = this.c.B;
        if (ayVar3 != null) {
            ayVar4 = this.c.B;
            int b2 = this.c.b();
            int i3 = this.b;
            str2 = this.c.d;
            ayVar4.a(false, b2, i3, 0, null, str2);
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ay ayVar;
        ay ayVar2;
        super.cancel(true);
        this.c.a((String) null);
        if (this.a != null) {
            this.a.a();
        }
        ayVar = this.c.B;
        if (ayVar != null) {
            ayVar2 = this.c.B;
            ayVar2.a(false, this.c.b(), this.b, 0, null, null);
        }
        this.c.y = null;
    }
}
