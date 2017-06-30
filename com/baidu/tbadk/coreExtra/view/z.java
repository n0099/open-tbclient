package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u awV;
    private final /* synthetic */ boolean awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.awV = uVar;
        this.awY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.awV.bp(this.awY);
        z = this.awV.awL;
        if (!z) {
            if (aVar != null) {
                Bitmap kP = aVar.kP();
                if (kP != null) {
                    this.awV.awK = true;
                    if (aVar.isGif()) {
                        byte[] kU = aVar.kU();
                        if (kU == null) {
                            kU = BitmapHelper.Bitmap2Bytes(kP, 100);
                        }
                        this.awV.awE.a(kU, kP);
                        this.awV.awE.invalidate();
                        this.awV.awE.play();
                        this.awV.awQ = false;
                    } else {
                        this.awV.awE.setImageBitmap(kP);
                        this.awV.awE.setImageData(aVar.kU());
                    }
                    this.awV.Bo();
                    this.awV.Bq();
                } else if (!this.awY) {
                    this.awV.awE.Hj();
                }
            } else if (!this.awY) {
                this.awV.awE.Hj();
            }
        }
    }
}
