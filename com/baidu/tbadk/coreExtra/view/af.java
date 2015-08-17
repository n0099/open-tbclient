package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ae alW;
    private final /* synthetic */ boolean alX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, boolean z) {
        this.alW = aeVar;
        this.alX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.alW.aR(this.alX);
        z = this.alW.alU;
        if (!z) {
            if (aVar != null) {
                Bitmap nc = aVar.nc();
                if (nc != null) {
                    this.alW.alT = true;
                    if (aVar.fI()) {
                        byte[] nh = aVar.nh();
                        if (nh == null) {
                            nh = com.baidu.tbadk.core.util.c.e(nc, 100);
                        }
                        this.alW.alR.a(nh, nc);
                        return;
                    }
                    this.alW.alR.setImageBitmap(nc);
                    this.alW.alR.setImageData(aVar.nh());
                } else if (!this.alX) {
                    this.alW.alR.setDefaultBitmap();
                }
            } else if (!this.alX) {
                this.alW.alR.setDefaultBitmap();
            }
        }
    }
}
