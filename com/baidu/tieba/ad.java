package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LogoActivity logoActivity) {
        this.f686a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f686a.e = com.baidu.tieba.util.d.a(this.f686a, (int) R.drawable.logo);
        imageView = this.f686a.d;
        bitmap = this.f686a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f686a.d;
        alphaAnimation = this.f686a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
