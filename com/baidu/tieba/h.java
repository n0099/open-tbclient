package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.acP = logoActivity;
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
            this.acP.mBitmap = com.baidu.tbadk.core.util.d.e(this.acP, u.logo_vip);
        } else {
            this.acP.mBitmap = com.baidu.tbadk.core.util.d.e(this.acP, u.logo);
        }
        bitmap = this.acP.mBitmap;
        if (bitmap != null) {
            imageView = this.acP.acF;
            if (imageView != null) {
                imageView2 = this.acP.acF;
                bitmap2 = this.acP.mBitmap;
                imageView2.setImageBitmap(bitmap2);
                LogoActivity logoActivity = this.acP;
                imageView3 = this.acP.acF;
                alphaAnimation = this.acP.acG;
                animationListener = this.acP.acH;
                logoActivity.startAnimation(imageView3, alphaAnimation, animationListener);
            }
        }
    }
}
