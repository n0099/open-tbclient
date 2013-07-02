package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.a.e = com.baidu.tieba.util.d.a(this.a, (int) R.drawable.logo);
        imageView = this.a.d;
        bitmap = this.a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.a.d;
        alphaAnimation = this.a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
