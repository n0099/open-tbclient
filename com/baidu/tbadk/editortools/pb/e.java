package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aBg = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void Eg() {
        this.aBg.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fC(String str) {
        this.aBg.b(2, true, str);
    }
}
