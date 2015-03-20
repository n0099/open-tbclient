package com.baidu.tieba.account.login;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, Bitmap> {
    aa Oi;
    final /* synthetic */ Login2Activity awY;
    private volatile boolean wb;

    private k(Login2Activity login2Activity) {
        this.awY = login2Activity;
        this.Oi = null;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(Login2Activity login2Activity, k kVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Login2Activity.a(this.awY, (k) null);
        if (this.Oi != null) {
            this.Oi.hh();
            this.Oi = null;
        }
        this.wb = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Login2Activity.l(this.awY).setImageDrawable(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.wb) {
            return null;
        }
        this.Oi = new aa(str);
        return com.baidu.tbadk.core.util.c.w(this.Oi.rP());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        Login2Activity.a(this.awY, (k) null);
        if (bitmap != null) {
            Login2Activity.l(this.awY).setImageBitmap(bitmap);
        } else {
            Login2Activity.l(this.awY).setImageResource(u.background);
        }
        Login2Activity.m(this.awY).setVisibility(8);
        super.onPostExecute((k) bitmap);
    }
}
