package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.ad AO = null;
    final /* synthetic */ Register2Activity aoa;
    private String mUrl;

    public aa(Register2Activity register2Activity, String str) {
        this.aoa = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.aoa.anV = null;
        progressBar = this.aoa.anQ;
        progressBar.setVisibility(8);
        if (this.AO != null) {
            this.AO.dJ();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.aoa.Qf;
        imageView.setImageDrawable(null);
        progressBar = this.aoa.anQ;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        this.AO = new com.baidu.tbadk.core.util.ad(this.mUrl);
        return com.baidu.tbadk.core.util.d.v(this.AO.os());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((aa) bitmap);
        this.aoa.anV = null;
        progressBar = this.aoa.anQ;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.aoa.Qf;
            imageView.setImageBitmap(bitmap);
        }
    }
}
