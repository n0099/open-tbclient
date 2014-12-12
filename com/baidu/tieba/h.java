package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        ImageView imageView;
        ImageView imageView2;
        Bitmap bitmap2;
        ImageView imageView3;
        AlphaAnimation alphaAnimation;
        Animation.AnimationListener animationListener;
        o oVar = new o();
        this.akC.mBitmap = oVar.aj(this.akC.getPageContext().getPageActivity());
        bitmap = this.akC.mBitmap;
        if (bitmap != null) {
            imageView = this.akC.akv;
            if (imageView != null) {
                imageView2 = this.akC.akv;
                bitmap2 = this.akC.mBitmap;
                imageView2.setImageBitmap(bitmap2);
                LogoActivity logoActivity = this.akC;
                imageView3 = this.akC.akv;
                alphaAnimation = this.akC.akw;
                animationListener = this.akC.akx;
                logoActivity.startAnimation(imageView3, alphaAnimation, animationListener);
            }
        }
    }
}
