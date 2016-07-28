package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u anX;
    private final /* synthetic */ boolean anZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.anX = uVar;
        this.anZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.anX.bl(this.anZ);
        z = this.anX.anN;
        if (!z) {
            if (aVar != null) {
                Bitmap ja = aVar.ja();
                if (ja != null) {
                    this.anX.anM = true;
                    if (aVar.cd()) {
                        byte[] jf = aVar.jf();
                        if (jf == null) {
                            jf = BitmapHelper.Bitmap2Bytes(ja, 100);
                        }
                        this.anX.anH.a(jf, ja);
                        this.anX.anH.invalidate();
                        this.anX.anH.play();
                        this.anX.anS = false;
                    } else {
                        this.anX.anH.setImageBitmap(ja);
                        this.anX.anH.setImageData(aVar.jf());
                    }
                    this.anX.zR();
                } else if (!this.anZ) {
                    this.anX.anH.FZ();
                }
            } else if (!this.anZ) {
                this.anX.anH.FZ();
            }
        }
    }
}
