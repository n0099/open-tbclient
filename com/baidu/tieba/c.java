package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aKF = logoActivity;
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
        relativeLayout = this.aKF.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aKF.aKu;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aKF;
                bitmap2 = this.aKF.aKu;
                logoActivity.aKq = bitmap2;
                bitmap3 = this.aKF.aKq;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new aw("c10859"));
                    this.aKF.aKv = true;
                    bitmap4 = this.aKF.aKq;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aKF.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aKF.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aKF.mRootView;
                    relativeLayout4.setOnClickListener(new d(this));
                }
                com.baidu.tbadk.performanceLog.ab.Ha().aa(System.currentTimeMillis());
                com.baidu.tieba.a.a.Mw().MB();
            }
        }
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        aVar = this.aKF.aKy;
        hx.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h hx2 = com.baidu.adp.lib.h.h.hx();
        aVar2 = this.aKF.aKy;
        hx2.postDelayed(aVar2, 1500L);
    }
}
