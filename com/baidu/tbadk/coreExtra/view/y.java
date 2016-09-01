package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u are;
    private final /* synthetic */ boolean arg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.are = uVar;
        this.arg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.are.bn(this.arg);
        z = this.are.aqU;
        if (!z) {
            if (aVar != null) {
                Bitmap jV = aVar.jV();
                if (jV != null) {
                    this.are.aqT = true;
                    if (aVar.cY()) {
                        byte[] ka = aVar.ka();
                        if (ka == null) {
                            ka = BitmapHelper.Bitmap2Bytes(jV, 100);
                        }
                        this.are.aqO.a(ka, jV);
                        this.are.aqO.invalidate();
                        this.are.aqO.play();
                        this.are.aqZ = false;
                    } else {
                        this.are.aqO.setImageBitmap(jV);
                        this.are.aqO.setImageData(aVar.ka());
                    }
                    this.are.Bg();
                } else if (!this.arg) {
                    this.are.aqO.Ht();
                }
            } else if (!this.arg) {
                this.are.aqO.Ht();
            }
        }
    }
}
