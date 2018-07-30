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
    public BdUniqueId aRF;
    private String bHB;
    private NEGFeedBackView.a biW;
    private ad dTj;
    private r dYk;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.biW = null;
        this.dTj = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aiY().cK(true);
                if (view != null && e.this.dYk != null && e.this.dYk.getView() != null && kVar != null && kVar.Td() != null && !StringUtils.isNull(kVar.Td().getTid())) {
                    if (view.getId() != e.this.dYk.getView().getId()) {
                        if (e.this.dYk.getHeaderImg() == null || view.getId() != e.this.dYk.getHeaderImg().getId()) {
                            if (e.this.dYk.aiC() == null || view.getId() != e.this.dYk.aiC().getId()) {
                                if (e.this.dYk.bHO == null || e.this.dYk.bHO.getBarNameTv() == null || view.getId() != e.this.dYk.bHO.getBarNameTv().getId()) {
                                    if (e.this.dYk.bIC == null || e.this.dYk.bIC.ayq == null || view.getId() != e.this.dYk.bIC.ayq.getId()) {
                                        if (e.this.dYk.aiB() != null && view.getId() == e.this.dYk.aiB().getId()) {
                                            TiebaStatic.log(kVar.lh("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.ajv());
                                    return;
                                }
                                TiebaStatic.log(kVar.ajv());
                                return;
                            }
                            TiebaStatic.log(kVar.lg("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.lg("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.lg("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dYk = new r(this.mPageContext);
        this.dYk.currentPageType = 2;
        if (this.dYk.bHO != null) {
            this.dYk.bHO.ajY = 2;
        }
        if (this.dYk.bIC != null && this.dYk.bIC.ayr != null) {
            this.dYk.bIC.ayr.ajY = 2;
        }
        this.dYk.j(this.aRF);
        return new com.baidu.tieba.card.a.a<>(this.dYk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        kVar.iX(i + 1);
        v.aiY().a(kVar.lf("c12190"));
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(kVar);
        aVar.ajz().b(this.dTj);
        aVar.ajz().a(this.biW);
        return aVar.getView();
    }

    private void aEx() {
        com.baidu.tieba.card.data.k.cBY = "c10705";
        com.baidu.tieba.card.data.k.cBZ = "c10730";
        com.baidu.tieba.card.data.k.cCa = "c10731";
        com.baidu.tieba.card.data.k.cCb = "c10704";
        com.baidu.tieba.card.data.k.cCc = "c10755";
        com.baidu.tieba.card.data.k.cCd = "c10710";
        com.baidu.tieba.card.data.k.cCe = "c10736";
        com.baidu.tieba.card.data.k.cCf = "c10737";
        com.baidu.tieba.card.data.k.cCg = "c10711";
        com.baidu.tieba.card.data.k.cCh = "c10758";
        com.baidu.tieba.card.data.k.cCi = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.biW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
