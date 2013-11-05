package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1037a;
    private com.baidu.tieba.util.ag b = null;
    private String c;

    public ay(Register2Activity register2Activity, String str) {
        this.f1037a = register2Activity;
        this.c = null;
        this.c = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1037a.Q = null;
        progressBar = this.f1037a.I;
        progressBar.setVisibility(8);
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.f1037a.J;
        imageView.setImageBitmap(null);
        progressBar = this.f1037a.I;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        this.b = new com.baidu.tieba.util.ag(this.c);
        return com.baidu.tieba.util.e.a(this.b.i());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((ay) bitmap);
        this.f1037a.Q = null;
        progressBar = this.f1037a.I;
        progressBar.setVisibility(8);
        imageView = this.f1037a.J;
        imageView.setImageBitmap(bitmap);
    }
}
