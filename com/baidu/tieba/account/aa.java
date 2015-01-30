package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.ad AR = null;
    final /* synthetic */ Register2Activity aod;
    private String mUrl;

    public aa(Register2Activity register2Activity, String str) {
        this.aod = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.aod.anY = null;
        progressBar = this.aod.anT;
        progressBar.setVisibility(8);
        if (this.AR != null) {
            this.AR.dJ();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.aod.Qi;
        imageView.setImageDrawable(null);
        progressBar = this.aod.anT;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        this.AR = new com.baidu.tbadk.core.util.ad(this.mUrl);
        return com.baidu.tbadk.core.util.d.v(this.AR.oz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((aa) bitmap);
        this.aod.anY = null;
        progressBar = this.aod.anT;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.aod.Qi;
            imageView.setImageBitmap(bitmap);
        }
    }
}
