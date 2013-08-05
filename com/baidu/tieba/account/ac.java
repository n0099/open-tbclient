package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.u f851a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ac(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.f851a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(LoginActivity loginActivity, ac acVar) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.S = null;
        if (this.f851a != null) {
            this.f851a.i();
            this.f851a = null;
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
        this.f851a = new com.baidu.tieba.util.u(str);
        return com.baidu.tieba.util.e.a(this.f851a.j());
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
        super.a((Object) bitmap);
    }
}
