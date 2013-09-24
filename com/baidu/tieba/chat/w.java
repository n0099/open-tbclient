package com.baidu.tieba.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Object, Integer, com.baidu.tieba.data.a.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f979a;
    private com.baidu.tieba.a.d b = null;
    private int c;

    public w(v vVar, int i) {
        this.f979a = vVar;
        this.c = 0;
        this.c = i;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        x xVar;
        x xVar2;
        super.b();
        xVar = this.f979a.k;
        if (xVar != null) {
            xVar2 = this.f979a.k;
            xVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
        }
        this.f979a.i = null;
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
                cVar = this.f979a.h;
                com.baidu.tieba.data.a.d f = cVar.f();
                if (f != null) {
                    j = f.b();
                    break;
                }
                break;
            case 1:
                cVar2 = this.f979a.h;
                com.baidu.tieba.data.a.d a2 = cVar2.a(0);
                if (a2 != null) {
                    j = a2.b();
                    break;
                }
                break;
            case 2:
                com.baidu.tieba.data.a.c cVar3 = new com.baidu.tieba.data.a.c();
                fVar = this.f979a.l;
                str = this.f979a.b;
                str2 = this.f979a.d;
                cVar3.a((LinkedList) fVar.a(str, str2));
                return cVar3;
        }
        this.b = new com.baidu.tieba.a.d();
        com.baidu.tieba.a.d dVar = this.b;
        int i = this.c;
        str3 = this.f979a.b;
        str4 = this.f979a.d;
        String a3 = dVar.a(i, str3, str4, j);
        com.baidu.tieba.data.a.c cVar4 = new com.baidu.tieba.data.a.c();
        str5 = this.f979a.d;
        cVar4.a(str5);
        str6 = this.f979a.b;
        cVar4.b(str6);
        cVar4.e(a3);
        if (this.b.b() && this.b.d() == 0 && this.c == 0) {
            fVar2 = this.f979a.l;
            fVar2.a(cVar4.d());
            return cVar4;
        }
        return cVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.a.c cVar) {
        x xVar;
        x xVar2;
        x xVar3;
        com.baidu.tieba.data.a.c cVar2;
        com.baidu.tieba.data.a.c cVar3;
        x xVar4;
        com.baidu.tieba.data.a.c cVar4;
        x xVar5;
        com.baidu.tieba.data.a.c cVar5;
        com.baidu.tieba.data.a.c cVar6;
        com.baidu.tieba.data.a.c cVar7;
        x xVar6;
        x xVar7;
        com.baidu.tieba.data.a.c cVar8;
        com.baidu.tieba.data.a.c cVar9;
        x xVar8;
        com.baidu.tieba.data.a.c cVar10;
        super.a((w) cVar);
        this.f979a.i = null;
        if (this.c == 2) {
            if (cVar == null) {
                xVar6 = this.f979a.k;
                xVar6.a(false, null, false, 0, null, true);
                return;
            }
            int size = cVar.d().size();
            xVar7 = this.f979a.k;
            xVar7.b();
            cVar8 = this.f979a.h;
            cVar8.a(cVar);
            cVar9 = this.f979a.h;
            cVar9.a(cVar.c());
            xVar8 = this.f979a.k;
            cVar10 = this.f979a.h;
            xVar8.a(true, null, false, size, cVar10, true);
        } else if (this.b != null && cVar != null) {
            if (!this.b.b()) {
                xVar = this.f979a.k;
                xVar.a(false, this.b.c(), false, 0, null, false);
            } else if (this.b.d() != 0) {
                xVar2 = this.f979a.k;
                xVar2.a(false, this.b.e(), false, 0, null, false);
            } else {
                int size2 = cVar.d().size();
                xVar3 = this.f979a.k;
                xVar3.b();
                cVar2 = this.f979a.h;
                cVar2.a(cVar);
                cVar3 = this.f979a.h;
                cVar3.a(cVar.c());
                if (cVar.a() != null && cVar.a().length() > 0) {
                    cVar7 = this.f979a.h;
                    cVar7.c(cVar.a());
                }
                if (cVar.b() != null && cVar.b().length() > 0) {
                    cVar6 = this.f979a.h;
                    cVar6.d(cVar.b());
                }
                switch (this.c) {
                    case 0:
                        xVar5 = this.f979a.k;
                        cVar5 = this.f979a.h;
                        xVar5.a(true, null, true, size2, cVar5, false);
                        return;
                    case 1:
                        xVar4 = this.f979a.k;
                        cVar4 = this.f979a.h;
                        xVar4.a(true, null, false, size2, cVar4, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
