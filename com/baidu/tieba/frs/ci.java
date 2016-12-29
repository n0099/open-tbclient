package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements a.InterfaceC0057a {
    final /* synthetic */ cg bBO;
    final int bBP = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar) {
        this.bBO = cgVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void P(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (aa(i2)) {
            this.bBO.dd(false);
            this.bBO.Us();
        }
        axVar = this.bBO.bBI;
        if (axVar != null) {
            axVar2 = this.bBO.bBI;
            axVar2.dC(true);
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void Q(int i, int i2) {
        ax axVar;
        ax axVar2;
        if (aa(i2)) {
            this.bBO.dd(true);
            if (Math.abs(i2) > this.bBP) {
                this.bBO.Ur();
            }
        }
        axVar = this.bBO.bBI;
        if (axVar != null) {
            axVar2 = this.bBO.bBI;
            axVar2.dC(false);
        }
    }

    private boolean aa(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
