package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ab anI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.anI = abVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void al(String str) {
        this.anI.anD.setVisibility(0);
        this.anI.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ab.a aVar2;
        boolean z;
        ab.a aVar3;
        this.anI.anG = true;
        this.anI.mProgressBar.setVisibility(8);
        if (aVar != null) {
            aVar2 = this.anI.anE;
            if (aVar2 != null) {
                aVar3 = this.anI.anE;
                aVar3.i(aVar.getUrl(), aVar.ne());
            }
            Bitmap mZ = aVar.mZ();
            if (mZ == null) {
                z = this.anI.anF;
                if (!z) {
                    this.anI.anD.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fF()) {
                this.anI.anD.a(aVar.ne(), mZ);
            } else {
                this.anI.anD.setImageBitmap(mZ);
                this.anI.anD.setImageData(aVar.ne());
            }
            this.anI.anD.setLoadBigImage(true);
        }
    }
}
