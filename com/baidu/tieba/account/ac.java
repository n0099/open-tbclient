package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.z f886a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ac(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.f886a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(LoginActivity loginActivity, ac acVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.S = null;
        if (this.f886a != null) {
            this.f886a.h();
            this.f886a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ImageView imageView;
        imageView = this.b.x;
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
        this.f886a = new com.baidu.tieba.util.z(str);
        return com.baidu.tieba.util.e.a(this.f886a.i());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.b.S = null;
        if (bitmap != null) {
            imageView2 = this.b.x;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.b.x;
            imageView.setImageResource(R.drawable.background);
        }
        progressBar = this.b.A;
        progressBar.setVisibility(8);
        super.a((ac) bitmap);
    }
}
