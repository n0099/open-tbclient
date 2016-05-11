package com.baidu.tieba.frs;

import com.baidu.tieba.c.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class h implements c.InterfaceC0053c {
    final /* synthetic */ FrsActivity bhl;
    final int bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.bhl = frsActivity;
        this.bhm = (int) frsActivity.getResources().getDimension(t.e.ds98);
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void O(int i, int i2) {
        cn cnVar;
        cn cnVar2;
        fk fkVar;
        fk fkVar2;
        fk fkVar3;
        if (v(i2)) {
            fkVar = this.bhl.bgK;
            if (fkVar != null) {
                fkVar2 = this.bhl.bgK;
                fkVar2.cX(false);
                fkVar3 = this.bhl.bgK;
                fkVar3.RS();
            }
        }
        cnVar = this.bhl.bgo;
        if (cnVar != null) {
            cnVar2 = this.bhl.bgo;
            cnVar2.cV(true);
        }
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void P(int i, int i2) {
        cn cnVar;
        cn cnVar2;
        fk fkVar;
        fk fkVar2;
        fk fkVar3;
        if (v(i2)) {
            fkVar = this.bhl.bgK;
            if (fkVar != null) {
                fkVar2 = this.bhl.bgK;
                fkVar2.cX(true);
                if (Math.abs(i2) > this.bhm) {
                    fkVar3 = this.bhl.bgK;
                    fkVar3.RR();
                }
            }
        }
        cnVar = this.bhl.bgo;
        if (cnVar != null) {
            cnVar2 = this.bhl.bgo;
            cnVar2.cV(false);
        }
    }

    private boolean v(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
