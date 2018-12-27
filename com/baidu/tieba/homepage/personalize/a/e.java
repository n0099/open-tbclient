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
    public BdUniqueId bdH;
    private NEGFeedBackView.a bxa;
    private String caz;
    private ad etv;
    private r eyC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxa = null;
        this.etv = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aqs().dQ(true);
                if (view != null && e.this.eyC != null && e.this.eyC.getView() != null && kVar != null && kVar.ZT() != null && !StringUtils.isNull(kVar.ZT().getTid())) {
                    if (view.getId() != e.this.eyC.getView().getId()) {
                        if (e.this.eyC.getHeaderImg() == null || view.getId() != e.this.eyC.getHeaderImg().getId()) {
                            if (e.this.eyC.apV() == null || view.getId() != e.this.eyC.apV().getId()) {
                                if (e.this.eyC.caM == null || e.this.eyC.caM.getBarNameTv() == null || view.getId() != e.this.eyC.caM.getBarNameTv().getId()) {
                                    if (e.this.eyC.cbz == null || e.this.eyC.cbz.aKj == null || view.getId() != e.this.eyC.cbz.aKj.getId()) {
                                        if (e.this.eyC.apU() == null || view.getId() != e.this.eyC.apU().getId()) {
                                            if (e.this.eyC.caM != null && e.this.eyC.caM.getCommentContainer() != null && view.getId() == e.this.eyC.caM.getCommentContainer().getId()) {
                                                com.baidu.tieba.q.c.bBT().b(e.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 5, kVar.aqC(), false, null, null));
                                                return;
                                            }
                                            com.baidu.tieba.q.c.bBT().b(e.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
                                            return;
                                        }
                                        TiebaStatic.log(kVar.mQ("c12202"));
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aqP());
                                    return;
                                }
                                TiebaStatic.log(kVar.aqP());
                                return;
                            }
                            TiebaStatic.log(kVar.mP("c12191"));
                            com.baidu.tieba.q.c.bBT().b(e.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
                            return;
                        }
                        TiebaStatic.log(kVar.mP("c12191"));
                        com.baidu.tieba.q.c.bBT().b(e.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aqC(), false, null, null));
                        return;
                    }
                    TiebaStatic.log(kVar.mP("c12192"));
                    com.baidu.tieba.q.c.bBT().b(e.this.bdH, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aqC(), false, null, null));
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
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.eyC = new r(this.mPageContext);
        this.eyC.currentPageType = 2;
        if (this.eyC.caM != null) {
            this.eyC.caM.avM = 2;
        }
        if (this.eyC.cbz != null && this.eyC.cbz.aKk != null) {
            this.eyC.cbz.aKk.avM = 2;
        }
        this.eyC.j(this.bdH);
        return new com.baidu.tieba.card.a.a<>(this.eyC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aqT() == null) {
            return null;
        }
        kVar.kP(i + 1);
        v.aqs().a(kVar.mO("c12190"));
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().kL(i + 1);
        aVar.aqT().a(kVar);
        aVar.aqT().b(this.etv);
        aVar.aqT().a(this.bxa);
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
