package com.baidu.tieba.account.login;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, Bitmap> {
    aa OE;
    final /* synthetic */ Login2Activity ayM;
    private volatile boolean ayP;

    private l(Login2Activity login2Activity) {
        this.ayM = login2Activity;
        this.OE = null;
        this.ayP = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(Login2Activity login2Activity, l lVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.ayM.ayL = null;
        if (this.OE != null) {
            this.OE.gS();
            this.OE = null;
        }
        this.ayP = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.ayM.axF;
        imageView.setImageDrawable(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.ayP) {
            return null;
        }
        this.OE = new aa(str);
        return com.baidu.tbadk.core.util.c.w(this.OE.sx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.ayM.ayL = null;
        if (bitmap != null) {
            imageView2 = this.ayM.axF;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.ayM.axF;
            imageView.setImageResource(p.background);
        }
        progressBar = this.ayM.mProgressBar;
        progressBar.setVisibility(8);
        super.onPostExecute((l) bitmap);
    }
}
