package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends BdAsyncTask<String, Integer, Bitmap> {
    ak a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.c) {
            return null;
        }
        this.a = new ak(str);
        return com.baidu.tbadk.core.util.g.a(this.a.h());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        Bitmap bitmap2 = bitmap;
        this.b.O = null;
        if (bitmap2 != null) {
            imageView2 = this.b.s;
            imageView2.setImageBitmap(bitmap2);
        } else {
            imageView = this.b.s;
            imageView.setImageResource(com.baidu.tbadk.i.background);
        }
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        super.a((z) bitmap2);
    }

    private z(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(LoginActivity loginActivity, byte b) {
        this(loginActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.b.O = null;
        if (this.a != null) {
            this.a.g();
            this.a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ImageView imageView;
        imageView = this.b.s;
        imageView.setImageBitmap(null);
    }
}
