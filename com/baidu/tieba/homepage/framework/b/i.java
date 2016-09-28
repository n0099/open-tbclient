package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0058a {
    final int bQj = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds98);
    final /* synthetic */ e cEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cEs = eVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void O(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cEs.cEo;
            if (aVar != null) {
                aVar2 = this.cEs.cEo;
                aVar2.dq(false);
                aVar3 = this.cEs.cEo;
                aVar3.eV(false);
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cEs.cEo;
            if (aVar != null) {
                aVar2 = this.cEs.cEo;
                aVar2.dq(true);
                if (Math.abs(i2) > this.bQj) {
                    aVar3 = this.cEs.cEo;
                    aVar3.eU(false);
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
