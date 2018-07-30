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
    public BdUniqueId aRF;
    private String bHB;
    private NEGFeedBackView.a biW;
    private com.baidu.tieba.card.data.k cwx;
    private ad dTj;
    private x duq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.biW = null;
        this.dTj = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cwx;
                v.aiY().cK(true);
                if (view != null && h.this.duq != null && h.this.duq.getView() != null && kVar != null && kVar.Td() != null && !StringUtils.isNull(kVar.Td().getTid())) {
                    if (view.getId() != h.this.duq.getView().getId()) {
                        if (h.this.duq.getHeaderImg() == null || view.getId() != h.this.duq.getHeaderImg().getId()) {
                            if (h.this.duq.aiC() == null || view.getId() != h.this.duq.aiC().getId()) {
                                if (h.this.duq.bIC != null && h.this.duq.bIC.ayq != null && view.getId() == h.this.duq.bIC.ayq.getId()) {
                                    TiebaStatic.log(kVar.ajv());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.ajw());
                            return;
                        }
                        TiebaStatic.log(kVar.ajw());
                        return;
                    }
                    TiebaStatic.log(kVar.lj("c12642"));
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
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.duq = new x(this.mPageContext);
        this.duq.currentPageType = 2;
        if (this.duq.bHO != null) {
            this.duq.bHO.ajY = 2;
        }
        if (this.duq.bIC != null && this.duq.bIC.ayr != null) {
            this.duq.bIC.ayr.ajY = 2;
        }
        if (this.duq.cAp != null) {
            this.duq.cAp.cBc = 2;
        }
        this.duq.j(this.aRF);
        this.duq.b(this.dTj);
        return new com.baidu.tieba.card.a.a<>(this.duq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Td() == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        this.cwx = kVar;
        kVar.iX(i + 1);
        v.aiY().a(kVar.li("c12641"));
        if (kVar.agt != null && kVar.agt.size() > 0) {
            kVar.Td().a(kVar.agt);
        }
        bc bcVar = new bc(kVar.Td());
        bcVar.stType = "personalize_page";
        bcVar.ajW = 1;
        bcVar.ajX = 3;
        aVar.ajz().a(this.biW);
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(bcVar);
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
