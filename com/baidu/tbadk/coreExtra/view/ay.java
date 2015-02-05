package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ax VC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.VC = axVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        this.VC.VA.setVisibility(0);
        this.VC.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        az azVar;
        az azVar2;
        this.VC.mProgressBar.setVisibility(8);
        if (aVar != null) {
            azVar = this.VC.VB;
            if (azVar != null) {
                azVar2 = this.VC.VB;
                azVar2.i(aVar.getUrl(), aVar.jh());
            }
            Bitmap jc = aVar.jc();
            if (jc == null) {
                this.VC.VA.setDefaultBitmap();
            } else if (aVar.ck()) {
                this.VC.VA.a(aVar.jh(), jc);
            } else {
                this.VC.VA.setImageBitmap(jc);
                this.VC.VA.setImageData(aVar.jh());
            }
        }
    }
}
