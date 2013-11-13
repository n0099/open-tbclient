package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LogoActivity logoActivity) {
        this.f1097a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f1097a.e = com.baidu.tieba.util.m.a(this.f1097a, (int) R.drawable.logo);
        imageView = this.f1097a.d;
        bitmap = this.f1097a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f1097a.d;
        alphaAnimation = this.f1097a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
