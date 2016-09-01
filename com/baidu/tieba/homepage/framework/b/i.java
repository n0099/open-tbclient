package com.baidu.tieba.homepage.framework.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0055a {
    final int bQq = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds98);
    final /* synthetic */ e cDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.cDO = eVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void N(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cDO.cDK;
            if (aVar != null) {
                aVar2 = this.cDO.cDK;
                aVar2.dp(false);
                aVar3 = this.cDO.cDK;
                aVar3.eU(false);
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void O(int i, int i2) {
        a aVar;
        a aVar2;
        a aVar3;
        if (af(i2)) {
            aVar = this.cDO.cDK;
            if (aVar != null) {
                aVar2 = this.cDO.cDK;
                aVar2.dp(true);
                if (Math.abs(i2) > this.bQq) {
                    aVar3 = this.cDO.cDK;
                    aVar3.eT(false);
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 10.0f;
    }
}
