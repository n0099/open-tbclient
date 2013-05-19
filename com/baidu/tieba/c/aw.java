package com.baidu.tieba.c;

import android.content.Context;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.a.a {
    com.baidu.tieba.b.a a = null;
    int b;
    final /* synthetic */ au c;

    public aw(au auVar, int i) {
        this.c = auVar;
        this.b = 3;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.a.al alVar;
        com.baidu.tieba.a.al alVar2;
        com.baidu.tieba.a.al alVar3;
        av avVar;
        av avVar2;
        com.baidu.tieba.a.al alVar4;
        boolean z = false;
        super.b();
        this.c.C = System.nanoTime();
        alVar = this.c.x;
        ArrayList d = alVar.d();
        if (this.b == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.a.i.b()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                alVar3 = this.c.x;
                alVar3.e().f(1);
                avVar = this.c.B;
                if (avVar != null) {
                    avVar2 = this.c.B;
                    alVar4 = this.c.x;
                    avVar2.a(alVar4);
                }
            }
        } else if (this.b == 2) {
            while (d.size() + 30 > com.baidu.tieba.a.i.b()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                alVar2 = this.c.x;
                alVar2.e().e(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.al a(Object... objArr) {
        com.baidu.tieba.a.al alVar;
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
        com.baidu.tieba.a.am amVar;
        com.baidu.tieba.a.al alVar2;
        com.baidu.tieba.a.am amVar2;
        com.baidu.tieba.a.am amVar3;
        long j2;
        com.baidu.tieba.a.am amVar4;
        com.baidu.tieba.a.am amVar5;
        int i5;
        int i6;
        long j3;
        Context context;
        Context context2;
        Context context3;
        try {
            alVar = this.c.x;
            ArrayList d = alVar.d();
            switch (this.b) {
                case 1:
                    this.c.h = ((com.baidu.tieba.a.aq) d.get(d.size() - 1)).d();
                    break;
                case 2:
                    this.c.h = ((com.baidu.tieba.a.aq) d.get(0)).d();
                    break;
            }
            this.a = new com.baidu.tieba.b.a();
            com.baidu.tieba.b.a aVar = this.a;
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
            amVar = au.z;
            String a = aVar.a(str, str2, str3, i, i2, z, z2, i7, i3, i4, z3, j, z4, amVar);
            if (this.a.b()) {
                com.baidu.tieba.a.al alVar3 = new com.baidu.tieba.a.al();
                alVar3.b(a);
                com.baidu.tieba.a.bb b = alVar3.b();
                i5 = this.c.k;
                b.b(i5);
                i6 = this.c.l;
                b.a(i6);
                j3 = this.c.m;
                b.a(j3);
                for (int i8 = 0; i8 < alVar3.d().size(); i8++) {
                    com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) alVar3.d().get(i8);
                    context = this.c.A;
                    aqVar.a(context);
                    context2 = this.c.A;
                    aqVar.d(context2);
                    for (int i9 = 0; i9 < aqVar.a().size(); i9++) {
                        context3 = this.c.A;
                        aqVar.b(context3);
                    }
                }
                alVar2 = alVar3;
            } else {
                this.c.a(this.a.e());
                this.c.a(this.a.f());
                alVar2 = null;
            }
            if (this.a.c()) {
                amVar3 = au.z;
                amVar3.a();
                long nanoTime = System.nanoTime();
                j2 = this.c.C;
                amVar4 = au.z;
                amVar4.a((int) ((nanoTime - j2) / 1000000));
                amVar5 = au.z;
                amVar5.b(this.a.d());
                return alVar2;
            }
            amVar2 = au.z;
            amVar2.c(1);
            return alVar2;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.al alVar) {
        int i;
        com.baidu.tieba.a.al alVar2;
        int size;
        com.baidu.tieba.a.al alVar3;
        com.baidu.tieba.a.al alVar4;
        boolean z;
        av avVar;
        av avVar2;
        com.baidu.tieba.a.al alVar5;
        String str;
        av avVar3;
        av avVar4;
        String str2;
        this.c.y = null;
        if (alVar != null) {
            this.c.w = false;
            this.c.f(alVar.e().c());
            this.c.q = alVar.e().a();
            au auVar = this.c;
            i = this.c.q;
            auVar.q = i < 1 ? 1 : this.c.q;
            alVar2 = this.c.x;
            ArrayList d = alVar2.d();
            switch (this.b) {
                case 1:
                    alVar4 = this.c.x;
                    alVar4.a(alVar.e(), 1);
                    d.addAll(alVar.d());
                    size = 0;
                    break;
                case 2:
                    size = alVar.d().size() + 1;
                    alVar3 = this.c.x;
                    alVar3.a(alVar.e(), 2);
                    d.addAll(0, alVar.d());
                    break;
                case 3:
                    z = this.c.j;
                    if (!z) {
                        alVar.e().c(alVar.e().a());
                    }
                case 4:
                case 5:
                case 6:
                    this.c.x = alVar;
                    this.c.e(alVar.e().c());
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            avVar = this.c.B;
            if (avVar != null) {
                avVar2 = this.c.B;
                int b = this.c.b();
                int i2 = this.b;
                alVar5 = this.c.x;
                str = this.c.d;
                avVar2.a(true, b, i2, size, alVar5, str);
                return;
            }
            return;
        }
        avVar3 = this.c.B;
        if (avVar3 != null) {
            avVar4 = this.c.B;
            int b2 = this.c.b();
            int i3 = this.b;
            str2 = this.c.d;
            avVar4.a(false, b2, i3, 0, null, str2);
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        av avVar;
        av avVar2;
        if (this.a != null) {
            this.a.a();
        }
        avVar = this.c.B;
        if (avVar != null) {
            avVar2 = this.c.B;
            avVar2.a(false, this.c.b(), this.b, 0, null, null);
        }
        this.c.y = null;
        super.cancel(true);
    }
}
