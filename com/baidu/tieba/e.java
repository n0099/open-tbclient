package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ LogoActivity aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LogoActivity logoActivity) {
        this.aKF = logoActivity;
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
        view = this.aKF.aKp;
        if (view != null) {
            relativeLayout = this.aKF.mRootView;
            if (relativeLayout != null) {
                this.aKF.aKq = BitmapHelper.getLogoBitmap(this.aKF.getPageContext().getPageActivity(), t.f.logo_ad_bg);
                bitmap = this.aKF.aKq;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aKF.aKq = BitmapHelper.getResBitmap(this.aKF.getPageContext().getPageActivity(), t.f.logo_ad_bg, options);
                }
                bitmap2 = this.aKF.aKq;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aKF.aKq;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aKF.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aKF.aKp;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aKF.mRootView;
                    view3 = this.aKF.aKp;
                    relativeLayout3.addView(view3);
                }
                com.baidu.tbadk.performanceLog.ab.Ha().aa(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        aVar = this.aKF.aKy;
        hx.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hx2 = com.baidu.adp.lib.h.h.hx();
        aVar2 = this.aKF.aKy;
        hx2.postDelayed(aVar2, 3000L);
    }
}
