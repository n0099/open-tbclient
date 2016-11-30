package com.baidu.tbadk.editortools.e;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ e awU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.awU = eVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bVar = this.awU.awC;
                bVar.lp(true);
            }
        }
    }
}
