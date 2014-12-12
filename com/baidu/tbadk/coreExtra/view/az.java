package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ay Va;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.Va = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        this.Va.UY.setVisibility(0);
        this.Va.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ba baVar;
        ba baVar2;
        this.Va.mProgressBar.setVisibility(8);
        if (aVar != null) {
            baVar = this.Va.UZ;
            if (baVar != null) {
                baVar2 = this.Va.UZ;
                baVar2.i(aVar.getUrl(), aVar.jn());
            }
            Bitmap ji = aVar.ji();
            if (ji == null) {
                this.Va.UY.setDefaultBitmap();
            } else if (aVar.cm()) {
                this.Va.UY.a(aVar.jn(), ji);
            } else {
                this.Va.UY.setImageBitmap(ji);
                this.Va.UY.setImageData(aVar.jn());
            }
        }
    }
}
