package com.baidu.tieba.home;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<com.baidu.tieba.data.ad, Integer, String> {
    final /* synthetic */ f a;
    private ba b = null;
    private com.baidu.tieba.data.ad c;

    public k(f fVar, com.baidu.tieba.data.ad adVar) {
        this.a = fVar;
        this.c = null;
        this.c = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(com.baidu.tieba.data.ad... adVarArr) {
        com.baidu.tieba.data.ad adVar = this.c;
        if (adVar != null) {
            try {
                if (adVar.a() != null && adVar.b() != null) {
                    this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/unfavo");
                    this.b.a("fid", adVar.a());
                    this.b.a("kw", adVar.b());
                    this.b.e(true);
                    this.b.m();
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.k kVar;
        com.baidu.tieba.k kVar2;
        n nVar;
        super.a((k) str);
        this.a.c = null;
        if (this.b != null) {
            if (this.b.d()) {
                kVar2 = this.a.h;
                kVar2.a(this.a.getString(R.string.success));
                TiebaApplication.g().h(true);
                nVar = this.a.b;
                nVar.e();
                return;
            }
            kVar = this.a.h;
            kVar.a(this.b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.c = null;
        super.cancel(true);
    }
}
