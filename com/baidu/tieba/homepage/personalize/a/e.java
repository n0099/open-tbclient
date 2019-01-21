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
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<r>> implements com.baidu.tieba.a.f {
    public BdUniqueId beu;
    private NEGFeedBackView.a bxP;
    private String cbl;
    private ad euc;
    private r ezn;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxP = null;
        this.euc = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aqP().dT(true);
                if (view != null && e.this.ezn != null && e.this.ezn.getView() != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    if (view.getId() != e.this.ezn.getView().getId()) {
                        if (e.this.ezn.getHeaderImg() == null || view.getId() != e.this.ezn.getHeaderImg().getId()) {
                            if (e.this.ezn.aqs() == null || view.getId() != e.this.ezn.aqs().getId()) {
                                if (e.this.ezn.cby == null || e.this.ezn.cby.getBarNameTv() == null || view.getId() != e.this.ezn.cby.getBarNameTv().getId()) {
                                    if (e.this.ezn.ccl == null || e.this.ezn.ccl.aKM == null || view.getId() != e.this.ezn.ccl.aKM.getId()) {
                                        if (e.this.ezn.aqr() == null || view.getId() != e.this.ezn.aqr().getId()) {
                                            if (e.this.ezn.cby != null && e.this.ezn.cby.getCommentContainer() != null && view.getId() == e.this.ezn.cby.getCommentContainer().getId()) {
                                                com.baidu.tieba.q.c.bCC().b(e.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aqZ(), false, null, null));
                                                return;
                                            }
                                            com.baidu.tieba.q.c.bCC().b(e.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
                                            return;
                                        }
                                        TiebaStatic.log(kVar.ng("c12202"));
                                        return;
                                    }
                                    TiebaStatic.log(kVar.arm());
                                    return;
                                }
                                TiebaStatic.log(kVar.arm());
                                return;
                            }
                            TiebaStatic.log(kVar.nf("c12191"));
                            com.baidu.tieba.q.c.bCC().b(e.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                            return;
                        }
                        TiebaStatic.log(kVar.nf("c12191"));
                        com.baidu.tieba.q.c.bCC().b(e.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqZ(), false, null, null));
                        return;
                    }
                    TiebaStatic.log(kVar.nf("c12192"));
                    com.baidu.tieba.q.c.bCC().b(e.this.beu, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqZ(), false, null, null));
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
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.ezn = new r(this.mPageContext);
        this.ezn.currentPageType = 2;
        if (this.ezn.cby != null) {
            this.ezn.cby.awp = 2;
        }
        if (this.ezn.ccl != null && this.ezn.ccl.aKN != null) {
            this.ezn.ccl.aKN.awp = 2;
        }
        this.ezn.j(this.beu);
        return new com.baidu.tieba.card.a.a<>(this.ezn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        kVar.kP(i + 1);
        v.aqP().a(kVar.ne("c12190"));
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        aVar.arr().kL(i + 1);
        aVar.arr().a(kVar);
        aVar.arr().b(this.euc);
        aVar.arr().a(this.bxP);
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
