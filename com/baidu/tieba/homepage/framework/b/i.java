package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0057a {
    final int beq = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds98);
    final /* synthetic */ e cwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cwc = eVar;
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void Q(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cwc.cvY;
            if (aVar != null) {
                aVar2 = this.cwc.cvY;
                aVar2.dk(false);
                aVar3 = this.cwc.cvY;
                aVar3.eZ(false);
            }
        }
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void R(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cwc.cvY;
            if (aVar != null) {
                aVar2 = this.cwc.cvY;
                aVar2.dk(true);
                if (Math.abs(i2) > this.beq) {
                    aVar3 = this.cwc.cvY;
                    aVar3.eY(false);
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
