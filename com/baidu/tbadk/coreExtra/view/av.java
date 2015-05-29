package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ au agQ;
    private final /* synthetic */ boolean agR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, boolean z) {
        this.agQ = auVar;
        this.agR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.agQ.aN(this.agR);
        z = this.agQ.agO;
        if (!z) {
            if (aVar != null) {
                Bitmap mS = aVar.mS();
                if (mS != null) {
                    this.agQ.agN = true;
                    if (aVar.fN()) {
                        byte[] mX = aVar.mX();
                        if (mX == null) {
                            mX = com.baidu.tbadk.core.util.c.e(mS, 100);
                        }
                        this.agQ.agL.a(mX, mS);
                        return;
                    }
                    this.agQ.agL.setImageBitmap(mS);
                    this.agQ.agL.setImageData(aVar.mX());
                } else if (!this.agR) {
                    this.agQ.agL.setDefaultBitmap();
                }
            } else if (!this.agR) {
                this.agQ.agL.setDefaultBitmap();
            }
        }
    }
}
