package com.baidu.tieba.frs;

import com.baidu.tieba.frs.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ab.a {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.view.ab.a
    public void go(int i) {
        switch (i) {
            case 0:
                this.bgz.bft = false;
                this.bgz.gm(0);
                return;
            case 1:
                this.bgz.OX();
                return;
            case 2:
                this.bgz.bft = false;
                this.bgz.OY();
                return;
            case 3:
                this.bgz.Pc();
                return;
            default:
                return;
        }
    }
}
