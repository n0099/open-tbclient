package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u arl;
    private final /* synthetic */ boolean aro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.arl = uVar;
        this.aro = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.arl.bq(this.aro);
        z = this.arl.arb;
        if (!z) {
            if (aVar != null) {
                Bitmap jV = aVar.jV();
                if (jV != null) {
                    this.arl.ara = true;
                    if (aVar.cY()) {
                        byte[] ka = aVar.ka();
                        if (ka == null) {
                            ka = BitmapHelper.Bitmap2Bytes(jV, 100);
                        }
                        this.arl.aqU.a(ka, jV);
                        this.arl.aqU.invalidate();
                        this.arl.aqU.play();
                        this.arl.arg = false;
                    } else {
                        this.arl.aqU.setImageBitmap(jV);
                        this.arl.aqU.setImageData(aVar.ka());
                    }
                    this.arl.Bd();
                    this.arl.Bf();
                } else if (!this.aro) {
                    this.arl.aqU.GR();
                }
            } else if (!this.aro) {
                this.arl.aqU.GR();
            }
        }
    }
}
