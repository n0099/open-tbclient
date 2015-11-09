package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z amo;
    private final /* synthetic */ boolean amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, boolean z) {
        this.amo = zVar;
        this.amq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean z2;
        this.amo.aS(this.amq);
        z = this.amo.amg;
        if (!z) {
            if (aVar != null) {
                Bitmap nb = aVar.nb();
                if (nb != null) {
                    this.amo.amf = true;
                    if (!aVar.fF()) {
                        z2 = this.amo.amk;
                        if (z2) {
                            this.amo.amc.setVisibility(0);
                        }
                        this.amo.amb.setImageBitmap(nb);
                        this.amo.amb.setImageData(aVar.ng());
                        return;
                    }
                    byte[] ng = aVar.ng();
                    if (ng == null) {
                        ng = com.baidu.tbadk.core.util.c.e(nb, 100);
                    }
                    this.amo.amb.a(ng, nb);
                } else if (!this.amq) {
                    this.amo.amb.setDefaultBitmap();
                }
            } else if (!this.amq) {
                this.amo.amb.setDefaultBitmap();
            }
        }
    }
}
