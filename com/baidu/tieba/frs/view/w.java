package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u bSc;
    private final /* synthetic */ String bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, String str) {
        this.bSc = uVar;
        this.bSd = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        if (aVar == null) {
            axVar9 = this.bSc.bRW;
            axVar9.XD().setVisibility(8);
            axVar10 = this.bSc.bRW;
            axVar10.XC().setVisibility(8);
            return;
        }
        if (aVar.cY()) {
            axVar5 = this.bSc.bRW;
            axVar5.XD().setVisibility(0);
            axVar6 = this.bSc.bRW;
            axVar6.XC().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axE = this.bSd;
            aVar2.axC = this.bSd;
            axVar7 = this.bSc.bRW;
            axVar7.XD().a(aVar2);
            u uVar = this.bSc;
            axVar8 = this.bSc.bRW;
            uVar.bSa = axVar8.XD();
        } else {
            axVar = this.bSc.bRW;
            axVar.XD().setVisibility(8);
            axVar2 = this.bSc.bRW;
            axVar2.XC().setVisibility(0);
            axVar3 = this.bSc.bRW;
            axVar3.XC().c(this.bSd, 17, false);
            u uVar2 = this.bSc;
            axVar4 = this.bSc.bRW;
            uVar2.bSa = axVar4.XC();
        }
        this.bSc.aJ("c11103", null);
        if (this.bSc.bSa != null) {
            this.bSc.bSa.setOnClickListener(new x(this));
            this.bSc.bb(8000L);
        }
    }
}
