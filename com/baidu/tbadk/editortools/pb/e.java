package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aBh = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void Dk() {
        this.aBh.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fz(String str) {
        this.aBh.b(2, true, str);
    }
}
