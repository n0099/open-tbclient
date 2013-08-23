package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f963a;
    private com.baidu.tieba.a.b b = null;
    private int c;

    public x(w wVar, int i) {
        this.f963a = wVar;
        this.c = 0;
        this.c = i;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        y yVar;
        y yVar2;
        super.b();
        yVar = this.f963a.k;
        if (yVar != null) {
            yVar2 = this.f963a.k;
            yVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f963a.i = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.a.c a(Object... objArr) {
        com.baidu.tieba.data.a.f fVar;
        String str;
        String str2;
        com.baidu.tieba.data.a.c cVar;
        com.baidu.tieba.data.a.c cVar2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.data.a.f fVar2;
        long j = 0;
        switch (this.c) {
            case 0:
                cVar = this.f963a.h;
                com.baidu.tieba.data.a.d f = cVar.f();
                if (f != null) {
                    j = f.b();
                    break;
                }
                break;
            case 1:
                cVar2 = this.f963a.h;
                com.baidu.tieba.data.a.d a2 = cVar2.a(0);
                if (a2 != null) {
                    j = a2.b();
                    break;
                }
                break;
            case 2:
                com.baidu.tieba.data.a.c cVar3 = new com.baidu.tieba.data.a.c();
                fVar = this.f963a.l;
                str = this.f963a.b;
                str2 = this.f963a.d;
                cVar3.a((LinkedList) fVar.a(str, str2));
                return cVar3;
        }
        this.b = new com.baidu.tieba.a.b();
        com.baidu.tieba.a.b bVar = this.b;
        int i = this.c;
        str3 = this.f963a.b;
        str4 = this.f963a.d;
        String a3 = bVar.a(i, str3, str4, j);
        com.baidu.tieba.data.a.c cVar4 = new com.baidu.tieba.data.a.c();
        str5 = this.f963a.d;
        cVar4.a(str5);
        str6 = this.f963a.b;
        cVar4.b(str6);
        cVar4.e(a3);
        if (this.b.b() && this.b.d() == 0 && this.c == 0) {
            fVar2 = this.f963a.l;
            fVar2.a(cVar4.d());
            return cVar4;
        }
        return cVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.a.c cVar) {
        y yVar;
        y yVar2;
        y yVar3;
        com.baidu.tieba.data.a.c cVar2;
        com.baidu.tieba.data.a.c cVar3;
        y yVar4;
        com.baidu.tieba.data.a.c cVar4;
        y yVar5;
        com.baidu.tieba.data.a.c cVar5;
        com.baidu.tieba.data.a.c cVar6;
        com.baidu.tieba.data.a.c cVar7;
        y yVar6;
        y yVar7;
        com.baidu.tieba.data.a.c cVar8;
        com.baidu.tieba.data.a.c cVar9;
        y yVar8;
        com.baidu.tieba.data.a.c cVar10;
        super.a((Object) cVar);
        this.f963a.i = null;
        if (this.c == 2) {
            if (cVar == null) {
                yVar6 = this.f963a.k;
                yVar6.a(false, null, false, 0, null, true);
                return;
            }
            int size = cVar.d().size();
            yVar7 = this.f963a.k;
            yVar7.b();
            cVar8 = this.f963a.h;
            cVar8.a(cVar);
            cVar9 = this.f963a.h;
            cVar9.a(cVar.c());
            yVar8 = this.f963a.k;
            cVar10 = this.f963a.h;
            yVar8.a(true, null, false, size, cVar10, true);
        } else if (this.b != null && cVar != null) {
            if (!this.b.b()) {
                yVar = this.f963a.k;
                yVar.a(false, this.b.c(), false, 0, null, false);
            } else if (this.b.d() != 0) {
                yVar2 = this.f963a.k;
                yVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                int size2 = cVar.d().size();
                yVar3 = this.f963a.k;
                yVar3.b();
                cVar2 = this.f963a.h;
                cVar2.a(cVar);
                cVar3 = this.f963a.h;
                cVar3.a(cVar.c());
                if (cVar.a() != null && cVar.a().length() > 0) {
                    cVar7 = this.f963a.h;
                    cVar7.c(cVar.a());
                }
                if (cVar.b() != null && cVar.b().length() > 0) {
                    cVar6 = this.f963a.h;
                    cVar6.d(cVar.b());
                }
                switch (this.c) {
                    case 0:
                        yVar5 = this.f963a.k;
                        cVar5 = this.f963a.h;
                        yVar5.a(true, null, true, size2, cVar5, false);
                        return;
                    case 1:
                        yVar4 = this.f963a.k;
                        cVar4 = this.f963a.h;
                        yVar4.a(true, null, false, size2, cVar4, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
