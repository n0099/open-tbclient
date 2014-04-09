package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    final /* synthetic */ p a;
    private com.baidu.tbadk.core.util.ak b = null;
    private String c;
    private String d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tbadk.coreExtra.data.a a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tbadk.a aVar2;
        com.baidu.tbadk.coreExtra.data.a aVar3 = aVar;
        super.a((v) aVar3);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.c()) {
            this.a.b(this.b.f());
        } else if (this.b.d() == 0) {
            p pVar = this.a;
            aVar2 = this.a.j;
            pVar.b(aVar2.getString(com.baidu.tbadk.l.name_not_use));
        } else if (this.b.d() == 36) {
            this.a.b(this.b.f());
            if (aVar3 != null) {
                this.a.a(aVar3.b());
            }
        } else {
            this.a.b(this.b.f());
        }
    }

    public v(p pVar, String str, String str2) {
        this.a = pVar;
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

    private com.baidu.tbadk.coreExtra.data.a a() {
        this.b = new com.baidu.tbadk.core.util.ak(this.c);
        this.b.a("un", this.d);
        String i = this.b.i();
        if (!this.b.c() || this.b.d() != 36) {
            return null;
        }
        com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
        aVar.a(i);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.c();
    }
}
