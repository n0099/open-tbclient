package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements a.InterfaceC0056a {
    final /* synthetic */ ce bQq;
    final int bld = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ce ceVar) {
        this.bQq = ceVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void V(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (T(i2)) {
            this.bQq.dk(false);
            this.bQq.WL();
        }
        axVar = this.bQq.bQl;
        if (axVar != null) {
            axVar2 = this.bQq.bQl;
            axVar2.dI(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void W(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (T(i2)) {
            this.bQq.dk(true);
            if (Math.abs(i2) > this.bld) {
                this.bQq.WK();
            }
        }
        axVar = this.bQq.bQl;
        if (axVar != null) {
            axVar2 = this.bQq.bQl;
            axVar2.dI(false);
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
