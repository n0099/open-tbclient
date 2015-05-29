package com.baidu.tieba;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ LogoActivity avg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LogoActivity logoActivity) {
        this.avg = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        h hVar;
        h hVar2;
        imageView = this.avg.avb;
        bitmap = this.avg.mBitmap;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.avg.avb;
        imageView2.setOnClickListener(new c(this));
        aVar = this.avg.Ll;
        if (aVar != null) {
            aVar2 = this.avg.Ll;
            if (!aVar2.isShowing()) {
                com.baidu.adp.lib.g.i hs = com.baidu.adp.lib.g.i.hs();
                hVar = this.avg.ave;
                hs.postDelayed(hVar, 3000L);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.i hs2 = com.baidu.adp.lib.g.i.hs();
        hVar2 = this.avg.ave;
        hs2.postDelayed(hVar2, 3000L);
    }
}
