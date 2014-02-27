package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<com.baidu.tieba.data.ad, Integer, String> {
    final /* synthetic */ f a;
    private ba b = null;
    private com.baidu.tieba.data.ad c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(com.baidu.tieba.data.ad... adVarArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.tieba.k kVar;
        com.baidu.tieba.k kVar2;
        n nVar;
        super.a((k) str);
        this.a.c = null;
        if (this.b != null) {
            if (this.b.c()) {
                kVar2 = this.a.h;
                kVar2.a(this.a.getString(R.string.success));
                TiebaApplication.g().g(true);
                nVar = this.a.b;
                nVar.a();
                return;
            }
            kVar = this.a.h;
            kVar.a(this.b.i());
        }
    }

    public k(f fVar, com.baidu.tieba.data.ad adVar) {
        this.a = fVar;
        this.c = null;
        this.c = adVar;
    }

    private String d() {
        com.baidu.tieba.data.ad adVar = this.c;
        if (adVar != null) {
            try {
                if (adVar.a() != null && adVar.b() != null) {
                    this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/unfavo");
                    this.b.a("fid", adVar.a());
                    this.b.a("kw", adVar.b());
                    this.b.e(true);
                    this.b.l();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
