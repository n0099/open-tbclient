package com.baidu.tieba.frs;

import com.baidu.tieba.frs.view.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ac.a {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tieba.frs.view.ac.a
    public void gF(int i) {
        switch (i) {
            case 0:
                this.blk.bkd = false;
                this.blk.gD(0);
                return;
            case 1:
                this.blk.QM();
                return;
            case 2:
                this.blk.bkd = false;
                this.blk.QN();
                return;
            case 3:
                this.blk.QR();
                return;
            default:
                return;
        }
    }
}
