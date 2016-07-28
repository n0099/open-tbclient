package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t bWD;
    private final /* synthetic */ String bWE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.bWD = tVar;
        this.bWE = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bq bqVar10;
        if (aVar == null) {
            bqVar9 = this.bWD.bWx;
            bqVar9.WX().setVisibility(8);
            bqVar10 = this.bWD.bWx;
            bqVar10.WW().setVisibility(8);
            return;
        }
        if (aVar.cd()) {
            bqVar5 = this.bWD.bWx;
            bqVar5.WX().setVisibility(0);
            bqVar6 = this.bWD.bWx;
            bqVar6.WW().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.auG = this.bWE;
            aVar2.auE = this.bWE;
            bqVar7 = this.bWD.bWx;
            bqVar7.WX().a(aVar2);
            t tVar = this.bWD;
            bqVar8 = this.bWD.bWx;
            tVar.bWB = bqVar8.WX();
        } else {
            bqVar = this.bWD.bWx;
            bqVar.WX().setVisibility(8);
            bqVar2 = this.bWD.bWx;
            bqVar2.WW().setVisibility(0);
            bqVar3 = this.bWD.bWx;
            bqVar3.WW().c(this.bWE, 17, false);
            t tVar2 = this.bWD;
            bqVar4 = this.bWD.bWx;
            tVar2.bWB = bqVar4.WW();
        }
        this.bWD.aJ("c11103", null);
        if (this.bWD.bWB != null) {
            this.bWD.bWB.setOnClickListener(new w(this));
            this.bWD.aS(8000L);
        }
    }
}
