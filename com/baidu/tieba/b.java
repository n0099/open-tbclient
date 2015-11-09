package com.baidu.tieba;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.tbadk.performanceLog.z;
import com.baidu.tieba.LogoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ LogoActivity aCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LogoActivity logoActivity) {
        this.aCq = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        LogoActivity.a aVar3;
        LogoActivity.a aVar4;
        z.DX().L(System.currentTimeMillis());
        imageView = this.aCq.aCk;
        bitmap = this.aCq.mBitmap;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.aCq.aCk;
        imageView2.setOnClickListener(new c(this));
        aVar = this.aCq.Lv;
        if (aVar != null) {
            aVar2 = this.aCq.Lv;
            if (!aVar2.isShowing()) {
                com.baidu.adp.lib.g.h hh = com.baidu.adp.lib.g.h.hh();
                aVar3 = this.aCq.aCo;
                hh.postDelayed(aVar3, 3000L);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h hh2 = com.baidu.adp.lib.g.h.hh();
        aVar4 = this.aCq.aCo;
        hh2.postDelayed(aVar4, 3000L);
    }
}
