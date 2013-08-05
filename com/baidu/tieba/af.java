package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(LogoActivity logoActivity) {
        this.f901a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f901a.e = com.baidu.tieba.util.e.a(this.f901a, (int) R.drawable.logo);
        imageView = this.f901a.d;
        bitmap = this.f901a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f901a.d;
        alphaAnimation = this.f901a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
