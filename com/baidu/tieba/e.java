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
    final /* synthetic */ LogoActivity aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LogoActivity logoActivity) {
        this.aHJ = logoActivity;
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
        view = this.aHJ.aHt;
        if (view != null) {
            relativeLayout = this.aHJ.mRootView;
            if (relativeLayout != null) {
                this.aHJ.aHu = BitmapHelper.getLogoBitmap(this.aHJ.getPageContext().getPageActivity(), t.f.logo_ad_bg);
                bitmap = this.aHJ.aHu;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aHJ.aHu = BitmapHelper.getResBitmap(this.aHJ.getPageContext().getPageActivity(), t.f.logo_ad_bg, options);
                }
                bitmap2 = this.aHJ.aHu;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aHJ.aHu;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aHJ.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aHJ.aHt;
                if (view2.getParent() == null) {
                    relativeLayout3 = this.aHJ.mRootView;
                    view3 = this.aHJ.aHt;
                    relativeLayout3.addView(view3);
                }
                com.baidu.tbadk.performanceLog.ab.Ge().W(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        aVar = this.aHJ.aHC;
        hr.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hr2 = com.baidu.adp.lib.h.h.hr();
        aVar2 = this.aHJ.aHC;
        hr2.postDelayed(aVar2, 3000L);
    }
}
