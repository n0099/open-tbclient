package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements com.baidu.tbadk.coreExtra.view.ad {
    final /* synthetic */ bq aOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.aOw = bqVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ad
    public boolean xT() {
        FrsActivity frsActivity;
        frsActivity = this.aOw.aMk;
        return frsActivity.checkUpIsLogin();
    }
}
