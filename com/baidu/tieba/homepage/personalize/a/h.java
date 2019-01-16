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
    public BdUniqueId bes;
    private NEGFeedBackView.a bxO;
    private com.baidu.tieba.card.data.k cVT;
    private String cbk;
    private x dTY;
    private ad eub;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxO = null;
        this.eub = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVT;
                v.aqP().dT(true);
                if (view != null && h.this.dTY != null && h.this.dTY.getView() != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    if (view.getId() != h.this.dTY.getView().getId()) {
                        if (h.this.dTY.getHeaderImg() == null || view.getId() != h.this.dTY.getHeaderImg().getId()) {
                            if (h.this.dTY.aqs() == null || view.getId() != h.this.dTY.aqs().getId()) {
                                if (h.this.dTY.cck != null && h.this.dTY.cck.aKL != null && view.getId() == h.this.dTY.cck.aKL.getId()) {
                                    TiebaStatic.log(kVar.arm());
                                    return;
                                }
                                com.baidu.tieba.q.c.bCC().b(h.this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
                                return;
                            }
                            TiebaStatic.log(kVar.arn());
                            com.baidu.tieba.q.c.bCC().b(h.this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                            return;
                        }
                        TiebaStatic.log(kVar.arn());
                        com.baidu.tieba.q.c.bCC().b(h.this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                        return;
                    }
                    TiebaStatic.log(kVar.ni("c12642"));
                    com.baidu.tieba.q.c.bCC().b(h.this.bes, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
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
        this.dTY = new x(this.mPageContext);
        this.dTY.currentPageType = 2;
        if (this.dTY.cbx != null) {
            this.dTY.cbx.awo = 2;
        }
        if (this.dTY.cck != null && this.dTY.cck.aKM != null) {
            this.dTY.cck.aKM.awo = 2;
        }
        if (this.dTY.cZM != null) {
            this.dTY.cZM.daB = 2;
        }
        this.dTY.j(this.bes);
        this.dTY.b(this.eub);
        return new com.baidu.tieba.card.a.a<>(this.dTY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.aaq() == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        this.cVT = kVar;
        kVar.kP(i + 1);
        v.aqP().a(kVar.nh("c12641"));
        if (kVar.asE != null && kVar.asE.size() > 0) {
            kVar.aaq().a(kVar.asE);
        }
        bc bcVar = new bc(kVar.aaq());
        bcVar.stType = "personalize_page";
        bcVar.awm = 1;
        bcVar.awn = 3;
        bcVar.awp = 1;
        aVar.arr().a(this.bxO);
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().kL(i + 1);
        aVar.arr().a(bcVar);
        com.baidu.tieba.q.c.bCC().a(this.bes, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aqZ(), false, null, null));
        return aVar.getView();
    }

    private void aME() {
        com.baidu.tieba.card.data.k.dbv = "c10705";
        com.baidu.tieba.card.data.k.dbw = "c10730";
        com.baidu.tieba.card.data.k.dbx = "c10731";
        com.baidu.tieba.card.data.k.dby = "c10704";
        com.baidu.tieba.card.data.k.dbz = "c10755";
        com.baidu.tieba.card.data.k.dbA = "c10710";
        com.baidu.tieba.card.data.k.dbB = "c10736";
        com.baidu.tieba.card.data.k.dbC = "c10737";
        com.baidu.tieba.card.data.k.dbD = "c10711";
        com.baidu.tieba.card.data.k.dbE = "c10758";
        com.baidu.tieba.card.data.k.dbF = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
