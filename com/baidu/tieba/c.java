package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ LogoActivity aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LogoActivity logoActivity) {
        this.aGQ = logoActivity;
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
        relativeLayout = this.aGQ.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aGQ.aGF;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aGQ;
                bitmap2 = this.aGQ.aGF;
                logoActivity.aGB = bitmap2;
                bitmap3 = this.aGQ.aGB;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new aw("c10859"));
                    this.aGQ.aGG = true;
                    bitmap4 = this.aGQ.aGB;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aGQ.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aGQ.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aGQ.mRootView;
                    relativeLayout4.setFocusable(true);
                    relativeLayout5 = this.aGQ.mRootView;
                    relativeLayout5.setOnClickListener(new d(this));
                }
                com.baidu.tbadk.performanceLog.ab.ET().ab(System.currentTimeMillis());
                com.baidu.tieba.b.a.Lh().Lm();
            }
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        aVar = this.aGQ.aGJ;
        dL.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        aVar2 = this.aGQ.aGJ;
        dL2.postDelayed(aVar2, 1500L);
    }
}
