package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.a.a {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.d.t b = null;
    private String c;

    public aw(Register2Activity register2Activity, String str) {
        this.a = register2Activity;
        this.c = null;
        this.c = str;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        this.a.Q = null;
        progressBar = this.a.I;
        progressBar.setVisibility(8);
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.a.J;
        imageView.setImageBitmap(null);
        progressBar = this.a.I;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Bitmap a(String... strArr) {
        this.b = new com.baidu.tieba.d.t(this.c);
        return com.baidu.tieba.d.d.a(this.b.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((Object) bitmap);
        this.a.Q = null;
        progressBar = this.a.I;
        progressBar.setVisibility(8);
        imageView = this.a.J;
        imageView.setImageBitmap(bitmap);
    }
}
