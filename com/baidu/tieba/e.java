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
    final /* synthetic */ LogoActivity aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LogoActivity logoActivity) {
        this.aGQ = logoActivity;
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
        view = this.aGQ.aGA;
        if (view != null) {
            relativeLayout = this.aGQ.mRootView;
            if (relativeLayout != null) {
                this.aGQ.aGB = BitmapHelper.getLogoBitmap(this.aGQ.getPageContext().getPageActivity(), t.f.logo_ad_bg);
                bitmap = this.aGQ.aGB;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aGQ.aGB = BitmapHelper.getResBitmap(this.aGQ.getPageContext().getPageActivity(), t.f.logo_ad_bg, options);
                }
                bitmap2 = this.aGQ.aGB;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aGQ.aGB;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aGQ.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aGQ.aGA;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aGQ.mRootView;
                    view3 = this.aGQ.aGA;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aGQ.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.ET().ab(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        aVar = this.aGQ.aGJ;
        dL.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        aVar2 = this.aGQ.aGJ;
        dL2.postDelayed(aVar2, 3000L);
    }
}
