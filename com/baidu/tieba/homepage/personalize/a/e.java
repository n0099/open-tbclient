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
    public BdUniqueId aZt;
    private String bVS;
    private NEGFeedBackView.a bsM;
    private ad eio;
    private r enu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eio = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aoo().dy(true);
                if (view != null && e.this.enu != null && e.this.enu.getView() != null && kVar != null && kVar.YA() != null && !StringUtils.isNull(kVar.YA().getTid())) {
                    if (view.getId() != e.this.enu.getView().getId()) {
                        if (e.this.enu.getHeaderImg() == null || view.getId() != e.this.enu.getHeaderImg().getId()) {
                            if (e.this.enu.anR() == null || view.getId() != e.this.enu.anR().getId()) {
                                if (e.this.enu.bWf == null || e.this.enu.bWf.getBarNameTv() == null || view.getId() != e.this.enu.bWf.getBarNameTv().getId()) {
                                    if (e.this.enu.bWS == null || e.this.enu.bWS.aFR == null || view.getId() != e.this.enu.bWS.aFR.getId()) {
                                        if (e.this.enu.anQ() != null && view.getId() == e.this.enu.anQ().getId()) {
                                            TiebaStatic.log(kVar.mn("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aoL());
                                    return;
                                }
                                TiebaStatic.log(kVar.aoL());
                                return;
                            }
                            TiebaStatic.log(kVar.mm("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.mm("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.mm("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aKb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.enu = new r(this.mPageContext);
        this.enu.currentPageType = 2;
        if (this.enu.bWf != null) {
            this.enu.bWf.ary = 2;
        }
        if (this.enu.bWS != null && this.enu.bWS.aFS != null) {
            this.enu.bWS.aFS.ary = 2;
        }
        this.enu.j(this.aZt);
        return new com.baidu.tieba.card.a.a<>(this.enu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aoP() == null) {
            return null;
        }
        kVar.jT(i + 1);
        v.aoo().a(kVar.ml("c12190"));
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        aVar.aoP().a(kVar);
        aVar.aoP().b(this.eio);
        aVar.aoP().a(this.bsM);
        return aVar.getView();
    }

    private void aKb() {
        com.baidu.tieba.card.data.k.cQf = "c10705";
        com.baidu.tieba.card.data.k.cQg = "c10730";
        com.baidu.tieba.card.data.k.cQh = "c10731";
        com.baidu.tieba.card.data.k.cQi = "c10704";
        com.baidu.tieba.card.data.k.cQj = "c10755";
        com.baidu.tieba.card.data.k.cQk = "c10710";
        com.baidu.tieba.card.data.k.cQl = "c10736";
        com.baidu.tieba.card.data.k.cQm = "c10737";
        com.baidu.tieba.card.data.k.cQn = "c10711";
        com.baidu.tieba.card.data.k.cQo = "c10758";
        com.baidu.tieba.card.data.k.cQp = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
