package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<r>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRC;
    private String bHB;
    private NEGFeedBackView.a bjc;
    private ad dTe;
    private r dYh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjc = null;
        this.dTe = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.ajb().cL(true);
                if (view != null && e.this.dYh != null && e.this.dYh.getView() != null && kVar != null && kVar.Tg() != null && !StringUtils.isNull(kVar.Tg().getTid())) {
                    if (view.getId() != e.this.dYh.getView().getId()) {
                        if (e.this.dYh.getHeaderImg() == null || view.getId() != e.this.dYh.getHeaderImg().getId()) {
                            if (e.this.dYh.aiF() == null || view.getId() != e.this.dYh.aiF().getId()) {
                                if (e.this.dYh.bHO == null || e.this.dYh.bHO.getBarNameTv() == null || view.getId() != e.this.dYh.bHO.getBarNameTv().getId()) {
                                    if (e.this.dYh.bIC == null || e.this.dYh.bIC.ayn == null || view.getId() != e.this.dYh.bIC.ayn.getId()) {
                                        if (e.this.dYh.aiE() != null && view.getId() == e.this.dYh.aiE().getId()) {
                                            TiebaStatic.log(kVar.lj("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.ajy());
                                    return;
                                }
                                TiebaStatic.log(kVar.ajy());
                                return;
                            }
                            TiebaStatic.log(kVar.li("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.li("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.li("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEu();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dYh = new r(this.mPageContext);
        this.dYh.currentPageType = 2;
        if (this.dYh.bHO != null) {
            this.dYh.bHO.ajY = 2;
        }
        if (this.dYh.bIC != null && this.dYh.bIC.ayo != null) {
            this.dYh.bIC.ayo.ajY = 2;
        }
        this.dYh.j(this.aRC);
        return new com.baidu.tieba.card.a.a<>(this.dYh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        kVar.iW(i + 1);
        v.ajb().a(kVar.lh("c12190"));
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(kVar);
        aVar.ajC().b(this.dTe);
        aVar.ajC().a(this.bjc);
        return aVar.getView();
    }

    private void aEu() {
        com.baidu.tieba.card.data.k.cBV = "c10705";
        com.baidu.tieba.card.data.k.cBW = "c10730";
        com.baidu.tieba.card.data.k.cBX = "c10731";
        com.baidu.tieba.card.data.k.cBY = "c10704";
        com.baidu.tieba.card.data.k.cBZ = "c10755";
        com.baidu.tieba.card.data.k.cCa = "c10710";
        com.baidu.tieba.card.data.k.cCb = "c10736";
        com.baidu.tieba.card.data.k.cCc = "c10737";
        com.baidu.tieba.card.data.k.cCd = "c10711";
        com.baidu.tieba.card.data.k.cCe = "c10758";
        com.baidu.tieba.card.data.k.cCf = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bjc = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
