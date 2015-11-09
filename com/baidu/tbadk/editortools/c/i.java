package com.baidu.tbadk.editortools.c;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.g {
    final /* synthetic */ e aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.aqO = eVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                aVar = this.aqO.aqv;
                aVar.gC(true);
            }
        }
    }
}
