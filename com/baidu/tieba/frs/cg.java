package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements a.InterfaceC0057a {
    final /* synthetic */ ce bJh;
    final int beq = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ce ceVar) {
        this.bJh = ceVar;
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void Q(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (T(i2)) {
            this.bJh.dk(false);
            this.bJh.VN();
        }
        axVar = this.bJh.bJc;
        if (axVar != null) {
            axVar2 = this.bJh.bJc;
            axVar2.dI(true);
        }
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void R(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (T(i2)) {
            this.bJh.dk(true);
            if (Math.abs(i2) > this.beq) {
                this.bJh.VM();
            }
        }
        axVar = this.bJh.bJc;
        if (axVar != null) {
            axVar2 = this.bJh.bJc;
            axVar2.dI(false);
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
