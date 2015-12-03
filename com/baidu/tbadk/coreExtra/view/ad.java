package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z aob;
    private final /* synthetic */ boolean aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, boolean z) {
        this.aob = zVar;
        this.aod = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean z2;
        this.aob.aX(this.aod);
        z = this.aob.anT;
        if (!z) {
            if (aVar != null) {
                Bitmap ng = aVar.ng();
                if (ng != null) {
                    this.aob.anS = true;
                    if (!aVar.fF()) {
                        z2 = this.aob.anX;
                        if (z2) {
                            this.aob.anP.setVisibility(0);
                        }
                        this.aob.anO.setImageBitmap(ng);
                        this.aob.anO.setImageData(aVar.nl());
                        return;
                    }
                    byte[] nl = aVar.nl();
                    if (nl == null) {
                        nl = com.baidu.tbadk.core.util.c.e(ng, 100);
                    }
                    this.aob.anO.a(nl, ng);
                } else if (!this.aod) {
                    this.aob.anO.setDefaultBitmap();
                }
            } else if (!this.aod) {
                this.aob.anO.setDefaultBitmap();
            }
        }
    }
}
