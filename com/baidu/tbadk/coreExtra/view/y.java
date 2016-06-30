package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u ani;
    private final /* synthetic */ boolean ank;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, boolean z) {
        this.ani = uVar;
        this.ank = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        this.ani.bi(this.ank);
        z = this.ani.amY;
        if (!z) {
            if (aVar != null) {
                Bitmap jb = aVar.jb();
                if (jb != null) {
                    this.ani.amX = true;
                    if (aVar.ce()) {
                        byte[] jg = aVar.jg();
                        if (jg == null) {
                            jg = BitmapHelper.Bitmap2Bytes(jb, 100);
                        }
                        this.ani.amS.a(jg, jb);
                        this.ani.amS.invalidate();
                        this.ani.amS.play();
                        this.ani.and = false;
                    } else {
                        this.ani.amS.setImageBitmap(jb);
                        this.ani.amS.setImageData(aVar.jg());
                    }
                    this.ani.zR();
                } else if (!this.ank) {
                    this.ani.amS.FW();
                }
            } else if (!this.ank) {
                this.ani.amS.FW();
            }
        }
    }
}
