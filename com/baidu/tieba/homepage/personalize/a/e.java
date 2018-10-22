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
    private ad eip;
    private r env;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eip = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.aop().dy(true);
                if (view != null && e.this.env != null && e.this.env.getView() != null && kVar != null && kVar.YB() != null && !StringUtils.isNull(kVar.YB().getTid())) {
                    if (view.getId() != e.this.env.getView().getId()) {
                        if (e.this.env.getHeaderImg() == null || view.getId() != e.this.env.getHeaderImg().getId()) {
                            if (e.this.env.anS() == null || view.getId() != e.this.env.anS().getId()) {
                                if (e.this.env.bWf == null || e.this.env.bWf.getBarNameTv() == null || view.getId() != e.this.env.bWf.getBarNameTv().getId()) {
                                    if (e.this.env.bWS == null || e.this.env.bWS.aFR == null || view.getId() != e.this.env.bWS.aFR.getId()) {
                                        if (e.this.env.anR() != null && view.getId() == e.this.env.anR().getId()) {
                                            TiebaStatic.log(kVar.mn("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.aoM());
                                    return;
                                }
                                TiebaStatic.log(kVar.aoM());
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
        this.env = new r(this.mPageContext);
        this.env.currentPageType = 2;
        if (this.env.bWf != null) {
            this.env.bWf.ary = 2;
        }
        if (this.env.bWS != null && this.env.bWS.aFS != null) {
            this.env.bWS.aFS.ary = 2;
        }
        this.env.j(this.aZt);
        return new com.baidu.tieba.card.a.a<>(this.env);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aoQ() == null) {
            return null;
        }
        kVar.jT(i + 1);
        v.aop().a(kVar.ml("c12190"));
        if (aVar.aoQ() instanceof com.baidu.tieba.a.e) {
            aVar.aoQ().setPage(this.bVS);
        }
        aVar.aoQ().a(kVar);
        aVar.aoQ().b(this.eip);
        aVar.aoQ().a(this.bsM);
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
