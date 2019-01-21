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
/* loaded from: classes6.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId beu;
    private NEGFeedBackView.a bxP;
    private com.baidu.tieba.card.data.k cVU;
    private String cbl;
    private x dTZ;
    private ad euc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxP = null;
        this.euc = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVU;
                v.aqP().dT(true);
                if (view != null && h.this.dTZ != null && h.this.dTZ.getView() != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    if (view.getId() != h.this.dTZ.getView().getId()) {
                        if (h.this.dTZ.getHeaderImg() == null || view.getId() != h.this.dTZ.getHeaderImg().getId()) {
                            if (h.this.dTZ.aqs() == null || view.getId() != h.this.dTZ.aqs().getId()) {
                                if (h.this.dTZ.ccl != null && h.this.dTZ.ccl.aKM != null && view.getId() == h.this.dTZ.ccl.aKM.getId()) {
                                    TiebaStatic.log(kVar.arm());
                                    return;
                                }
                                com.baidu.tieba.q.c.bCC().b(h.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
                                return;
                            }
                            TiebaStatic.log(kVar.arn());
                            com.baidu.tieba.q.c.bCC().b(h.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                            return;
                        }
                        TiebaStatic.log(kVar.arn());
                        com.baidu.tieba.q.c.bCC().b(h.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                        return;
                    }
                    TiebaStatic.log(kVar.ni("c12642"));
                    com.baidu.tieba.q.c.bCC().b(h.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aME();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTZ = new x(this.mPageContext);
        this.dTZ.currentPageType = 2;
        if (this.dTZ.cby != null) {
            this.dTZ.cby.awp = 2;
        }
        if (this.dTZ.ccl != null && this.dTZ.ccl.aKN != null) {
            this.dTZ.ccl.aKN.awp = 2;
        }
        if (this.dTZ.cZN != null) {
            this.dTZ.cZN.daC = 2;
        }
        this.dTZ.j(this.beu);
        this.dTZ.b(this.euc);
        return new com.baidu.tieba.card.a.a<>(this.dTZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.aaq() == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        this.cVU = kVar;
        kVar.kP(i + 1);
        v.aqP().a(kVar.nh("c12641"));
        if (kVar.asF != null && kVar.asF.size() > 0) {
            kVar.aaq().a(kVar.asF);
        }
        bc bcVar = new bc(kVar.aaq());
        bcVar.stType = "personalize_page";
        bcVar.awn = 1;
        bcVar.awo = 3;
        bcVar.awq = 1;
        aVar.arr().a(this.bxP);
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        aVar.arr().kL(i + 1);
        aVar.arr().a(bcVar);
        com.baidu.tieba.q.c.bCC().a(this.beu, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aqZ(), false, null, null));
        return aVar.getView();
    }

    private void aME() {
        com.baidu.tieba.card.data.k.dbw = "c10705";
        com.baidu.tieba.card.data.k.dbx = "c10730";
        com.baidu.tieba.card.data.k.dby = "c10731";
        com.baidu.tieba.card.data.k.dbz = "c10704";
        com.baidu.tieba.card.data.k.dbA = "c10755";
        com.baidu.tieba.card.data.k.dbB = "c10710";
        com.baidu.tieba.card.data.k.dbC = "c10736";
        com.baidu.tieba.card.data.k.dbD = "c10737";
        com.baidu.tieba.card.data.k.dbE = "c10711";
        com.baidu.tieba.card.data.k.dbF = "c10758";
        com.baidu.tieba.card.data.k.dbG = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxP = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }
}
