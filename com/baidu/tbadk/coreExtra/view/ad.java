package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z apF;
    private final /* synthetic */ boolean apH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, boolean z) {
        this.apF = zVar;
        this.apH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.apF.aW(this.apH);
        z = this.apF.apv;
        if (!z) {
            if (aVar != null) {
                Bitmap mE = aVar.mE();
                if (mE != null) {
                    this.apF.apu = true;
                    if (aVar.fF()) {
                        byte[] mJ = aVar.mJ();
                        if (mJ == null) {
                            mJ = com.baidu.tbadk.core.util.c.e(mE, 100);
                        }
                        this.apF.apo.a(mJ, mE);
                        this.apF.apo.invalidate();
                        this.apF.apo.play();
                        this.apF.apA = false;
                    } else {
                        this.apF.apo.setImageBitmap(mE);
                        this.apF.apo.setImageData(aVar.mJ());
                    }
                    this.apF.zY();
                } else if (!this.apH) {
                    this.apF.apo.setDefaultBitmap();
                }
            } else if (!this.apH) {
                this.apF.apo.setDefaultBitmap();
            }
        }
    }
}
