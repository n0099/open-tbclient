package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t bUD;
    private final /* synthetic */ String bUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.bUD = tVar;
        this.bUE = str;
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
            bqVar9 = this.bUD.bUx;
            bqVar9.WF().setVisibility(8);
            bqVar10 = this.bUD.bUx;
            bqVar10.WE().setVisibility(8);
            return;
        }
        if (aVar.ce()) {
            bqVar5 = this.bUD.bUx;
            bqVar5.WF().setVisibility(0);
            bqVar6 = this.bUD.bUx;
            bqVar6.WE().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atR = this.bUE;
            aVar2.atP = this.bUE;
            bqVar7 = this.bUD.bUx;
            bqVar7.WF().a(aVar2);
            t tVar = this.bUD;
            bqVar8 = this.bUD.bUx;
            tVar.bUB = bqVar8.WF();
        } else {
            bqVar = this.bUD.bUx;
            bqVar.WF().setVisibility(8);
            bqVar2 = this.bUD.bUx;
            bqVar2.WE().setVisibility(0);
            bqVar3 = this.bUD.bUx;
            bqVar3.WE().c(this.bUE, 17, false);
            t tVar2 = this.bUD;
            bqVar4 = this.bUD.bUx;
            tVar2.bUB = bqVar4.WE();
        }
        this.bUD.aI("c11103", null);
        if (this.bUD.bUB != null) {
            this.bUD.bUB.setOnClickListener(new w(this));
            this.bUD.aX(8000L);
        }
    }
}
