package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z ami;
    private final /* synthetic */ boolean amk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, boolean z) {
        this.ami = zVar;
        this.amk = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean z2;
        this.ami.aS(this.amk);
        z = this.ami.ama;
        if (!z) {
            if (aVar != null) {
                Bitmap na = aVar.na();
                if (na != null) {
                    this.ami.alZ = true;
                    if (!aVar.fF()) {
                        z2 = this.ami.ame;
                        if (z2) {
                            this.ami.alW.setVisibility(0);
                        }
                        this.ami.alV.setImageBitmap(na);
                        this.ami.alV.setImageData(aVar.nf());
                        return;
                    }
                    byte[] nf = aVar.nf();
                    if (nf == null) {
                        nf = com.baidu.tbadk.core.util.c.e(na, 100);
                    }
                    this.ami.alV.a(nf, na);
                } else if (!this.amk) {
                    this.ami.alV.setDefaultBitmap();
                }
            } else if (!this.amk) {
                this.ami.alV.setDefaultBitmap();
            }
        }
    }
}
