package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ au Po;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.Po = auVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void aa(String str) {
        this.Po.Pm.setVisibility(0);
        this.Po.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        aw awVar;
        aw awVar2;
        this.Po.mProgressBar.setVisibility(8);
        if (aVar != null) {
            awVar = this.Po.Pn;
            if (awVar != null) {
                awVar2 = this.Po.Pn;
                awVar2.g(aVar.getUrl(), aVar.hq());
            }
            Bitmap hl = aVar.hl();
            if (hl == null) {
                this.Po.Pm.vn();
            } else if (aVar.bM()) {
                this.Po.Pm.a(aVar.hq(), hl);
            } else {
                this.Po.Pm.setImageBitmap(hl);
                this.Po.Pm.setImageData(aVar.hq());
            }
        }
    }
}
