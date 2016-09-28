package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ t chL;
    private final /* synthetic */ String chM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.chL = tVar;
        this.chM = str;
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
            bmVar9 = this.chL.chF;
            bmVar9.acg().setVisibility(8);
            bmVar10 = this.chL.chF;
            bmVar10.acf().setVisibility(8);
            return;
        }
        if (aVar.cY()) {
            bmVar5 = this.chL.chF;
            bmVar5.acg().setVisibility(0);
            bmVar6 = this.chL.chF;
            bmVar6.acf().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axq = this.chM;
            aVar2.axo = this.chM;
            bmVar7 = this.chL.chF;
            bmVar7.acg().a(aVar2);
            t tVar = this.chL;
            bmVar8 = this.chL.chF;
            tVar.chJ = bmVar8.acg();
        } else {
            bmVar = this.chL.chF;
            bmVar.acg().setVisibility(8);
            bmVar2 = this.chL.chF;
            bmVar2.acf().setVisibility(0);
            bmVar3 = this.chL.chF;
            bmVar3.acf().c(this.chM, 17, false);
            t tVar2 = this.chL;
            bmVar4 = this.chL.chF;
            tVar2.chJ = bmVar4.acf();
        }
        this.chL.aM("c11103", null);
        if (this.chL.chJ != null) {
            this.chL.chJ.setOnClickListener(new w(this));
            this.chL.bo(8000L);
        }
    }
}
