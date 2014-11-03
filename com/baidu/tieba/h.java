package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.acU = logoActivity;
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
        if (TbadkSettings.getInst().loadBoolean(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), false)) {
            this.acU.mBitmap = com.baidu.tbadk.core.util.d.e(this.acU, u.logo_vip);
        } else {
            this.acU.mBitmap = com.baidu.tbadk.core.util.d.e(this.acU, u.logo);
        }
        bitmap = this.acU.mBitmap;
        if (bitmap != null) {
            imageView = this.acU.acK;
            if (imageView != null) {
                imageView2 = this.acU.acK;
                bitmap2 = this.acU.mBitmap;
                imageView2.setImageBitmap(bitmap2);
                LogoActivity logoActivity = this.acU;
                imageView3 = this.acU.acK;
                alphaAnimation = this.acU.acL;
                animationListener = this.acU.acM;
                logoActivity.startAnimation(imageView3, alphaAnimation, animationListener);
            }
        }
    }
}
