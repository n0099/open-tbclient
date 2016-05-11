package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ab bwX;
    private final /* synthetic */ String bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, String str) {
        this.bwX = abVar;
        this.bwY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        cn cnVar6;
        cn cnVar7;
        cn cnVar8;
        cn cnVar9;
        cn cnVar10;
        if (aVar == null) {
            cnVar9 = this.bwX.bwR;
            cnVar9.Rl().setVisibility(8);
            cnVar10 = this.bwX.bwR;
            cnVar10.Rk().setVisibility(8);
            return;
        }
        if (aVar.cd()) {
            cnVar5 = this.bwX.bwR;
            cnVar5.Rl().setVisibility(0);
            cnVar6 = this.bwX.bwR;
            cnVar6.Rk().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atb = this.bwY;
            aVar2.asZ = this.bwY;
            cnVar7 = this.bwX.bwR;
            cnVar7.Rl().a(aVar2);
            ab abVar = this.bwX;
            cnVar8 = this.bwX.bwR;
            abVar.bwV = cnVar8.Rl();
        } else {
            cnVar = this.bwX.bwR;
            cnVar.Rl().setVisibility(8);
            cnVar2 = this.bwX.bwR;
            cnVar2.Rk().setVisibility(0);
            cnVar3 = this.bwX.bwR;
            cnVar3.Rk().c(this.bwY, 17, false);
            ab abVar2 = this.bwX;
            cnVar4 = this.bwX.bwR;
            abVar2.bwV = cnVar4.Rk();
        }
        this.bwX.aG("c11103", null);
        if (this.bwX.bwV != null) {
            this.bwX.bwV.setOnClickListener(new ae(this));
            this.bwX.aH(8000L);
        }
    }
}
