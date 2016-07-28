package com.baidu.tieba.frs;

import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class i implements c.InterfaceC0055c {
    final /* synthetic */ FrsActivity bEL;
    final int bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bEL = frsActivity;
        this.bEM = (int) frsActivity.getResources().getDimension(u.e.ds98);
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void K(int i, int i2) {
        bq bqVar;
        bq bqVar2;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        if (L(i2)) {
            cdo = this.bEL.bEf;
            if (cdo != null) {
                cdo2 = this.bEL.bEf;
                cdo2.dq(false);
                cdo3 = this.bEL.bEf;
                cdo3.XC();
            }
        }
        bqVar = this.bEL.bDK;
        if (bqVar != null) {
            bqVar2 = this.bEL.bDK;
            bqVar2.m16do(true);
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void L(int i, int i2) {
        bq bqVar;
        bq bqVar2;
        Cdo cdo;
        Cdo cdo2;
        Cdo cdo3;
        if (L(i2)) {
            cdo = this.bEL.bEf;
            if (cdo != null) {
                cdo2 = this.bEL.bEf;
                cdo2.dq(true);
                if (Math.abs(i2) > this.bEM) {
                    cdo3 = this.bEL.bEf;
                    cdo3.XB();
                }
            }
        }
        bqVar = this.bEL.bDK;
        if (bqVar != null) {
            bqVar2 = this.bEL.bDK;
            bqVar2.m16do(false);
        }
    }

    private boolean L(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
