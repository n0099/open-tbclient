package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ax VF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.VF = axVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        this.VF.VD.setVisibility(0);
        this.VF.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        az azVar;
        az azVar2;
        this.VF.mProgressBar.setVisibility(8);
        if (aVar != null) {
            azVar = this.VF.VE;
            if (azVar != null) {
                azVar2 = this.VF.VE;
                azVar2.i(aVar.getUrl(), aVar.jo());
            }
            Bitmap jj = aVar.jj();
            if (jj == null) {
                this.VF.VD.setDefaultBitmap();
            } else if (aVar.ck()) {
                this.VF.VD.a(aVar.jo(), jj);
            } else {
                this.VF.VD.setImageBitmap(jj);
                this.VF.VD.setImageData(aVar.jo());
            }
        }
    }
}
