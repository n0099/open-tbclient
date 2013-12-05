package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.am f1042a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private af(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.f1042a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(LoginActivity loginActivity, v vVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.O = null;
        if (this.f1042a != null) {
            this.f1042a.j();
            this.f1042a = null;
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
        this.f1042a = new com.baidu.tieba.util.am(str);
        return com.baidu.tieba.util.m.a(this.f1042a.k());
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
        super.a((af) bitmap);
    }
}
