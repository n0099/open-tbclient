package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bUs;
    private com.baidu.adp.lib.f.b<TbImageView> bUt;
    private aq cFJ;
    private com.baidu.tieba.homepage.personalize.b.f cFK;
    private cf cFL;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bUs = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bUt = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.cFL = new n(this);
        this.GM = tbPageContext;
        amE();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a a(ViewGroup viewGroup) {
        this.cFJ = new aq(this.GM);
        this.cFJ.setConstrainLayoutPool(this.bUs);
        this.cFJ.setConstrainImagePool(this.bUt);
        this.cFJ.j(this.aYu);
        return new a(this.cFJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gf(i + 1);
        }
        cd.NI().b(mVar.NY());
        aVar.cFN.onBindDataToView(mVar);
        aVar.cFN.setOnSubCardOnClickListenner(this.cFL);
        return aVar.getView();
    }

    private void amE() {
        com.baidu.tieba.card.data.m.bbH = "c10705";
        com.baidu.tieba.card.data.m.bbI = "c10730";
        com.baidu.tieba.card.data.m.bbJ = "c10731";
        com.baidu.tieba.card.data.m.bbK = "c10704";
        com.baidu.tieba.card.data.m.bbL = "c10755";
        com.baidu.tieba.card.data.m.bbM = "c10710";
        com.baidu.tieba.card.data.m.bbN = "c10736";
        com.baidu.tieba.card.data.m.bbO = "c10737";
        com.baidu.tieba.card.data.m.bbP = "c10711";
        com.baidu.tieba.card.data.m.bbQ = "c10758";
        com.baidu.tieba.card.data.m.bbR = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cFJ != null) {
            this.cFJ.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public aq cFN;

        public a(aq aqVar) {
            super(aqVar.getView());
            this.cFN = aqVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cFK = fVar;
    }
}
