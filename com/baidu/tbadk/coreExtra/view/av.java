package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ at afH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.afH = atVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        this.afH.afC.setVisibility(0);
        this.afH.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        aw awVar;
        boolean z;
        aw awVar2;
        this.afH.afF = true;
        this.afH.mProgressBar.setVisibility(8);
        if (aVar != null) {
            awVar = this.afH.afD;
            if (awVar != null) {
                awVar2 = this.afH.afD;
                awVar2.i(aVar.getUrl(), aVar.mE());
            }
            Bitmap mz = aVar.mz();
            if (mz == null) {
                z = this.afH.afE;
                if (!z) {
                    this.afH.afC.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fI()) {
                this.afH.afC.a(aVar.mE(), mz);
            } else {
                this.afH.afC.setImageBitmap(mz);
                this.afH.afC.setImageData(aVar.mE());
            }
            this.afH.afC.setLoadBigImage(true);
        }
    }
}
