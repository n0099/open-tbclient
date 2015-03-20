package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        Bitmap i;
        ImageView imageView;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        Animation.AnimationListener animationListener;
        ImageView imageView3;
        ImageView imageView4;
        Bitmap bitmap2;
        ImageView imageView5;
        AlphaAnimation alphaAnimation2;
        Animation.AnimationListener animationListener2;
        n nVar = new n();
        this.atC.mBitmap = nVar.am(this.atC.getPageContext().getPageActivity());
        LogoActivity logoActivity = this.atC;
        bitmap = this.atC.mBitmap;
        i = logoActivity.i(bitmap);
        if (i != null) {
            imageView3 = this.atC.atv;
            if (imageView3 != null) {
                imageView4 = this.atC.atv;
                bitmap2 = this.atC.mBitmap;
                imageView4.setImageBitmap(bitmap2);
                LogoActivity logoActivity2 = this.atC;
                imageView5 = this.atC.atv;
                alphaAnimation2 = this.atC.atw;
                animationListener2 = this.atC.atx;
                logoActivity2.startAnimation(imageView5, alphaAnimation2, animationListener2);
                return;
            }
        }
        try {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.atC.getPageContext().getPageActivity(), w.custom_logo_view, null);
            if (inflate != null) {
                imageView = this.atC.atv;
                if (imageView != null) {
                    imageView2 = this.atC.atv;
                    ViewGroup viewGroup = (ViewGroup) imageView2.getParent();
                    viewGroup.removeAllViews();
                    viewGroup.addView(inflate);
                } else {
                    ViewGroup viewGroup2 = (ViewGroup) this.atC.getWindow().getDecorView();
                    if (viewGroup2 != null) {
                        viewGroup2.removeAllViews();
                        viewGroup2.addView(inflate);
                    }
                }
                LogoActivity logoActivity3 = this.atC;
                alphaAnimation = this.atC.atw;
                animationListener = this.atC.atx;
                logoActivity3.startAnimation(inflate, alphaAnimation, animationListener);
                return;
            }
            this.atC.al(this.atC.getBaseContext());
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.m411getInst().onLowMemory();
            this.atC.al(this.atC.getBaseContext());
        }
    }
}
