package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements a.InterfaceC0062a {
    final int bsH = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds98);
    final /* synthetic */ cc cff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.cff = ccVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ah(int i, int i2) {
        av avVar;
        av avVar2;
        if (Y(i2)) {
            this.cff.ee(false);
            this.cff.showFloatingView();
        }
        avVar = this.cff.cfa;
        if (avVar != null) {
            avVar2 = this.cff.cfa;
            avVar2.ez(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ai(int i, int i2) {
        av avVar;
        av avVar2;
        if (Y(i2)) {
            this.cff.ee(true);
            if (Math.abs(i2) > this.bsH) {
                this.cff.hideFloatingView();
            }
        }
        avVar = this.cff.cfa;
        if (avVar != null) {
            avVar2 = this.cff.cfa;
            avVar2.ez(false);
        }
    }

    private boolean Y(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
