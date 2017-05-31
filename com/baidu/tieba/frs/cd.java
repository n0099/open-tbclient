package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements a.InterfaceC0059a {
    final /* synthetic */ cb bWW;
    final int boR = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds98);

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar) {
        this.bWW = cbVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Y(int i, int i2) {
        au auVar;
        au auVar2;
        if (S(i2)) {
            this.bWW.dO(false);
            this.bWW.Ye();
        }
        auVar = this.bWW.bWS;
        if (auVar != null) {
            auVar2 = this.bWW.bWS;
            auVar2.eh(true);
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Z(int i, int i2) {
        au auVar;
        au auVar2;
        if (S(i2)) {
            this.bWW.dO(true);
            if (Math.abs(i2) > this.boR) {
                this.bWW.Yd();
            }
        }
        auVar = this.bWW.bWS;
        if (auVar != null) {
            auVar2 = this.bWW.bWS;
            auVar2.eh(false);
        }
    }

    private boolean S(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
