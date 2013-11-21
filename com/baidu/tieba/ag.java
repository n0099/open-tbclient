package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LogoActivity logoActivity) {
        this.f1103a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f1103a.e = com.baidu.tieba.util.m.a(this.f1103a, (int) R.drawable.logo);
        imageView = this.f1103a.d;
        bitmap = this.f1103a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f1103a.d;
        alphaAnimation = this.f1103a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
