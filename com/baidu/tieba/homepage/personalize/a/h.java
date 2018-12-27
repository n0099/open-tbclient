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
    public BdUniqueId bdH;
    private NEGFeedBackView.a bxa;
    private com.baidu.tieba.card.data.k cVi;
    private String caz;
    private x dTs;
    private ad etv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxa = null;
        this.etv = new ad<bc>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVi;
                v.aqs().dQ(true);
                if (view != null && h.this.dTs != null && h.this.dTs.getView() != null && kVar != null && kVar.ZT() != null && !StringUtils.isNull(kVar.ZT().getTid())) {
                    if (view.getId() != h.this.dTs.getView().getId()) {
                        if (h.this.dTs.getHeaderImg() == null || view.getId() != h.this.dTs.getHeaderImg().getId()) {
                            if (h.this.dTs.apV() == null || view.getId() != h.this.dTs.apV().getId()) {
                                if (h.this.dTs.cbz != null && h.this.dTs.cbz.aKj != null && view.getId() == h.this.dTs.cbz.aKj.getId()) {
                                    TiebaStatic.log(kVar.aqP());
                                    return;
                                }
                                com.baidu.tieba.q.c.bBT().b(h.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
                                return;
                            }
                            TiebaStatic.log(kVar.aqQ());
                            com.baidu.tieba.q.c.bBT().b(h.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
                            return;
                        }
                        TiebaStatic.log(kVar.aqQ());
                        com.baidu.tieba.q.c.bBT().b(h.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
                        return;
                    }
                    TiebaStatic.log(kVar.mS("c12642"));
                    com.baidu.tieba.q.c.bBT().b(h.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aMe();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTs = new x(this.mPageContext);
        this.dTs.currentPageType = 2;
        if (this.dTs.caM != null) {
            this.dTs.caM.avM = 2;
        }
        if (this.dTs.cbz != null && this.dTs.cbz.aKk != null) {
            this.dTs.cbz.aKk.avM = 2;
        }
        if (this.dTs.cZb != null) {
            this.dTs.cZb.cZO = 2;
        }
        this.dTs.j(this.bdH);
        this.dTs.b(this.etv);
        return new com.baidu.tieba.card.a.a<>(this.dTs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || kVar.ZT() == null || aVar == null || aVar.aqT() == null) {
            return null;
        }
        this.cVi = kVar;
        kVar.kP(i + 1);
        v.aqs().a(kVar.mR("c12641"));
        if (kVar.asc != null && kVar.asc.size() > 0) {
            kVar.ZT().a(kVar.asc);
        }
        bc bcVar = new bc(kVar.ZT());
        bcVar.stType = "personalize_page";
        bcVar.avK = 1;
        bcVar.avL = 3;
        bcVar.avN = 1;
        aVar.aqT().a(this.bxa);
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().kL(i + 1);
        aVar.aqT().a(bcVar);
        com.baidu.tieba.q.c.bBT().a(this.bdH, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aqC(), false, null, null));
        return aVar.getView();
    }

    private void aMe() {
        com.baidu.tieba.card.data.k.daK = "c10705";
        com.baidu.tieba.card.data.k.daL = "c10730";
        com.baidu.tieba.card.data.k.daM = "c10731";
        com.baidu.tieba.card.data.k.daN = "c10704";
        com.baidu.tieba.card.data.k.daO = "c10755";
        com.baidu.tieba.card.data.k.daP = "c10710";
        com.baidu.tieba.card.data.k.daQ = "c10736";
        com.baidu.tieba.card.data.k.daR = "c10737";
        com.baidu.tieba.card.data.k.daS = "c10711";
        com.baidu.tieba.card.data.k.daT = "c10758";
        com.baidu.tieba.card.data.k.daU = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxa = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
