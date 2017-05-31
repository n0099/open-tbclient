package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aAT = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void De() {
        this.aAT.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fx(String str) {
        this.aAT.b(2, true, str);
    }
}
