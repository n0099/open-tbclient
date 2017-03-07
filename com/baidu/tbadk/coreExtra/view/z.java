package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u avM;
    private final /* synthetic */ boolean avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.avM = uVar;
        this.avP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.avM.bp(this.avP);
        z = this.avM.avC;
        if (!z) {
            if (aVar != null) {
                Bitmap kN = aVar.kN();
                if (kN != null) {
                    this.avM.avB = true;
                    if (aVar.ef()) {
                        byte[] kS = aVar.kS();
                        if (kS == null) {
                            kS = BitmapHelper.Bitmap2Bytes(kN, 100);
                        }
                        this.avM.avv.a(kS, kN);
                        this.avM.avv.invalidate();
                        this.avM.avv.play();
                        this.avM.avH = false;
                    } else {
                        this.avM.avv.setImageBitmap(kN);
                        this.avM.avv.setImageData(aVar.kS());
                    }
                    this.avM.Br();
                    this.avM.Bt();
                } else if (!this.avP) {
                    this.avM.avv.Hi();
                }
            } else if (!this.avP) {
                this.avM.avv.Hi();
            }
        }
    }
}
