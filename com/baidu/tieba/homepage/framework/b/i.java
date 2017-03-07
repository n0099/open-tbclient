package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0056a {
    final int bld = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds98);
    final /* synthetic */ e cxB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cxB = eVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void V(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cxB.cxx;
            if (aVar != null) {
                aVar2 = this.cxB.cxx;
                aVar2.dk(false);
                aVar3 = this.cxB.cxx;
                aVar3.eQ(false);
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void W(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (T(i2)) {
            aVar = this.cxB.cxx;
            if (aVar != null) {
                aVar2 = this.cxB.cxx;
                aVar2.dk(true);
                if (Math.abs(i2) > this.bld) {
                    aVar3 = this.cxB.cxx;
                    aVar3.eP(false);
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
