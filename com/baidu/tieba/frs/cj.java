package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements a.InterfaceC0058a {
    final /* synthetic */ ch bVG;
    final int bVH = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.bVG = chVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        au auVar;
        au auVar2;
        if (af(i2)) {
            this.bVG.dv(false);
            this.bVG.aaf();
        }
        auVar = this.bVG.bVA;
        if (auVar != null) {
            auVar2 = this.bVG.bVA;
            auVar2.dU(true);
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void Q(int i, int i2) {
        au auVar;
        au auVar2;
        if (af(i2)) {
            this.bVG.dv(true);
            if (Math.abs(i2) > this.bVH) {
                this.bVG.aae();
            }
        }
        auVar = this.bVG.bVA;
        if (auVar != null) {
            auVar2 = this.bVG.bVA;
            auVar2.dU(false);
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
