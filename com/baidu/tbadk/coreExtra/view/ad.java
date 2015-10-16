package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z amj;
    private final /* synthetic */ boolean aml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, boolean z) {
        this.amj = zVar;
        this.aml = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean z2;
        this.amj.aS(this.aml);
        z = this.amj.amb;
        if (!z) {
            if (aVar != null) {
                Bitmap na = aVar.na();
                if (na != null) {
                    this.amj.ama = true;
                    if (!aVar.fF()) {
                        z2 = this.amj.amf;
                        if (z2) {
                            this.amj.alX.setVisibility(0);
                        }
                        this.amj.alW.setImageBitmap(na);
                        this.amj.alW.setImageData(aVar.nf());
                        return;
                    }
                    byte[] nf = aVar.nf();
                    if (nf == null) {
                        nf = com.baidu.tbadk.core.util.c.e(na, 100);
                    }
                    this.amj.alW.a(nf, na);
                } else if (!this.aml) {
                    this.amj.alW.setDefaultBitmap();
                }
            } else if (!this.aml) {
                this.amj.alW.setDefaultBitmap();
            }
        }
    }
}
