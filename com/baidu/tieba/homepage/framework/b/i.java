package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0058a {
    final int bVH = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds98);
    final /* synthetic */ e cJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cJF = eVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cJF.cJB;
            if (aVar != null) {
                aVar2 = this.cJF.cJB;
                aVar2.dv(false);
                aVar3 = this.cJF.cJB;
                aVar3.fk(false);
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void Q(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cJF.cJB;
            if (aVar != null) {
                aVar2 = this.cJF.cJB;
                aVar2.dv(true);
                if (Math.abs(i2) > this.bVH) {
                    aVar3 = this.cJF.cJB;
                    aVar3.fj(false);
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
