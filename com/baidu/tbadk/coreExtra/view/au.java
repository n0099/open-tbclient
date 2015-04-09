package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ at afP;
    private final /* synthetic */ boolean afQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, boolean z) {
        this.afP = atVar;
        this.afQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.afP.aG(this.afQ);
        z = this.afP.afN;
        if (!z) {
            if (aVar != null) {
                Bitmap mz = aVar.mz();
                if (mz != null) {
                    this.afP.afM = true;
                    if (aVar.fI()) {
                        byte[] mE = aVar.mE();
                        if (mE == null) {
                            mE = com.baidu.tbadk.core.util.c.e(mz, 100);
                        }
                        this.afP.afK.a(mE, mz);
                        return;
                    }
                    this.afP.afK.setImageBitmap(mz);
                    this.afP.afK.setImageData(aVar.mE());
                } else if (!this.afQ) {
                    this.afP.afK.setDefaultBitmap();
                }
            } else if (!this.afQ) {
                this.afP.afK.setDefaultBitmap();
            }
        }
    }
}
