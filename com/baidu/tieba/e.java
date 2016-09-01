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
    final /* synthetic */ LogoActivity aLA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LogoActivity logoActivity) {
        this.aLA = logoActivity;
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
        view = this.aLA.aLk;
        if (view != null) {
            relativeLayout = this.aLA.mRootView;
            if (relativeLayout != null) {
                this.aLA.aLl = BitmapHelper.getLogoBitmap(this.aLA.getPageContext().getPageActivity(), t.f.logo_ad_bg);
                bitmap = this.aLA.aLl;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aLA.aLl = BitmapHelper.getResBitmap(this.aLA.getPageContext().getPageActivity(), t.f.logo_ad_bg, options);
                }
                bitmap2 = this.aLA.aLl;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aLA.aLl;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aLA.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aLA.aLk;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aLA.mRootView;
                    view3 = this.aLA.aLk;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aLA.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Gv().ad(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        aVar = this.aLA.aLt;
        eG.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        aVar2 = this.aLA.aLt;
        eG2.postDelayed(aVar2, 3100L);
    }
}
