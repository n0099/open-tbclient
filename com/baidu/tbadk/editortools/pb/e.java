package com.baidu.tbadk.editortools.pb;

import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationModel.b {
    final /* synthetic */ c aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.aAQ = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void DI() {
        this.aAQ.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
    public void fw(String str) {
        this.aAQ.b(2, true, str);
    }
}
