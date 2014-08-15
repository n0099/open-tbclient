package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        ImageView imageView;
        ImageView imageView2;
        Bitmap bitmap2;
        ImageView imageView3;
        AlphaAnimation alphaAnimation;
        if (com.baidu.tbadk.h.a().a(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), false)) {
            this.a.d = com.baidu.tbadk.core.util.d.a(this.a, t.logo_vip);
        } else {
            this.a.d = com.baidu.tbadk.core.util.d.a(this.a, t.logo);
        }
        bitmap = this.a.d;
        if (bitmap != null) {
            imageView = this.a.c;
            if (imageView != null) {
                imageView2 = this.a.c;
                bitmap2 = this.a.d;
                imageView2.setImageBitmap(bitmap2);
                imageView3 = this.a.c;
                alphaAnimation = this.a.e;
                imageView3.startAnimation(alphaAnimation);
            }
        }
    }
}
