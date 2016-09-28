package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqO;
    private final /* synthetic */ boolean aqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, boolean z) {
        this.aqO = uVar;
        this.aqR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.aqO.bm(this.aqR);
        z = this.aqO.aqE;
        if (!z) {
            if (aVar != null) {
                Bitmap jV = aVar.jV();
                if (jV != null) {
                    this.aqO.aqD = true;
                    if (aVar.cY()) {
                        byte[] ka = aVar.ka();
                        if (ka == null) {
                            ka = BitmapHelper.Bitmap2Bytes(jV, 100);
                        }
                        this.aqO.aqx.a(ka, jV);
                        this.aqO.aqx.invalidate();
                        this.aqO.aqx.play();
                        this.aqO.aqJ = false;
                    } else {
                        this.aqO.aqx.setImageBitmap(jV);
                        this.aqO.aqx.setImageData(aVar.ka());
                    }
                    this.aqO.Bj();
                    this.aqO.Bl();
                } else if (!this.aqR) {
                    this.aqO.aqx.Hs();
                }
            } else if (!this.aqR) {
                this.aqO.aqx.Hs();
            }
        }
    }
}
