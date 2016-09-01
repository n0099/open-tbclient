package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aLA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aLA = logoActivity;
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
        relativeLayout = this.aLA.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aLA.aLp;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aLA;
                bitmap2 = this.aLA.aLp;
                logoActivity.aLl = bitmap2;
                bitmap3 = this.aLA.aLl;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new ay("c10859"));
                    this.aLA.aLq = true;
                    bitmap4 = this.aLA.aLl;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aLA.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aLA.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aLA.mRootView;
                    relativeLayout4.setFocusable(true);
                    relativeLayout5 = this.aLA.mRootView;
                    relativeLayout5.setOnClickListener(new d(this));
                }
                com.baidu.tbadk.performanceLog.ab.Gv().ad(System.currentTimeMillis());
                com.baidu.tieba.d.a.OI().ON();
            }
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        aVar = this.aLA.aLt;
        eG.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        aVar2 = this.aLA.aLt;
        eG2.postDelayed(aVar2, 1500L);
    }
}
