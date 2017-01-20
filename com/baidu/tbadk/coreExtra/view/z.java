package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqr;
    private final /* synthetic */ boolean aqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.aqr = uVar;
        this.aqu = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.aqr.bq(this.aqu);
        z = this.aqr.aqh;
        if (!z) {
            if (aVar != null) {
                Bitmap jT = aVar.jT();
                if (jT != null) {
                    this.aqr.aqg = true;
                    if (aVar.cW()) {
                        byte[] jY = aVar.jY();
                        if (jY == null) {
                            jY = BitmapHelper.Bitmap2Bytes(jT, 100);
                        }
                        this.aqr.aqa.a(jY, jT);
                        this.aqr.aqa.invalidate();
                        this.aqr.aqa.play();
                        this.aqr.aqm = false;
                    } else {
                        this.aqr.aqa.setImageBitmap(jT);
                        this.aqr.aqa.setImageData(aVar.jY());
                    }
                    this.aqr.AY();
                    this.aqr.Ba();
                } else if (!this.aqu) {
                    this.aqr.aqa.GJ();
                }
            } else if (!this.aqu) {
                this.aqr.aqa.GJ();
            }
        }
    }
}
