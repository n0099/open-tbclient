package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.performanceLog.z;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aFj = logoActivity;
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
        RelativeLayout relativeLayout3;
        View view2;
        view = this.aFj.aEZ;
        if (view != null) {
            relativeLayout = this.aFj.mRootView;
            if (relativeLayout != null) {
                this.aFj.aFa = com.baidu.tbadk.core.util.c.f(this.aFj.getPageContext().getPageActivity(), n.e.logo_ad_bg);
                bitmap = this.aFj.aFa;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aFj.aFa = com.baidu.tbadk.core.util.c.a(this.aFj.getPageContext().getPageActivity(), n.e.logo_ad_bg, options);
                }
                bitmap2 = this.aFj.aFa;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aFj.aFa;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aFj.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                relativeLayout3 = this.aFj.mRootView;
                view2 = this.aFj.aEZ;
                relativeLayout3.addView(view2);
                z.EY().S(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        aVar = this.aFj.aFf;
        hj.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hj2 = com.baidu.adp.lib.h.h.hj();
        aVar2 = this.aFj.aFf;
        hj2.postDelayed(aVar2, 3000L);
    }
}
