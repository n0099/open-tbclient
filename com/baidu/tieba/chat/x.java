package com.baidu.tieba.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.a.a {
    final /* synthetic */ w a;
    private com.baidu.tieba.b.b b = null;
    private int c;

    public x(w wVar, int i) {
        this.a = wVar;
        this.c = 0;
        this.c = i;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        y yVar;
        y yVar2;
        super.b();
        yVar = this.a.o;
        if (yVar != null) {
            yVar2 = this.a.o;
            yVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.a.c a(Object... objArr) {
        com.baidu.tieba.a.a.f fVar;
        String str;
        String str2;
        com.baidu.tieba.a.a.c cVar;
        com.baidu.tieba.a.a.c cVar2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.a.a.f fVar2;
        long j = 0;
        switch (this.c) {
            case 0:
                cVar = this.a.l;
                com.baidu.tieba.a.a.d f = cVar.f();
                if (f != null) {
                    j = f.b();
                    break;
                }
                break;
            case 1:
                cVar2 = this.a.l;
                com.baidu.tieba.a.a.d a = cVar2.a(0);
                if (a != null) {
                    j = a.b();
                    break;
                }
                break;
            case 2:
                com.baidu.tieba.a.a.c cVar3 = new com.baidu.tieba.a.a.c();
                fVar = this.a.p;
                str = this.a.f;
                str2 = this.a.h;
                cVar3.a((LinkedList) fVar.a(str, str2));
                return cVar3;
        }
        this.b = new com.baidu.tieba.b.b();
        com.baidu.tieba.b.b bVar = this.b;
        int i = this.c;
        str3 = this.a.f;
        str4 = this.a.h;
        String a2 = bVar.a(i, str3, str4, j);
        com.baidu.tieba.a.a.c cVar4 = new com.baidu.tieba.a.a.c();
        str5 = this.a.h;
        cVar4.a(str5);
        str6 = this.a.f;
        cVar4.b(str6);
        cVar4.e(a2);
        if (this.b.b() && this.b.d() == 0 && this.c == 0) {
            fVar2 = this.a.p;
            fVar2.a(cVar4.d());
            return cVar4;
        }
        return cVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.a.c cVar) {
        y yVar;
        y yVar2;
        y yVar3;
        com.baidu.tieba.a.a.c cVar2;
        com.baidu.tieba.a.a.c cVar3;
        y yVar4;
        com.baidu.tieba.a.a.c cVar4;
        y yVar5;
        com.baidu.tieba.a.a.c cVar5;
        com.baidu.tieba.a.a.c cVar6;
        com.baidu.tieba.a.a.c cVar7;
        y yVar6;
        y yVar7;
        com.baidu.tieba.a.a.c cVar8;
        com.baidu.tieba.a.a.c cVar9;
        y yVar8;
        com.baidu.tieba.a.a.c cVar10;
        super.a((Object) cVar);
        this.a.m = null;
        if (this.c == 2) {
            if (cVar == null) {
                yVar6 = this.a.o;
                yVar6.a(false, null, false, 0, null, true);
                return;
            }
            int size = cVar.d().size();
            yVar7 = this.a.o;
            yVar7.b();
            cVar8 = this.a.l;
            cVar8.a(cVar);
            cVar9 = this.a.l;
            cVar9.a(cVar.c());
            yVar8 = this.a.o;
            cVar10 = this.a.l;
            yVar8.a(true, null, false, size, cVar10, true);
        } else if (this.b != null && cVar != null) {
            if (!this.b.b()) {
                yVar = this.a.o;
                yVar.a(false, this.b.c(), false, 0, null, false);
            } else if (this.b.d() != 0) {
                yVar2 = this.a.o;
                yVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                int size2 = cVar.d().size();
                yVar3 = this.a.o;
                yVar3.b();
                cVar2 = this.a.l;
                cVar2.a(cVar);
                cVar3 = this.a.l;
                cVar3.a(cVar.c());
                if (cVar.a() != null && cVar.a().length() > 0) {
                    cVar7 = this.a.l;
                    cVar7.c(cVar.a());
                }
                if (cVar.b() != null && cVar.b().length() > 0) {
                    cVar6 = this.a.l;
                    cVar6.d(cVar.b());
                }
                switch (this.c) {
                    case 0:
                        yVar5 = this.a.o;
                        cVar5 = this.a.l;
                        yVar5.a(true, null, true, size2, cVar5, false);
                        return;
                    case 1:
                        yVar4 = this.a.o;
                        cVar4 = this.a.l;
                        yVar4.a(true, null, false, size2, cVar4, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
