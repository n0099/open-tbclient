package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<n>> {
    public BdUniqueId bIv;
    private c.a bOQ;
    private int cardShowType;
    private v efW;
    private n ejE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOQ = null;
        this.cardShowType = 0;
        this.efW = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                r.als().dk(true);
                if (view != null && e.this.ejE != null && e.this.ejE.getView() != null && kVar != null && kVar.WD() != null && !StringUtils.isNull(kVar.WD().getTid())) {
                    if (view.getId() != e.this.ejE.getView().getId()) {
                        if (e.this.ejE.getHeaderImg() == null || view.getId() != e.this.ejE.getHeaderImg().getId()) {
                            if (e.this.ejE.akR() == null || view.getId() != e.this.ejE.akR().getId()) {
                                if (e.this.ejE.clX == null || e.this.ejE.clX.getBarNameTv() == null || view.getId() != e.this.ejE.clX.getBarNameTv().getId()) {
                                    if (e.this.ejE.cmL == null || e.this.ejE.cmL.bel == null || view.getId() != e.this.ejE.cmL.bel.getId()) {
                                        if (e.this.ejE.akQ() != null && view.getId() == e.this.ejE.akQ().getId()) {
                                            TiebaStatic.log(kVar.kC("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.alL());
                                    return;
                                }
                                TiebaStatic.log(kVar.alL());
                                return;
                            }
                            TiebaStatic.log(kVar.kB("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.kB("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.kB("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDa();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<n> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejE = new n(this.mPageContext);
        this.ejE.currentPageType = 2;
        if (this.ejE.clX != null) {
            this.ejE.clX.aQt = 2;
        }
        if (this.ejE.cmL != null && this.ejE.cmL.bem != null) {
            this.ejE.cmL.bem.aQt = 2;
        }
        this.ejE.j(this.bIv);
        return new com.baidu.tieba.card.a.a<>(this.ejE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<n> aVar) {
        if (kVar == null || aVar == null || aVar.alX() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.als().a(kVar.kA("c12190"));
        if (kVar.threadData != null) {
            kVar.threadData.aQo = this.cardShowType;
        }
        aVar.alX().a(kVar);
        aVar.alX().b(this.efW);
        aVar.alX().a(this.bOQ);
        return aVar.getView();
    }

    private void aDa() {
        com.baidu.tieba.card.data.k.cZM = "c10705";
        com.baidu.tieba.card.data.k.cZN = "c10730";
        com.baidu.tieba.card.data.k.cZO = "c10731";
        com.baidu.tieba.card.data.k.cZP = "c10704";
        com.baidu.tieba.card.data.k.cZQ = "c10755";
        com.baidu.tieba.card.data.k.cZR = "c10710";
        com.baidu.tieba.card.data.k.cZS = "c10736";
        com.baidu.tieba.card.data.k.cZT = "c10737";
        com.baidu.tieba.card.data.k.cZU = "c10711";
        com.baidu.tieba.card.data.k.cZV = "c10758";
        com.baidu.tieba.card.data.k.cZW = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bOQ = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
