package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private NEGFeedBackView.a boM;
    private com.baidu.tieba.card.data.k cCk;
    private x dAU;
    private ad eav;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = null;
        this.eav = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cCk;
                v.akM().dc(true);
                if (view != null && h.this.dAU != null && h.this.dAU.getView() != null && kVar != null && kVar.UT() != null && !StringUtils.isNull(kVar.UT().getTid())) {
                    if (view.getId() != h.this.dAU.getView().getId()) {
                        if (h.this.dAU.getHeaderImg() == null || view.getId() != h.this.dAU.getHeaderImg().getId()) {
                            if (h.this.dAU.akp() == null || view.getId() != h.this.dAU.akp().getId()) {
                                if (h.this.dAU.bOr != null && h.this.dAU.bOr.aBk != null && view.getId() == h.this.dAU.bOr.aBk.getId()) {
                                    TiebaStatic.log(kVar.alj());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.alk());
                            return;
                        }
                        TiebaStatic.log(kVar.alk());
                        return;
                    }
                    TiebaStatic.log(kVar.lN("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aGJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dAU = new x(this.mPageContext);
        this.dAU.currentPageType = 2;
        if (this.dAU.bND != null) {
            this.dAU.bND.amD = 2;
        }
        if (this.dAU.bOr != null && this.dAU.bOr.aBl != null) {
            this.dAU.bOr.aBl.amD = 2;
        }
        if (this.dAU.cGe != null) {
            this.dAU.cGe.cGR = 2;
        }
        this.dAU.j(this.aUU);
        this.dAU.b(this.eav);
        return new com.baidu.tieba.card.a.a<>(this.dAU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.UT() == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        this.cCk = kVar;
        kVar.jv(i + 1);
        v.akM().a(kVar.lM("c12641"));
        if (kVar.aiT != null && kVar.aiT.size() > 0) {
            kVar.UT().a(kVar.aiT);
        }
        bc bcVar = new bc(kVar.UT());
        bcVar.stType = "personalize_page";
        bcVar.amB = 1;
        bcVar.amC = 3;
        bcVar.amE = 1;
        aVar.aln().a(this.boM);
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(bcVar);
        return aVar.getView();
    }

    private void aGJ() {
        com.baidu.tieba.card.data.k.cHM = "c10705";
        com.baidu.tieba.card.data.k.cHN = "c10730";
        com.baidu.tieba.card.data.k.cHO = "c10731";
        com.baidu.tieba.card.data.k.cHP = "c10704";
        com.baidu.tieba.card.data.k.cHQ = "c10755";
        com.baidu.tieba.card.data.k.cHR = "c10710";
        com.baidu.tieba.card.data.k.cHS = "c10736";
        com.baidu.tieba.card.data.k.cHT = "c10737";
        com.baidu.tieba.card.data.k.cHU = "c10711";
        com.baidu.tieba.card.data.k.cHV = "c10758";
        com.baidu.tieba.card.data.k.cHW = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
