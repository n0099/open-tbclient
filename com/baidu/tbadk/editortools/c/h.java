package com.baidu.tbadk.editortools.c;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ d asl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.asl = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                aVar = this.asl.arV;
                aVar.gw(true);
            }
        }
    }
}
