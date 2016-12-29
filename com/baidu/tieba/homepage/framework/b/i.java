package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0057a {
    final int bBP = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds98);
    final /* synthetic */ e cpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cpa = eVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void P(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (aa(i2)) {
            aVar = this.cpa.coW;
            if (aVar != null) {
                aVar2 = this.cpa.coW;
                aVar2.dd(false);
                aVar3 = this.cpa.coW;
                aVar3.eV(false);
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void Q(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (aa(i2)) {
            aVar = this.cpa.coW;
            if (aVar != null) {
                aVar2 = this.cpa.coW;
                aVar2.dd(true);
                if (Math.abs(i2) > this.bBP) {
                    aVar3 = this.cpa.coW;
                    aVar3.eU(false);
                }
            }
        }
    }

    private boolean aa(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
