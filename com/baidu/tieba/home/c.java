package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private al d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.g();
        }
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.o = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.a = createBarActivity;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.d = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/create");
            this.d.a().a().a = true;
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            al alVar = this.d;
            str = this.a.s;
            alVar.a("vcode_md5", str);
            this.d.i();
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute(str);
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.o = null;
        if (this.d.a().b().b()) {
            CreateBarSuccessActivity.a(this.a, this.b);
            this.a.finish();
            return;
        }
        this.a.showToast(this.d.f());
        if (this.d.c()) {
            this.a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.a.m;
        progressBar.setVisibility(0);
    }
}
