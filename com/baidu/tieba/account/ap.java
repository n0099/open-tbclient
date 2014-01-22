package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<String, Integer, Bitmap> {
    com.baidu.tieba.util.ax a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ap(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(LoginActivity loginActivity, af afVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.O = null;
        if (this.a != null) {
            this.a.k();
            this.a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ImageView imageView;
        imageView = this.b.s;
        imageView.setImageBitmap(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.c) {
            return null;
        }
        this.a = new com.baidu.tieba.util.ax(str);
        return com.baidu.tieba.util.n.a(this.a.l());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.b.O = null;
        if (bitmap != null) {
            imageView2 = this.b.s;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.b.s;
            imageView.setImageResource(R.drawable.background);
        }
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        super.a((ap) bitmap);
    }
}
