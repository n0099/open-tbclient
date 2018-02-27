package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<s>> {
    public BdUniqueId bIv;
    private c.a bOQ;
    private com.baidu.tieba.card.data.k cVw;
    private int cardShowType;
    private s dKT;
    private v efW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOQ = null;
        this.cardShowType = 0;
        this.efW = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVw;
                r.als().dk(true);
                if (view != null && h.this.dKT != null && h.this.dKT.getView() != null && kVar != null && kVar.WD() != null && !StringUtils.isNull(kVar.WD().getTid())) {
                    if (view.getId() != h.this.dKT.getView().getId()) {
                        if (h.this.dKT.getHeaderImg() == null || view.getId() != h.this.dKT.getHeaderImg().getId()) {
                            if (h.this.dKT.akR() == null || view.getId() != h.this.dKT.akR().getId()) {
                                if (h.this.dKT.cmL != null && h.this.dKT.cmL.bel != null && view.getId() == h.this.dKT.cmL.bel.getId()) {
                                    TiebaStatic.log(kVar.alL());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.alM());
                            return;
                        }
                        TiebaStatic.log(kVar.alM());
                        return;
                    }
                    TiebaStatic.log(kVar.kE("c12642"));
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
    public com.baidu.tieba.card.a.a<s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKT = new s(this.mPageContext);
        this.dKT.currentPageType = 2;
        if (this.dKT.clX != null) {
            this.dKT.clX.aQt = 2;
        }
        if (this.dKT.cmL != null && this.dKT.cmL.bem != null) {
            this.dKT.cmL.bem.aQt = 2;
        }
        if (this.dKT.cYq != null) {
            this.dKT.cYq.cYV = 2;
        }
        this.dKT.j(this.bIv);
        this.dKT.b(this.efW);
        return new com.baidu.tieba.card.a.a<>(this.dKT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<s> aVar) {
        if (kVar == null || kVar.WD() == null || aVar == null || aVar.alX() == null) {
            return null;
        }
        this.cVw = kVar;
        kVar.lD(i + 1);
        r.als().a(kVar.kD("c12641"));
        if (kVar.aNg != null && kVar.aNg.size() > 0) {
            kVar.WD().a(kVar.aNg);
        }
        be beVar = new be(kVar.WD());
        beVar.stType = "personalize_page";
        beVar.aQr = 1;
        beVar.aQs = 3;
        aVar.alX().a(this.bOQ);
        beVar.threadData.aQo = this.cardShowType;
        aVar.alX().a(beVar);
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
