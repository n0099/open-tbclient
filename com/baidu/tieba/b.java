package com.baidu.tieba;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.tieba.LogoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ LogoActivity aEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LogoActivity logoActivity) {
        this.aEg = logoActivity;
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
        imageView = this.aEg.aEa;
        bitmap = this.aEg.mBitmap;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.aEg.aEa;
        imageView2.setOnClickListener(new c(this));
        aVar = this.aEg.Lt;
        if (aVar != null) {
            aVar2 = this.aEg.Lt;
            if (!aVar2.isShowing()) {
                com.baidu.adp.lib.g.h hf = com.baidu.adp.lib.g.h.hf();
                aVar3 = this.aEg.aEe;
                hf.postDelayed(aVar3, 3000L);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h hf2 = com.baidu.adp.lib.g.h.hf();
        aVar4 = this.aEg.aEe;
        hf2.postDelayed(aVar4, 3000L);
    }
}
