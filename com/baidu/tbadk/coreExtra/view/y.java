package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u amC;
    private final /* synthetic */ boolean amE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.amC = uVar;
        this.amE = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.amC.bl(this.amE);
        z = this.amC.ams;
        if (!z) {
            if (aVar != null) {
                Bitmap iY = aVar.iY();
                if (iY != null) {
                    this.amC.amr = true;
                    if (aVar.cd()) {
                        byte[] jd = aVar.jd();
                        if (jd == null) {
                            jd = BitmapHelper.Bitmap2Bytes(iY, 100);
                        }
                        this.amC.amm.a(jd, iY);
                        this.amC.amm.invalidate();
                        this.amC.amm.play();
                        this.amC.amx = false;
                    } else {
                        this.amC.amm.setImageBitmap(iY);
                        this.amC.amm.setImageData(aVar.jd());
                    }
                    this.amC.zL();
                } else if (!this.amE) {
                    this.amC.amm.FT();
                }
            } else if (!this.amE) {
                this.amC.amm.FT();
            }
        }
    }
}
