package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u awc;
    private final /* synthetic */ boolean awf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.awc = uVar;
        this.awf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.awc.br(this.awf);
        z = this.awc.avS;
        if (!z) {
            if (aVar != null) {
                Bitmap kR = aVar.kR();
                if (kR != null) {
                    this.awc.avR = true;
                    if (aVar.ee()) {
                        byte[] kW = aVar.kW();
                        if (kW == null) {
                            kW = BitmapHelper.Bitmap2Bytes(kR, 100);
                        }
                        this.awc.avL.a(kW, kR);
                        this.awc.avL.invalidate();
                        this.awc.avL.play();
                        this.awc.avX = false;
                    } else {
                        this.awc.avL.setImageBitmap(kR);
                        this.awc.avL.setImageData(aVar.kW());
                    }
                    this.awc.BP();
                    this.awc.BR();
                } else if (!this.awf) {
                    this.awc.avL.HH();
                }
            } else if (!this.awf) {
                this.awc.avL.HH();
            }
        }
    }
}
