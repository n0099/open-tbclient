package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ab anI;
    private final /* synthetic */ boolean anJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, boolean z) {
        this.anI = abVar;
        this.anJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.anI.aY(this.anJ);
        z = this.anI.anG;
        if (!z) {
            if (aVar != null) {
                Bitmap mZ = aVar.mZ();
                if (mZ != null) {
                    this.anI.anF = true;
                    if (aVar.fF()) {
                        byte[] ne = aVar.ne();
                        if (ne == null) {
                            ne = com.baidu.tbadk.core.util.c.e(mZ, 100);
                        }
                        this.anI.anD.a(ne, mZ);
                        return;
                    }
                    this.anI.anD.setImageBitmap(mZ);
                    this.anI.anD.setImageData(aVar.ne());
                } else if (!this.anJ) {
                    this.anI.anD.setDefaultBitmap();
                }
            } else if (!this.anJ) {
                this.anI.anD.setDefaultBitmap();
            }
        }
    }
}
