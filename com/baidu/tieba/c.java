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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aLM = logoActivity;
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
        view = this.aLM.aLA;
        if (view != null) {
            relativeLayout = this.aLM.mRootView;
            if (relativeLayout != null) {
                this.aLM.aLB = BitmapHelper.getLogoBitmap(this.aLM.getPageContext().getPageActivity(), r.f.logo_ad_bg);
                bitmap = this.aLM.aLB;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aLM.aLB = BitmapHelper.getResBitmap(this.aLM.getPageContext().getPageActivity(), r.f.logo_ad_bg, options);
                }
                bitmap2 = this.aLM.aLB;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aLM.aLB;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aLM.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aLM.aLA;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aLM.mRootView;
                    view3 = this.aLM.aLA;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aLM.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.GA().ac(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        aVar = this.aLM.aLG;
        eG.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        aVar2 = this.aLM.aLG;
        eG2.postDelayed(aVar2, 3100L);
    }
}
