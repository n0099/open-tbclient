package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<String, Integer, com.baidu.tieba.data.e> {
    final /* synthetic */ y a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;

    public ae(y yVar, String str, String str2) {
        this.a = yVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        super.cancel(true);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.e a(String... strArr) {
        this.b = new com.baidu.tieba.util.ba(this.c);
        this.b.a("un", this.d);
        String m = this.b.m();
        if (!this.b.e() || this.b.f() != 36) {
            return null;
        }
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        eVar.a(m);
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.e eVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.f fVar;
        super.a((ae) eVar);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.e()) {
            this.a.b(this.b.j());
        } else if (this.b.f() == 0) {
            y yVar = this.a;
            fVar = this.a.j;
            yVar.b(fVar.getString(R.string.name_not_use));
        } else if (this.b.f() == 36) {
            this.a.b(this.b.j());
            if (eVar != null) {
                this.a.a(eVar.b());
            }
        } else {
            this.a.b(this.b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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
