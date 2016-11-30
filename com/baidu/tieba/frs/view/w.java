package com.baidu.tieba.frs.view;

import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u cmS;
    private final /* synthetic */ String cmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, String str) {
        this.cmS = uVar;
        this.cmT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        au auVar;
        au auVar2;
        au auVar3;
        au auVar4;
        au auVar5;
        au auVar6;
        au auVar7;
        au auVar8;
        au auVar9;
        au auVar10;
        if (aVar == null) {
            auVar9 = this.cmS.cmM;
            auVar9.adn().setVisibility(8);
            auVar10 = this.cmS.cmM;
            auVar10.adm().setVisibility(8);
            return;
        }
        if (aVar.cY()) {
            auVar5 = this.cmS.cmM;
            auVar5.adn().setVisibility(0);
            auVar6 = this.cmS.cmM;
            auVar6.adm().setVisibility(8);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.ayh = this.cmT;
            aVar2.ayf = this.cmT;
            auVar7 = this.cmS.cmM;
            auVar7.adn().a(aVar2);
            u uVar = this.cmS;
            auVar8 = this.cmS.cmM;
            uVar.cmQ = auVar8.adn();
        } else {
            auVar = this.cmS.cmM;
            auVar.adn().setVisibility(8);
            auVar2 = this.cmS.cmM;
            auVar2.adm().setVisibility(0);
            auVar3 = this.cmS.cmM;
            auVar3.adm().c(this.cmT, 17, false);
            u uVar2 = this.cmS;
            auVar4 = this.cmS.cmM;
            uVar2.cmQ = auVar4.adm();
        }
        this.cmS.aN("c11103", null);
        if (this.cmS.cmQ != null) {
            this.cmS.cmQ.setOnClickListener(new x(this));
            this.cmS.bn(8000L);
        }
    }
}
