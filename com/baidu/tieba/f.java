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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.aHs = logoActivity;
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
        RelativeLayout relativeLayout4;
        View view3;
        view = this.aHs.aHc;
        if (view != null) {
            relativeLayout = this.aHs.mRootView;
            if (relativeLayout != null) {
                this.aHs.aHd = BitmapHelper.getLogoBitmap(this.aHs.getPageContext().getPageActivity(), u.f.logo_ad_bg);
                bitmap = this.aHs.aHd;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aHs.aHd = BitmapHelper.getResBitmap(this.aHs.getPageContext().getPageActivity(), u.f.logo_ad_bg, options);
                }
                bitmap2 = this.aHs.aHd;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aHs.aHd;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aHs.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aHs.aHc;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aHs.mRootView;
                    view3 = this.aHs.aHc;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aHs.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Fc().ae(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        aVar = this.aHs.aHl;
        dM.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dM2 = com.baidu.adp.lib.h.h.dM();
        aVar2 = this.aHs.aHl;
        dM2.postDelayed(aVar2, 3100L);
    }
}
