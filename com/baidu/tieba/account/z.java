package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.ad AR = null;
    final /* synthetic */ Register2Activity ani;
    private String mUrl;

    public z(Register2Activity register2Activity, String str) {
        this.ani = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.ani.and = null;
        progressBar = this.ani.amY;
        progressBar.setVisibility(8);
        if (this.AR != null) {
            this.AR.dL();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.ani.PG;
        imageView.setImageDrawable(null);
        progressBar = this.ani.amY;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        this.AR = new com.baidu.tbadk.core.util.ad(this.mUrl);
        return com.baidu.tbadk.core.util.d.v(this.AR.ow());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((z) bitmap);
        this.ani.and = null;
        progressBar = this.ani.amY;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.ani.PG;
            imageView.setImageBitmap(bitmap);
        }
    }
}
