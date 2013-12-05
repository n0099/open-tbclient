package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(LogoActivity logoActivity) {
        this.f1118a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f1118a.e = com.baidu.tieba.util.m.a(this.f1118a, (int) R.drawable.logo);
        imageView = this.f1118a.d;
        bitmap = this.f1118a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f1118a.d;
        alphaAnimation = this.f1118a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
