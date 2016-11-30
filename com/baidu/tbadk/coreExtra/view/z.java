package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u arI;
    private final /* synthetic */ boolean arL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.arI = uVar;
        this.arL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.arI.bq(this.arL);
        z = this.arI.ary;
        if (!z) {
            if (aVar != null) {
                Bitmap jV = aVar.jV();
                if (jV != null) {
                    this.arI.arx = true;
                    if (aVar.cY()) {
                        byte[] ka = aVar.ka();
                        if (ka == null) {
                            ka = BitmapHelper.Bitmap2Bytes(jV, 100);
                        }
                        this.arI.arr.a(ka, jV);
                        this.arI.arr.invalidate();
                        this.arI.arr.play();
                        this.arI.arD = false;
                    } else {
                        this.arI.arr.setImageBitmap(jV);
                        this.arI.arr.setImageData(aVar.ka());
                    }
                    this.arI.Bq();
                    this.arI.Bs();
                } else if (!this.arL) {
                    this.arI.arr.Hv();
                }
            } else if (!this.arL) {
                this.arI.arr.Hv();
            }
        }
    }
}
