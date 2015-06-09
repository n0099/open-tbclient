package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<String, Integer, Bitmap> {
    private com.baidu.tbadk.core.util.aa OE = null;
    final /* synthetic */ Register2Activity axQ;
    private String mUrl;

    public al(Register2Activity register2Activity, String str) {
        this.axQ = register2Activity;
        this.mUrl = null;
        this.mUrl = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.axQ.axL = null;
        progressBar = this.axQ.axF;
        progressBar.setVisibility(8);
        if (this.OE != null) {
            this.OE.gS();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.axQ.axG;
        imageView.setImageDrawable(null);
        progressBar = this.axQ.axF;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        this.OE = new com.baidu.tbadk.core.util.aa(this.mUrl);
        return com.baidu.tbadk.core.util.c.w(this.OE.sx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((al) bitmap);
        this.axQ.axL = null;
        progressBar = this.axQ.axF;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            imageView = this.axQ.axG;
            imageView.setImageBitmap(bitmap);
        }
    }
}
