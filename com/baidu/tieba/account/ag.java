package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.aa Ok = null;
    final /* synthetic */ Register2Activity awk;
    private String mUrl;

    public ag(Register2Activity register2Activity, String str) {
        this.awk = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.awk.awf = null;
        progressBar = this.awk.avZ;
        progressBar.setVisibility(8);
        if (this.Ok != null) {
            this.Ok.hh();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.awk.awa;
        imageView.setImageDrawable(null);
        progressBar = this.awk.avZ;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        this.Ok = new com.baidu.tbadk.core.util.aa(this.mUrl);
        return com.baidu.tbadk.core.util.c.w(this.Ok.rP());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((ag) bitmap);
        this.awk.awf = null;
        progressBar = this.awk.avZ;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.awk.awa;
            imageView.setImageBitmap(bitmap);
        }
    }
}
