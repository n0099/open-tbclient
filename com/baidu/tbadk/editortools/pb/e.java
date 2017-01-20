package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c avv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.avv = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void Dp() {
        this.avv.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fH(String str) {
        this.avv.b(2, true, str);
    }
}
