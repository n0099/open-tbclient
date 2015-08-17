package com.baidu.tieba;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.tieba.LogoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ LogoActivity aCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LogoActivity logoActivity) {
        this.aCy = logoActivity;
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
        imageView = this.aCy.aCs;
        bitmap = this.aCy.mBitmap;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.aCy.aCs;
        imageView2.setOnClickListener(new c(this));
        aVar = this.aCy.Lt;
        if (aVar != null) {
            aVar2 = this.aCy.Lt;
            if (!aVar2.isShowing()) {
                com.baidu.adp.lib.g.h hi = com.baidu.adp.lib.g.h.hi();
                aVar3 = this.aCy.aCw;
                hi.postDelayed(aVar3, 3000L);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h hi2 = com.baidu.adp.lib.g.h.hi();
        aVar4 = this.aCy.aCw;
        hi2.postDelayed(aVar4, 3000L);
    }
}
