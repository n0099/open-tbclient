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
    com.baidu.tieba.util.ap f1028a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ad(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.f1028a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(LoginActivity loginActivity, t tVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.O = null;
        if (this.f1028a != null) {
            this.f1028a.h();
            this.f1028a = null;
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
        this.f1028a = new com.baidu.tieba.util.ap(str);
        return com.baidu.tieba.util.m.a(this.f1028a.i());
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
        super.a((ad) bitmap);
    }
}
