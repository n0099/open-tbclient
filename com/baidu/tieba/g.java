package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.atK = logoActivity;
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
        this.atK.mBitmap = nVar.am(this.atK.getPageContext().getPageActivity());
        LogoActivity logoActivity = this.atK;
        bitmap = this.atK.mBitmap;
        i = logoActivity.i(bitmap);
        if (i != null) {
            imageView3 = this.atK.atD;
            if (imageView3 != null) {
                imageView4 = this.atK.atD;
                bitmap2 = this.atK.mBitmap;
                imageView4.setImageBitmap(bitmap2);
                LogoActivity logoActivity2 = this.atK;
                imageView5 = this.atK.atD;
                alphaAnimation2 = this.atK.atE;
                animationListener2 = this.atK.atF;
                logoActivity2.startAnimation(imageView5, alphaAnimation2, animationListener2);
                return;
            }
        }
        try {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.atK.getPageContext().getPageActivity(), w.custom_logo_view, null);
            if (inflate != null) {
                imageView = this.atK.atD;
                if (imageView != null) {
                    imageView2 = this.atK.atD;
                    ViewGroup viewGroup = (ViewGroup) imageView2.getParent();
                    viewGroup.removeAllViews();
                    viewGroup.addView(inflate);
                } else {
                    ViewGroup viewGroup2 = (ViewGroup) this.atK.getWindow().getDecorView();
                    if (viewGroup2 != null) {
                        viewGroup2.removeAllViews();
                        viewGroup2.addView(inflate);
                    }
                }
                LogoActivity logoActivity3 = this.atK;
                alphaAnimation = this.atK.atE;
                animationListener = this.atK.atF;
                logoActivity3.startAnimation(inflate, alphaAnimation, animationListener);
                return;
            }
            this.atK.al(this.atK.getBaseContext());
        } catch (InflateException e) {
            TbadkCoreApplication.m411getInst().onLowMemory();
            this.atK.al(this.atK.getBaseContext());
        }
    }
}
