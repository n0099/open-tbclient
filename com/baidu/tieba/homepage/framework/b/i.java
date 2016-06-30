package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.InterfaceC0054c {
    final int bDC = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds98);
    final /* synthetic */ e cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cqb = eVar;
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void K(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (B(i2)) {
            aVar = this.cqb.cpX;
            if (aVar != null) {
                aVar2 = this.cqb.cpX;
                aVar2.dt(false);
                aVar3 = this.cqb.cpX;
                aVar3.ex(false);
            }
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void L(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (B(i2)) {
            aVar = this.cqb.cpX;
            if (aVar != null) {
                aVar2 = this.cqb.cpX;
                aVar2.dt(true);
                if (Math.abs(i2) > this.bDC) {
                    aVar3 = this.cqb.cpX;
                    aVar3.ew(false);
                }
            }
        }
    }

    private boolean B(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
