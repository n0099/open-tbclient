package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ae alW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.alW = aeVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void al(String str) {
        this.alW.alR.setVisibility(0);
        this.alW.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ae.a aVar2;
        boolean z;
        ae.a aVar3;
        this.alW.alU = true;
        this.alW.mProgressBar.setVisibility(8);
        if (aVar != null) {
            aVar2 = this.alW.alS;
            if (aVar2 != null) {
                aVar3 = this.alW.alS;
                aVar3.i(aVar.getUrl(), aVar.nh());
            }
            Bitmap nc = aVar.nc();
            if (nc == null) {
                z = this.alW.alT;
                if (!z) {
                    this.alW.alR.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fI()) {
                this.alW.alR.a(aVar.nh(), nc);
            } else {
                this.alW.alR.setImageBitmap(nc);
                this.alW.alR.setImageData(aVar.nh());
            }
            this.alW.alR.setLoadBigImage(true);
        }
    }
}
