package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae extends BdAsyncTask<String, Integer, com.baidu.tieba.data.e> {
    final /* synthetic */ y a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.e a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.e eVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.f fVar;
        com.baidu.tieba.data.e eVar2 = eVar;
        super.a((ae) eVar2);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.d()) {
            this.a.b(this.b.i());
        } else if (this.b.e() == 0) {
            y yVar = this.a;
            fVar = this.a.j;
            yVar.b(fVar.getString(R.string.name_not_use));
        } else if (this.b.e() == 36) {
            this.a.b(this.b.i());
            if (eVar2 != null) {
                this.a.a(eVar2.b());
            }
        } else {
            this.a.b(this.b.i());
        }
    }

    public ae(y yVar, String str, String str2) {
        this.a = yVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        Button button;
        super.cancel(true);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        this.a.m = null;
    }

    private com.baidu.tieba.data.e d() {
        this.b = new com.baidu.tieba.util.ba(this.c);
        this.b.a("un", this.d);
        String l = this.b.l();
        if (!this.b.d() || this.b.e() != 36) {
            return null;
        }
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        eVar.a(l);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.b();
    }
}
