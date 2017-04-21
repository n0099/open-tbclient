package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements a.InterfaceC0055a {
    final /* synthetic */ cg bSw;
    final int bnn = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar) {
        this.bSw = cgVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        az azVar;
        az azVar2;
        if (T(i2)) {
            this.bSw.dw(false);
            this.bSw.Yk();
        }
        azVar = this.bSw.bSr;
        if (azVar != null) {
            azVar2 = this.bSw.bSr;
            azVar2.dU(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void W(int i, int i2) {
        az azVar;
        az azVar2;
        if (T(i2)) {
            this.bSw.dw(true);
            if (Math.abs(i2) > this.bnn) {
                this.bSw.Yj();
            }
        }
        azVar = this.bSw.bSr;
        if (azVar != null) {
            azVar2 = this.bSw.bSr;
            azVar2.dU(false);
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
