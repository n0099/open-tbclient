package com.baidu.tieba.frs;

import com.baidu.tieba.frs.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements x.a {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.view.x.a
    public void gl(int i) {
        switch (i) {
            case 0:
                this.bhl.bgd = false;
                this.bhl.gj(0);
                return;
            case 1:
                this.bhl.PK();
                return;
            case 2:
                this.bhl.bgd = false;
                this.bhl.PL();
                return;
            case 3:
                this.bhl.PQ();
                return;
            case 4:
                this.bhl.PR();
                return;
            default:
                return;
        }
    }
}
