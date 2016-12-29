package com.baidu.tbadk.editortools.e;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ e awr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.awr = eVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bVar = this.awr.avZ;
                bVar.la(true);
            }
        }
    }
}
