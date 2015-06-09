package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements com.baidu.tbadk.coreExtra.view.ad {
    final /* synthetic */ bq aOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.aOx = bqVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ad
    public boolean xU() {
        FrsActivity frsActivity;
        frsActivity = this.aOx.aMl;
        return frsActivity.checkUpIsLogin();
    }
}
