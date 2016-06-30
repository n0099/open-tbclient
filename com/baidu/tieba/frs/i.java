package com.baidu.tieba.frs;

import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class i implements c.InterfaceC0054c {
    final /* synthetic */ FrsActivity bDB;
    final int bDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bDB = frsActivity;
        this.bDC = (int) frsActivity.getResources().getDimension(u.e.ds98);
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void K(int i, int i2) {
        bq bqVar;
        bq bqVar2;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        if (B(i2)) {
            cdo = this.bDB.bCY;
            if (cdo != null) {
                cdo2 = this.bDB.bCY;
                cdo2.dt(false);
                cdo3 = this.bDB.bCY;
                cdo3.Xk();
            }
        }
        bqVar = this.bDB.bCD;
        if (bqVar != null) {
            bqVar2 = this.bDB.bCD;
            bqVar2.dr(true);
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void L(int i, int i2) {
        bq bqVar;
        bq bqVar2;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        if (B(i2)) {
            cdo = this.bDB.bCY;
            if (cdo != null) {
                cdo2 = this.bDB.bCY;
                cdo2.dt(true);
                if (Math.abs(i2) > this.bDC) {
                    cdo3 = this.bDB.bCY;
                    cdo3.Xj();
                }
            }
        }
        bqVar = this.bDB.bCD;
        if (bqVar != null) {
            bqVar2 = this.bDB.bCD;
            bqVar2.dr(false);
        }
    }

    private boolean B(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
