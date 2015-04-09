package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ at afP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.afP = atVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        this.afP.afK.setVisibility(0);
        this.afP.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        aw awVar;
        boolean z;
        aw awVar2;
        this.afP.afN = true;
        this.afP.mProgressBar.setVisibility(8);
        if (aVar != null) {
            awVar = this.afP.afL;
            if (awVar != null) {
                awVar2 = this.afP.afL;
                awVar2.i(aVar.getUrl(), aVar.mE());
            }
            Bitmap mz = aVar.mz();
            if (mz == null) {
                z = this.afP.afM;
                if (!z) {
                    this.afP.afK.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fI()) {
                this.afP.afK.a(aVar.mE(), mz);
            } else {
                this.afP.afK.setImageBitmap(mz);
                this.afP.afK.setImageData(aVar.mE());
            }
            this.afP.afK.setLoadBigImage(true);
        }
    }
}
