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
    public BdUniqueId bIy;
    private c.a bOT;
    private int cardShowType;
    private v egm;
    private n ejU;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOT = null;
        this.cardShowType = 0;
        this.egm = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                r.alt().dk(true);
                if (view != null && e.this.ejU != null && e.this.ejU.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    if (view.getId() != e.this.ejU.getView().getId()) {
                        if (e.this.ejU.getHeaderImg() == null || view.getId() != e.this.ejU.getHeaderImg().getId()) {
                            if (e.this.ejU.akS() == null || view.getId() != e.this.ejU.akS().getId()) {
                                if (e.this.ejU.cma == null || e.this.ejU.cma.getBarNameTv() == null || view.getId() != e.this.ejU.cma.getBarNameTv().getId()) {
                                    if (e.this.ejU.cmO == null || e.this.ejU.cmO.beo == null || view.getId() != e.this.ejU.cmO.beo.getId()) {
                                        if (e.this.ejU.akR() != null && view.getId() == e.this.ejU.akR().getId()) {
                                            TiebaStatic.log(kVar.kC("c12202"));
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
        aDb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<n> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejU = new n(this.mPageContext);
        this.ejU.currentPageType = 2;
        if (this.ejU.cma != null) {
            this.ejU.cma.aQv = 2;
        }
        if (this.ejU.cmO != null && this.ejU.cmO.bep != null) {
            this.ejU.cmO.bep.aQv = 2;
        }
        this.ejU.j(this.bIy);
        return new com.baidu.tieba.card.a.a<>(this.ejU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<n> aVar) {
        if (kVar == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.alt().a(kVar.kA("c12190"));
        if (kVar.threadData != null) {
            kVar.threadData.aQp = this.cardShowType;
        }
        aVar.alY().a(kVar);
        aVar.alY().b(this.egm);
        aVar.alY().a(this.bOT);
        return aVar.getView();
    }

    private void aDb() {
        com.baidu.tieba.card.data.k.cZP = "c10705";
        com.baidu.tieba.card.data.k.cZQ = "c10730";
        com.baidu.tieba.card.data.k.cZR = "c10731";
        com.baidu.tieba.card.data.k.cZS = "c10704";
        com.baidu.tieba.card.data.k.cZT = "c10755";
        com.baidu.tieba.card.data.k.cZU = "c10710";
        com.baidu.tieba.card.data.k.cZV = "c10736";
        com.baidu.tieba.card.data.k.cZW = "c10737";
        com.baidu.tieba.card.data.k.cZX = "c10711";
        com.baidu.tieba.card.data.k.cZY = "c10758";
        com.baidu.tieba.card.data.k.cZZ = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bOT = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
