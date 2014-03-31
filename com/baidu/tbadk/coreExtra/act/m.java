package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity a;
    private ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (!this.b.a().b().b()) {
                this.a.showToast(this.b.f());
                return;
            }
            this.a.setResult(-1);
            this.a.finish();
            this.a.showToast(this.a.getString(com.baidu.tbadk.l.upload_head_ok));
        }
    }

    private m(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(EditHeadActivity editHeadActivity, byte b) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tbadk.l.upload_head));
    }

    private String a() {
        String str;
        Exception e;
        this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/img/portrait");
        try {
            str = this.b.b("tieba_head_image");
            try {
                if (this.b.a().b().b()) {
                    return str;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            str = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.closeLoadingDialog();
        this.a.u = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }
}
