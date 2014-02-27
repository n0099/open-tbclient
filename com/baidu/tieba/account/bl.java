package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.util.ba b = null;
    private String c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(String... strArr) {
        this.b = new com.baidu.tieba.util.ba(this.c);
        return com.baidu.tieba.util.n.a(this.b.k());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap2 = bitmap;
        super.a((bl) bitmap2);
        this.a.N = null;
        progressBar = this.a.E;
        progressBar.setVisibility(8);
        imageView = this.a.F;
        imageView.setImageBitmap(bitmap2);
    }

    public bl(Register2Activity register2Activity, String str) {
        this.a = register2Activity;
        this.c = null;
        this.c = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
    public final void b() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.a.F;
        imageView.setImageBitmap(null);
        progressBar = this.a.E;
        progressBar.setVisibility(0);
    }
}
