package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0055a {
    final int bnn = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds98);
    final /* synthetic */ e cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cys = eVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cys.cyo;
            if (aVar != null) {
                aVar2 = this.cys.cyo;
                aVar2.dw(false);
                aVar3 = this.cys.cyo;
                aVar3.fa(false);
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void W(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cys.cyo;
            if (aVar != null) {
                aVar2 = this.cys.cyo;
                aVar2.dw(true);
                if (Math.abs(i2) > this.bnn) {
                    aVar3 = this.cys.cyo;
                    aVar3.eZ(false);
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
