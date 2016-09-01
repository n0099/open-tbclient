package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t chN;
    private final /* synthetic */ String chO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.chN = tVar;
        this.chO = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        bm bmVar10;
        if (aVar == null) {
            bmVar9 = this.chN.chH;
            bmVar9.abT().setVisibility(8);
            bmVar10 = this.chN.chH;
            bmVar10.abS().setVisibility(8);
            return;
        }
        if (aVar.cY()) {
            bmVar5 = this.chN.chH;
            bmVar5.abT().setVisibility(0);
            bmVar6 = this.chN.chH;
            bmVar6.abS().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axN = this.chO;
            aVar2.axL = this.chO;
            bmVar7 = this.chN.chH;
            bmVar7.abT().a(aVar2);
            t tVar = this.chN;
            bmVar8 = this.chN.chH;
            tVar.chL = bmVar8.abT();
        } else {
            bmVar = this.chN.chH;
            bmVar.abT().setVisibility(8);
            bmVar2 = this.chN.chH;
            bmVar2.abS().setVisibility(0);
            bmVar3 = this.chN.chH;
            bmVar3.abS().c(this.chO, 17, false);
            t tVar2 = this.chN;
            bmVar4 = this.chN.chH;
            tVar2.chL = bmVar4.abS();
        }
        this.chN.aK("c11103", null);
        if (this.chN.chL != null) {
            this.chN.chL.setOnClickListener(new w(this));
            this.chN.bo(8000L);
        }
    }
}
