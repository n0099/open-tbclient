package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u awi;
    private final /* synthetic */ boolean awl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.awi = uVar;
        this.awl = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.awi.br(this.awl);
        z = this.awi.avY;
        if (!z) {
            if (aVar != null) {
                Bitmap kR = aVar.kR();
                if (kR != null) {
                    this.awi.avX = true;
                    if (aVar.ef()) {
                        byte[] kW = aVar.kW();
                        if (kW == null) {
                            kW = BitmapHelper.Bitmap2Bytes(kR, 100);
                        }
                        this.awi.avR.a(kW, kR);
                        this.awi.avR.invalidate();
                        this.awi.avR.play();
                        this.awi.awd = false;
                    } else {
                        this.awi.avR.setImageBitmap(kR);
                        this.awi.avR.setImageData(aVar.kW());
                    }
                    this.awi.Ba();
                    this.awi.Bc();
                } else if (!this.awl) {
                    this.awi.avR.GS();
                }
            } else if (!this.awl) {
                this.awi.avR.GS();
            }
        }
    }
}
