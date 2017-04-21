package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aBi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aBi = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void Eg() {
        this.aBi.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fC(String str) {
        this.aBi.b(2, true, str);
    }
}
