package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ LogoActivity aIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LogoActivity logoActivity) {
        this.aIj = logoActivity;
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
        relativeLayout = this.aIj.mRootView;
        if (relativeLayout != null) {
            bitmap = this.aIj.aHY;
            if (bitmap != null) {
                LogoActivity logoActivity = this.aIj;
                bitmap2 = this.aIj.aHY;
                logoActivity.aHU = bitmap2;
                bitmap3 = this.aIj.aHU;
                if (bitmap3 != null) {
                    com.baidu.tbadk.core.util.TiebaStatic.log(new ay("c10859"));
                    this.aIj.aHZ = true;
                    bitmap4 = this.aIj.aHU;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap4);
                    relativeLayout2 = this.aIj.mRootView;
                    relativeLayout2.removeAllViews();
                    relativeLayout3 = this.aIj.mRootView;
                    relativeLayout3.setBackgroundDrawable(bitmapDrawable);
                    relativeLayout4 = this.aIj.mRootView;
                    relativeLayout4.setFocusable(true);
                    relativeLayout5 = this.aIj.mRootView;
                    relativeLayout5.setOnClickListener(new e(this));
                }
                com.baidu.tbadk.performanceLog.ab.Fb().Z(System.currentTimeMillis());
                com.baidu.tieba.c.a.Md().Mi();
            }
        }
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        aVar = this.aIj.aIc;
        dL.removeCallbacks(aVar);
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        aVar2 = this.aIj.aIc;
        dL2.postDelayed(aVar2, 1500L);
    }
}
