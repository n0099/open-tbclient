package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.ag f1016a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ad(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.f1016a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(LoginActivity loginActivity, t tVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.S = null;
        if (this.f1016a != null) {
            this.f1016a.h();
            this.f1016a = null;
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
        this.f1016a = new com.baidu.tieba.util.ag(str);
        return com.baidu.tieba.util.e.a(this.f1016a.i());
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
        super.a((ad) bitmap);
    }
}
