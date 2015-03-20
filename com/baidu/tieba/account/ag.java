package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.aa Oi = null;
    final /* synthetic */ Register2Activity awc;
    private String mUrl;

    public ag(Register2Activity register2Activity, String str) {
        this.awc = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.awc.avX = null;
        progressBar = this.awc.avR;
        progressBar.setVisibility(8);
        if (this.Oi != null) {
            this.Oi.hh();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.awc.avS;
        imageView.setImageDrawable(null);
        progressBar = this.awc.avR;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        this.Oi = new com.baidu.tbadk.core.util.aa(this.mUrl);
        return com.baidu.tbadk.core.util.c.w(this.Oi.rP());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((ag) bitmap);
        this.awc.avX = null;
        progressBar = this.awc.avR;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.awc.avS;
            imageView.setImageBitmap(bitmap);
        }
    }
}
