package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.InterfaceC0055c {
    final int bEM = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds98);
    final /* synthetic */ e csG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.csG = eVar;
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void K(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (L(i2)) {
            aVar = this.csG.csC;
            if (aVar != null) {
                aVar2 = this.csG.csC;
                aVar2.dq(false);
                aVar3 = this.csG.csC;
                aVar3.ey(false);
            }
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void L(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (L(i2)) {
            aVar = this.csG.csC;
            if (aVar != null) {
                aVar2 = this.csG.csC;
                aVar2.dq(true);
                if (Math.abs(i2) > this.bEM) {
                    aVar3 = this.csG.csC;
                    aVar3.ex(false);
                }
            }
        }
    }

    private boolean L(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
