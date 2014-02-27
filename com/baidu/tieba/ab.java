package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ab implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LogoActivity logoActivity) {
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
        this.a.e = com.baidu.tieba.util.n.a(this.a, (int) R.drawable.logo);
        bitmap = this.a.e;
        if (bitmap != null) {
            imageView = this.a.d;
            if (imageView != null) {
                imageView2 = this.a.d;
                bitmap2 = this.a.e;
                imageView2.setImageBitmap(bitmap2);
                imageView3 = this.a.d;
                alphaAnimation = this.a.f;
                imageView3.startAnimation(alphaAnimation);
            }
        }
    }
}
