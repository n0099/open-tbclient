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
    public BdUniqueId aRC;
    private String bHB;
    private NEGFeedBackView.a bjc;
    private com.baidu.tieba.card.data.k cwu;
    private ad dTe;
    private x dun;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjc = null;
        this.dTe = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cwu;
                v.ajb().cL(true);
                if (view != null && h.this.dun != null && h.this.dun.getView() != null && kVar != null && kVar.Tg() != null && !StringUtils.isNull(kVar.Tg().getTid())) {
                    if (view.getId() != h.this.dun.getView().getId()) {
                        if (h.this.dun.getHeaderImg() == null || view.getId() != h.this.dun.getHeaderImg().getId()) {
                            if (h.this.dun.aiF() == null || view.getId() != h.this.dun.aiF().getId()) {
                                if (h.this.dun.bIC != null && h.this.dun.bIC.ayn != null && view.getId() == h.this.dun.bIC.ayn.getId()) {
                                    TiebaStatic.log(kVar.ajy());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.ajz());
                            return;
                        }
                        TiebaStatic.log(kVar.ajz());
                        return;
                    }
                    TiebaStatic.log(kVar.ll("c12642"));
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
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dun = new x(this.mPageContext);
        this.dun.currentPageType = 2;
        if (this.dun.bHO != null) {
            this.dun.bHO.ajY = 2;
        }
        if (this.dun.bIC != null && this.dun.bIC.ayo != null) {
            this.dun.bIC.ayo.ajY = 2;
        }
        if (this.dun.cAm != null) {
            this.dun.cAm.cAZ = 2;
        }
        this.dun.j(this.aRC);
        this.dun.b(this.dTe);
        return new com.baidu.tieba.card.a.a<>(this.dun);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.Tg() == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        this.cwu = kVar;
        kVar.iW(i + 1);
        v.ajb().a(kVar.lk("c12641"));
        if (kVar.agt != null && kVar.agt.size() > 0) {
            kVar.Tg().a(kVar.agt);
        }
        bc bcVar = new bc(kVar.Tg());
        bcVar.stType = "personalize_page";
        bcVar.ajW = 1;
        bcVar.ajX = 3;
        aVar.ajC().a(this.bjc);
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(bcVar);
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
