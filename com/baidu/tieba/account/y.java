package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ Register2Activity afJ;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private String mUrl;

    public y(Register2Activity register2Activity, String str) {
        this.afJ = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.afJ.afE = null;
        progressBar = this.afJ.afz;
        progressBar.setVisibility(8);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.afJ.Kw;
        imageView.setImageDrawable(null);
        progressBar = this.afJ.afz;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public Bitmap doInBackground(String... strArr) {
        this.mNetWork = new com.baidu.tbadk.core.util.ac(this.mUrl);
        return com.baidu.tbadk.core.util.d.w(this.mNetWork.lB());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        this.afJ.afE = null;
        progressBar = this.afJ.afz;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.afJ.Kw;
            imageView.setImageBitmap(bitmap);
        }
    }
}
