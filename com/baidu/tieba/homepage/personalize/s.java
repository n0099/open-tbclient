package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements ae.b {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        x xVar;
        this.cIQ.cIK = true;
        xVar = this.cIQ.cIH;
        xVar.update();
    }
}
