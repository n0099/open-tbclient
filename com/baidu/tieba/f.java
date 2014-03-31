package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        ImageView imageView;
        ImageView imageView2;
        Bitmap bitmap2;
        ImageView imageView3;
        AlphaAnimation alphaAnimation;
        this.a.d = com.baidu.tbadk.core.util.g.a(this.a, com.baidu.b.a.e.logo);
        bitmap = this.a.d;
        if (bitmap != null) {
            imageView = this.a.c;
            if (imageView != null) {
                imageView2 = this.a.c;
                bitmap2 = this.a.d;
                imageView2.setImageBitmap(bitmap2);
                imageView3 = this.a.c;
                alphaAnimation = this.a.e;
                imageView3.startAnimation(alphaAnimation);
            }
        }
    }
}
