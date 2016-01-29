package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqx;
    private final /* synthetic */ boolean aqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.aqx = uVar;
        this.aqz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.aqx.aY(this.aqz);
        z = this.aqx.aqn;
        if (!z) {
            if (aVar != null) {
                Bitmap mS = aVar.mS();
                if (mS != null) {
                    this.aqx.aqm = true;
                    if (aVar.fN()) {
                        byte[] mX = aVar.mX();
                        if (mX == null) {
                            mX = BitmapHelper.Bitmap2Bytes(mS, 100);
                        }
                        this.aqx.aqh.a(mX, mS);
                        this.aqx.aqh.invalidate();
                        this.aqx.aqh.play();
                        this.aqx.aqs = false;
                    } else {
                        this.aqx.aqh.setImageBitmap(mS);
                        this.aqx.aqh.setImageData(aVar.mX());
                    }
                    this.aqx.Bo();
                } else if (!this.aqz) {
                    this.aqx.aqh.setDefaultBitmap();
                }
            } else if (!this.aqz) {
                this.aqx.aqh.setDefaultBitmap();
            }
        }
    }
}
