package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.data.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<x, Integer, String> {
    final /* synthetic */ e a;
    private ak b = null;
    private x c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(x... xVarArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        o oVar;
        super.a((k) str);
        this.a.c = null;
        if (this.b != null) {
            if (this.b.a().b().b()) {
                eVar2 = this.a.h;
                eVar2.a(this.a.getString(com.baidu.tieba.a.k.success));
                com.baidu.tieba.p.c().e(true);
                oVar = this.a.b;
                oVar.a();
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2003004, this.c.a()));
                return;
            }
            eVar = this.a.h;
            eVar.a(this.b.f());
        }
    }

    public k(e eVar, x xVar) {
        this.a = eVar;
        this.c = null;
        this.c = xVar;
    }

    private String a() {
        x xVar = this.c;
        if (xVar != null) {
            try {
                if (xVar.a() != null && xVar.b() != null) {
                    this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/unfavo");
                    this.b.a("fid", xVar.a());
                    this.b.a("kw", xVar.b());
                    this.b.a().a().a = true;
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
