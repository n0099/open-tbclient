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
    final /* synthetic */ LogoActivity aIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.aIj = logoActivity;
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
        view = this.aIj.aHT;
        if (view != null) {
            relativeLayout = this.aIj.mRootView;
            if (relativeLayout != null) {
                this.aIj.aHU = BitmapHelper.getLogoBitmap(this.aIj.getPageContext().getPageActivity(), u.f.logo_ad_bg);
                bitmap = this.aIj.aHU;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aIj.aHU = BitmapHelper.getResBitmap(this.aIj.getPageContext().getPageActivity(), u.f.logo_ad_bg, options);
                }
                bitmap2 = this.aIj.aHU;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aIj.aHU;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aIj.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aIj.aHT;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aIj.mRootView;
                    view3 = this.aIj.aHT;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aIj.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Fb().Z(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        aVar = this.aIj.aIc;
        dL.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        aVar2 = this.aIj.aIc;
        dL2.postDelayed(aVar2, 3100L);
    }
}
