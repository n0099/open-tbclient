package com.baidu.tbadk.editortools.d;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ e atr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.atr = eVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                aVar = this.atr.asZ;
                aVar.kB(true);
            }
        }
    }
}
