package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aGJ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        LogoActivity.a aVar;
        LogoActivity.a aVar2;
        RelativeLayout relativeLayout;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        RelativeLayout relativeLayout2;
        View view2;
        RelativeLayout relativeLayout3;
        View view3;
        view = this.aGJ.aGz;
        if (view != null) {
            relativeLayout = this.aGJ.mRootView;
            if (relativeLayout != null) {
                this.aGJ.aGA = com.baidu.tbadk.core.util.c.f(this.aGJ.getPageContext().getPageActivity(), n.f.logo_ad_bg);
                bitmap = this.aGJ.aGA;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aGJ.aGA = com.baidu.tbadk.core.util.c.a(this.aGJ.getPageContext().getPageActivity(), n.f.logo_ad_bg, options);
                }
                bitmap2 = this.aGJ.aGA;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aGJ.aGA;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aGJ.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aGJ.aGz;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aGJ.mRootView;
                    view3 = this.aGJ.aGz;
                    relativeLayout3.addView(view3);
                }
                com.baidu.tbadk.performanceLog.z.EN().T(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        aVar = this.aGJ.aGF;
        hj.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hj2 = com.baidu.adp.lib.h.h.hj();
        aVar2 = this.aGJ.aGF;
        hj2.postDelayed(aVar2, 3000L);
    }
}
