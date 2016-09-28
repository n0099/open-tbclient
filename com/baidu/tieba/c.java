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
    final /* synthetic */ LogoActivity aKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aKV = logoActivity;
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
        view = this.aKV.aKJ;
        if (view != null) {
            relativeLayout = this.aKV.mRootView;
            if (relativeLayout != null) {
                this.aKV.aKK = BitmapHelper.getLogoBitmap(this.aKV.getPageContext().getPageActivity(), r.f.logo_ad_bg);
                bitmap = this.aKV.aKK;
                if (bitmap == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    options.inSampleSize = 2;
                    this.aKV.aKK = BitmapHelper.getResBitmap(this.aKV.getPageContext().getPageActivity(), r.f.logo_ad_bg, options);
                }
                bitmap2 = this.aKV.aKK;
                if (bitmap2 != null) {
                    try {
                        bitmap3 = this.aKV.aKK;
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                        relativeLayout2 = this.aKV.mRootView;
                        relativeLayout2.setBackgroundDrawable(bitmapDrawable);
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                    }
                }
                view2 = this.aKV.aKJ;
                if (view2.getParent() == null) {
                    relativeLayout4 = this.aKV.mRootView;
                    view3 = this.aKV.aKJ;
                    relativeLayout4.addView(view3);
                }
                relativeLayout3 = this.aKV.mRootView;
                relativeLayout3.setFocusable(true);
                com.baidu.tbadk.performanceLog.ab.Gu().ae(System.currentTimeMillis());
            }
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        aVar = this.aKV.aKP;
        eG.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        aVar2 = this.aKV.aKP;
        eG2.postDelayed(aVar2, 3100L);
    }
}
