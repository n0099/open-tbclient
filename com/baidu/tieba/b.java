package com.baidu.tieba;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.tieba.LogoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ LogoActivity aDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LogoActivity logoActivity) {
        this.aDl = logoActivity;
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
        imageView = this.aDl.aDf;
        bitmap = this.aDl.mBitmap;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.aDl.aDf;
        imageView2.setOnClickListener(new c(this));
        aVar = this.aDl.Lt;
        if (aVar != null) {
            aVar2 = this.aDl.Lt;
            if (!aVar2.isShowing()) {
                com.baidu.adp.lib.g.h hg = com.baidu.adp.lib.g.h.hg();
                aVar3 = this.aDl.aDj;
                hg.postDelayed(aVar3, 3000L);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h hg2 = com.baidu.adp.lib.g.h.hg();
        aVar4 = this.aDl.aDj;
        hg2.postDelayed(aVar4, 3000L);
    }
}
