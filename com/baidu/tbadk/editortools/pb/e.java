package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aBW = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void Dy() {
        this.aBW.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fR(String str) {
        this.aBW.b(2, true, str);
    }
}
