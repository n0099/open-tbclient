package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements a.InterfaceC0059a {
    final /* synthetic */ ca bRg;
    final int bnK = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.bRg = caVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void W(int i, int i2) {
        at atVar;
        at atVar2;
        if (T(i2)) {
            this.bRg.dx(false);
            this.bRg.Xb();
        }
        atVar = this.bRg.bRb;
        if (atVar != null) {
            atVar2 = this.bRg.bRb;
            atVar2.dR(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void X(int i, int i2) {
        at atVar;
        at atVar2;
        if (T(i2)) {
            this.bRg.dx(true);
            if (Math.abs(i2) > this.bnK) {
                this.bRg.Xa();
            }
        }
        atVar = this.bRg.bRb;
        if (atVar != null) {
            atVar2 = this.bRg.bRb;
            atVar2.dR(false);
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
