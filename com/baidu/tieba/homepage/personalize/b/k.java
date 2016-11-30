package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ao;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, a> {
    private TbPageContext<?> GO;
    private o.a afV;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bXs;
    private com.baidu.adp.lib.f.b<TbImageView> bXt;
    public BdUniqueId bcf;
    private ao cLI;
    private com.baidu.tieba.homepage.personalize.c.f cLJ;
    private bz cLK;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afV = null;
        this.bXs = new com.baidu.adp.lib.f.b<>(new l(this), 6, 0);
        this.bXt = new com.baidu.adp.lib.f.b<>(new m(this), 12, 0);
        this.cLK = new n(this);
        this.GO = tbPageContext;
        aoM();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a a(ViewGroup viewGroup) {
        this.cLI = new ao(this.GO);
        this.cLI.setSingleImageRatio(0.75d);
        this.cLI.setConstrainLayoutPool(this.bXs);
        this.cLI.setConstrainImagePool(this.bXt);
        this.cLI.j(this.bcf);
        return new a(this.cLI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, a aVar) {
        if (mVar != null) {
            mVar.gk(i + 1);
        }
        bx.Pl().a(mVar.PD());
        aVar.cLM.onBindDataToView(mVar);
        aVar.cLM.setOnSubCardOnClickListenner(this.cLK);
        aVar.cLM.a(this.afV);
        return aVar.getView();
    }

    private void aoM() {
        com.baidu.tieba.card.data.m.beX = "c10705";
        com.baidu.tieba.card.data.m.beY = "c10730";
        com.baidu.tieba.card.data.m.beZ = "c10731";
        com.baidu.tieba.card.data.m.bfa = "c10704";
        com.baidu.tieba.card.data.m.bfc = "c10755";
        com.baidu.tieba.card.data.m.bfd = "c10710";
        com.baidu.tieba.card.data.m.bfe = "c10736";
        com.baidu.tieba.card.data.m.bff = "c10737";
        com.baidu.tieba.card.data.m.bfg = "c10711";
        com.baidu.tieba.card.data.m.bfh = "c10758";
        com.baidu.tieba.card.data.m.bfi = "c10757";
    }

    public void setFromCDN(boolean z) {
        if (this.cLI != null) {
            this.cLI.setFromCDN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ao cLM;

        public a(ao aoVar) {
            super(aoVar.getView());
            this.cLM = aoVar;
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cLJ = fVar;
    }

    public void setEventCallback(o.a aVar) {
        this.afV = aVar;
    }
}
