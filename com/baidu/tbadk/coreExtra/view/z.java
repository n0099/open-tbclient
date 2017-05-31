package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u avS;
    private final /* synthetic */ boolean avV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.avS = uVar;
        this.avV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.avS.bo(this.avV);
        z = this.avS.avI;
        if (!z) {
            if (aVar != null) {
                Bitmap kR = aVar.kR();
                if (kR != null) {
                    this.avS.avH = true;
                    if (aVar.ef()) {
                        byte[] kW = aVar.kW();
                        if (kW == null) {
                            kW = BitmapHelper.Bitmap2Bytes(kR, 100);
                        }
                        this.avS.avB.a(kW, kR);
                        this.avS.avB.invalidate();
                        this.avS.avB.play();
                        this.avS.avN = false;
                    } else {
                        this.avS.avB.setImageBitmap(kR);
                        this.avS.avB.setImageData(aVar.kW());
                    }
                    this.avS.AT();
                    this.avS.AV();
                } else if (!this.avV) {
                    this.avS.avB.GM();
                }
            } else if (!this.avV) {
                this.avS.avB.GM();
            }
        }
    }
}
