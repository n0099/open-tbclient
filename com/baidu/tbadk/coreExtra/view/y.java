package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqO;
    private final /* synthetic */ boolean aqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.aqO = uVar;
        this.aqQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.aqO.be(this.aqQ);
        z = this.aqO.aqE;
        if (!z) {
            if (aVar != null) {
                Bitmap mK = aVar.mK();
                if (mK != null) {
                    this.aqO.aqD = true;
                    if (aVar.fO()) {
                        byte[] mP = aVar.mP();
                        if (mP == null) {
                            mP = BitmapHelper.Bitmap2Bytes(mK, 100);
                        }
                        this.aqO.aqy.a(mP, mK);
                        this.aqO.aqy.invalidate();
                        this.aqO.aqy.play();
                        this.aqO.aqJ = false;
                    } else {
                        this.aqO.aqy.setImageBitmap(mK);
                        this.aqO.aqy.setImageData(aVar.mP());
                    }
                    this.aqO.BR();
                } else if (!this.aqQ) {
                    this.aqO.aqy.setDefaultBitmap();
                }
            } else if (!this.aqQ) {
                this.aqO.aqy.setDefaultBitmap();
            }
        }
    }
}
