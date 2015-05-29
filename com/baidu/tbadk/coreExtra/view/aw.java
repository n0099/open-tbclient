package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ au agQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.agQ = auVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void am(String str) {
        this.agQ.agL.setVisibility(0);
        this.agQ.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ax axVar;
        boolean z;
        ax axVar2;
        this.agQ.agO = true;
        this.agQ.mProgressBar.setVisibility(8);
        if (aVar != null) {
            axVar = this.agQ.agM;
            if (axVar != null) {
                axVar2 = this.agQ.agM;
                axVar2.i(aVar.getUrl(), aVar.mX());
            }
            Bitmap mS = aVar.mS();
            if (mS == null) {
                z = this.agQ.agN;
                if (!z) {
                    this.agQ.agL.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fN()) {
                this.agQ.agL.a(aVar.mX(), mS);
            } else {
                this.agQ.agL.setImageBitmap(mS);
                this.agQ.agL.setImageData(aVar.mX());
            }
            this.agQ.agL.setLoadBigImage(true);
        }
    }
}
