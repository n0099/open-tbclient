package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u awe;
    private final /* synthetic */ boolean awh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.awe = uVar;
        this.awh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.awe.br(this.awh);
        z = this.awe.avU;
        if (!z) {
            if (aVar != null) {
                Bitmap kS = aVar.kS();
                if (kS != null) {
                    this.awe.avT = true;
                    if (aVar.ef()) {
                        byte[] kX = aVar.kX();
                        if (kX == null) {
                            kX = BitmapHelper.Bitmap2Bytes(kS, 100);
                        }
                        this.awe.avN.a(kX, kS);
                        this.awe.avN.invalidate();
                        this.awe.avN.play();
                        this.awe.avZ = false;
                    } else {
                        this.awe.avN.setImageBitmap(kS);
                        this.awe.avN.setImageData(aVar.kX());
                    }
                    this.awe.BP();
                    this.awe.BR();
                } else if (!this.awh) {
                    this.awe.avN.HH();
                }
            } else if (!this.awh) {
                this.awe.avN.HH();
            }
        }
    }
}
