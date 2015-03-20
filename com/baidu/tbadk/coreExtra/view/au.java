package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ at afH;
    private final /* synthetic */ boolean afI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, boolean z) {
        this.afH = atVar;
        this.afI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.afH.aG(this.afI);
        z = this.afH.afF;
        if (!z) {
            if (aVar != null) {
                Bitmap mz = aVar.mz();
                if (mz != null) {
                    this.afH.afE = true;
                    if (aVar.fI()) {
                        byte[] mE = aVar.mE();
                        if (mE == null) {
                            mE = com.baidu.tbadk.core.util.c.e(mz, 100);
                        }
                        this.afH.afC.a(mE, mz);
                        return;
                    }
                    this.afH.afC.setImageBitmap(mz);
                    this.afH.afC.setImageData(aVar.mE());
                } else if (!this.afI) {
                    this.afH.afC.setDefaultBitmap();
                }
            } else if (!this.afI) {
                this.afH.afC.setDefaultBitmap();
            }
        }
    }
}
