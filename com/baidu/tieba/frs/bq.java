package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.adp.lib.guide.h {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.adp.lib.guide.h
    public void gW() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aLR.aJT;
        if (frsActivity != null) {
            frsActivity2 = this.aLR.aJT;
            frsActivity2.setSwipeBackEnabled(false);
        }
    }

    @Override // com.baidu.adp.lib.guide.h
    public void onDismiss() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aLR.aJT;
        if (frsActivity != null) {
            frsActivity2 = this.aLR.aJT;
            frsActivity2.setSwipeBackEnabled(true);
        }
    }
}
