package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ au Pk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.Pk = auVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void aa(String str) {
        this.Pk.Pi.setVisibility(0);
        this.Pk.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        aw awVar;
        aw awVar2;
        this.Pk.mProgressBar.setVisibility(8);
        if (aVar != null) {
            awVar = this.Pk.Pj;
            if (awVar != null) {
                awVar2 = this.Pk.Pj;
                awVar2.g(aVar.getUrl(), aVar.hq());
            }
            Bitmap hl = aVar.hl();
            if (hl == null) {
                this.Pk.Pi.vl();
            } else if (aVar.bM()) {
                this.Pk.Pi.a(aVar.hq(), hl);
            } else {
                this.Pk.Pi.setImageBitmap(hl);
                this.Pk.Pi.setImageData(aVar.hq());
            }
        }
    }
}
