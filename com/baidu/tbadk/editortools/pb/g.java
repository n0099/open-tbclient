package com.baidu.tbadk.editortools.pb;

import android.graphics.Bitmap;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    final /* synthetic */ c aBi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.aBi = cVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        NewWriteModel newWriteModel;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                newWriteModel = this.aBi.aAR;
                newWriteModel.ly(true);
            }
        }
    }
}
