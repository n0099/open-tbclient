package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    private com.baidu.tieba.card.data.k cmc;
    private ab dAS;
    private x dea;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.dAS = new ab<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cmc;
                v.afy().cB(true);
                if (view2 != null && h.this.dea != null && h.this.dea.getView() != null && kVar != null && kVar.Pe() != null && !StringUtils.isNull(kVar.Pe().getTid())) {
                    if (view2.getId() != h.this.dea.getView().getId()) {
                        if (h.this.dea.getHeaderImg() == null || view2.getId() != h.this.dea.getHeaderImg().getId()) {
                            if (h.this.dea.afc() == null || view2.getId() != h.this.dea.afc().getId()) {
                                if (h.this.dea.bwZ != null && h.this.dea.bwZ.apF != null && view2.getId() == h.this.dea.bwZ.apF.getId()) {
                                    TiebaStatic.log(kVar.afU());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.afV());
                            return;
                        }
                        TiebaStatic.log(kVar.afV());
                        return;
                    }
                    TiebaStatic.log(kVar.kH("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        axZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dea = new x(this.mPageContext);
        this.dea.currentPageType = 2;
        if (this.dea.bwk != null) {
            this.dea.bwk.abV = 2;
        }
        if (this.dea.bwZ != null && this.dea.bwZ.apG != null) {
            this.dea.bwZ.apG.abV = 2;
        }
        if (this.dea.cqk != null) {
            this.dea.cqk.cqV = 2;
        }
        this.dea.j(this.aTr);
        this.dea.b(this.dAS);
        return new com.baidu.tieba.card.a.a<>(this.dea);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Pe() == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        this.cmc = kVar;
        kVar.iO(i + 1);
        v.afy().a(kVar.kG("c12641"));
        if (kVar.YI != null && kVar.YI.size() > 0) {
            kVar.Pe().a(kVar.YI);
        }
        be beVar = new be(kVar.Pe());
        beVar.stType = "personalize_page";
        beVar.abT = 1;
        beVar.abU = 3;
        aVar.afY().a(this.aYO);
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(beVar);
        return aVar.getView();
    }

    private void axZ() {
        com.baidu.tieba.card.data.k.crN = "c10705";
        com.baidu.tieba.card.data.k.crO = "c10730";
        com.baidu.tieba.card.data.k.crP = "c10731";
        com.baidu.tieba.card.data.k.crQ = "c10704";
        com.baidu.tieba.card.data.k.crR = "c10755";
        com.baidu.tieba.card.data.k.crS = "c10710";
        com.baidu.tieba.card.data.k.crT = "c10736";
        com.baidu.tieba.card.data.k.crU = "c10737";
        com.baidu.tieba.card.data.k.crV = "c10711";
        com.baidu.tieba.card.data.k.crW = "c10758";
        com.baidu.tieba.card.data.k.crX = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
