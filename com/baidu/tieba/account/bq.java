package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.at b = null;
    private String c;

    public bq(Register2Activity register2Activity, String str) {
        this.a = register2Activity;
        this.c = null;
        this.c = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.N = null;
        progressBar = this.a.E;
        progressBar.setVisibility(8);
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.a.F;
        imageView.setImageBitmap(null);
        progressBar = this.a.E;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        this.b = new com.baidu.tieba.util.at(this.c);
        return com.baidu.tieba.util.m.a(this.b.k());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((bq) bitmap);
        this.a.N = null;
        progressBar = this.a.E;
        progressBar.setVisibility(8);
        imageView = this.a.F;
        imageView.setImageBitmap(bitmap);
    }
}
