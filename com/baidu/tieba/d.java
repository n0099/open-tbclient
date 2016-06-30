package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LogoActivity logoActivity) {
        this.aHs = logoActivity;
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
        RelativeLayout relativeLayout5;
        relativeLayout = this.aHs.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aHs.aHh;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aHs;
                bitmap2 = this.aHs.aHh;
                logoActivity.aHd = bitmap2;
                bitmap3 = this.aHs.aHd;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new ay("c10859"));
                    this.aHs.aHi = true;
                    bitmap4 = this.aHs.aHd;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aHs.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aHs.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aHs.mRootView;
                    relativeLayout4.setFocusable(true);
                    relativeLayout5 = this.aHs.mRootView;
                    relativeLayout5.setOnClickListener(new e(this));
                }
                com.baidu.tbadk.performanceLog.ab.Fc().ae(System.currentTimeMillis());
                com.baidu.tieba.c.a.Me().Mj();
            }
        }
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        aVar = this.aHs.aHl;
        dM.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dM2 = com.baidu.adp.lib.h.h.dM();
        aVar2 = this.aHs.aHl;
        dM2.postDelayed(aVar2, 1500L);
    }
}
