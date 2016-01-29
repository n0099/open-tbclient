package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aHJ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RelativeLayout relativeLayout;
        LogoActivity.a aVar;
        LogoActivity.a aVar2;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        relativeLayout = this.aHJ.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aHJ.aHy;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aHJ;
                bitmap2 = this.aHJ.aHy;
                logoActivity.aHu = bitmap2;
                bitmap3 = this.aHJ.aHu;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10859"));
                    this.aHJ.aHz = true;
                    bitmap4 = this.aHJ.aHu;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aHJ.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aHJ.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aHJ.mRootView;
                    relativeLayout4.setOnClickListener(new d(this));
                }
                com.baidu.tbadk.performanceLog.ab.Ge().W(System.currentTimeMillis());
                com.baidu.tieba.a.a.Lb().Lh();
            }
        }
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        aVar = this.aHJ.aHC;
        hr.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hr2 = com.baidu.adp.lib.h.h.hr();
        aVar2 = this.aHJ.aHC;
        hr2.postDelayed(aVar2, 1500L);
    }
}
