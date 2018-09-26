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
    public BdUniqueId aUU;
    private String bNq;
    private NEGFeedBackView.a boM;
    private ad eav;
    private r efB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = null;
        this.eav = new ad<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                v.akM().dc(true);
                if (view != null && e.this.efB != null && e.this.efB.getView() != null && kVar != null && kVar.UT() != null && !StringUtils.isNull(kVar.UT().getTid())) {
                    if (view.getId() != e.this.efB.getView().getId()) {
                        if (e.this.efB.getHeaderImg() == null || view.getId() != e.this.efB.getHeaderImg().getId()) {
                            if (e.this.efB.akp() == null || view.getId() != e.this.efB.akp().getId()) {
                                if (e.this.efB.bND == null || e.this.efB.bND.getBarNameTv() == null || view.getId() != e.this.efB.bND.getBarNameTv().getId()) {
                                    if (e.this.efB.bOr == null || e.this.efB.bOr.aBk == null || view.getId() != e.this.efB.bOr.aBk.getId()) {
                                        if (e.this.efB.ako() != null && view.getId() == e.this.efB.ako().getId()) {
                                            TiebaStatic.log(kVar.lL("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.alj());
                                    return;
                                }
                                TiebaStatic.log(kVar.alj());
                                return;
                            }
                            TiebaStatic.log(kVar.lK("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.lK("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.lK("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aGJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.efB = new r(this.mPageContext);
        this.efB.currentPageType = 2;
        if (this.efB.bND != null) {
            this.efB.bND.amD = 2;
        }
        if (this.efB.bOr != null && this.efB.bOr.aBl != null) {
            this.efB.bOr.aBl.amD = 2;
        }
        this.efB.j(this.aUU);
        return new com.baidu.tieba.card.a.a<>(this.efB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (kVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        kVar.jv(i + 1);
        v.akM().a(kVar.lJ("c12190"));
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(kVar);
        aVar.aln().b(this.eav);
        aVar.aln().a(this.boM);
        return aVar.getView();
    }

    private void aGJ() {
        com.baidu.tieba.card.data.k.cHM = "c10705";
        com.baidu.tieba.card.data.k.cHN = "c10730";
        com.baidu.tieba.card.data.k.cHO = "c10731";
        com.baidu.tieba.card.data.k.cHP = "c10704";
        com.baidu.tieba.card.data.k.cHQ = "c10755";
        com.baidu.tieba.card.data.k.cHR = "c10710";
        com.baidu.tieba.card.data.k.cHS = "c10736";
        com.baidu.tieba.card.data.k.cHT = "c10737";
        com.baidu.tieba.card.data.k.cHU = "c10711";
        com.baidu.tieba.card.data.k.cHV = "c10758";
        com.baidu.tieba.card.data.k.cHW = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
