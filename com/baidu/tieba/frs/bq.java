package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.adp.lib.guide.h {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.adp.lib.guide.h
    public void gW() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aMc.aKd;
        if (frsActivity != null) {
            frsActivity2 = this.aMc.aKd;
            frsActivity2.setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.lib.guide.h
    public void onDismiss() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aMc.aKd;
        if (frsActivity != null) {
            frsActivity2 = this.aMc.aKd;
            frsActivity2.setSwipeBackEnabled(true);
        }
    }
}
