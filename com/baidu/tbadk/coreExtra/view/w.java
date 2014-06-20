package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    final /* synthetic */ q a;
    private com.baidu.tbadk.core.util.an b = null;
    private String c;
    private String d;

    public w(q qVar, String str, String str2) {
        this.a = qVar;
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
    /* renamed from: a */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        this.b = new com.baidu.tbadk.core.util.an(this.c);
        this.b.a("un", this.d);
        String i = this.b.i();
        if (!this.b.c() || this.b.d() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.a(i);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        ProgressBar progressBar;
        Button button;
        BaseActivity baseActivity;
        super.onPostExecute(aVar);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.c()) {
            this.a.b(this.b.f());
        } else if (this.b.d() == 0) {
            q qVar = this.a;
            baseActivity = this.a.j;
            qVar.b(baseActivity.getString(com.baidu.tieba.y.name_not_use));
        } else if (this.b.d() == 36) {
            this.a.b(this.b.f());
            if (aVar != null) {
                this.a.a(aVar.b());
            }
        } else {
            this.a.b(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.onPreExecute();
    }
}
