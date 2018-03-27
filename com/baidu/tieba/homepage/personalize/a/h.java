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
    public BdUniqueId bIy;
    private c.a bOT;
    private com.baidu.tieba.card.data.k cVz;
    private int cardShowType;
    private s dKY;
    private v egm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOT = null;
        this.cardShowType = 0;
        this.egm = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVz;
                r.alt().dk(true);
                if (view != null && h.this.dKY != null && h.this.dKY.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    if (view.getId() != h.this.dKY.getView().getId()) {
                        if (h.this.dKY.getHeaderImg() == null || view.getId() != h.this.dKY.getHeaderImg().getId()) {
                            if (h.this.dKY.akS() == null || view.getId() != h.this.dKY.akS().getId()) {
                                if (h.this.dKY.cmO != null && h.this.dKY.cmO.beo != null && view.getId() == h.this.dKY.cmO.beo.getId()) {
                                    TiebaStatic.log(kVar.alM());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.alN());
                            return;
                        }
                        TiebaStatic.log(kVar.alN());
                        return;
                    }
                    TiebaStatic.log(kVar.kE("c12642"));
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
    public com.baidu.tieba.card.a.a<s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKY = new s(this.mPageContext);
        this.dKY.currentPageType = 2;
        if (this.dKY.cma != null) {
            this.dKY.cma.aQv = 2;
        }
        if (this.dKY.cmO != null && this.dKY.cmO.bep != null) {
            this.dKY.cmO.bep.aQv = 2;
        }
        if (this.dKY.cYt != null) {
            this.dKY.cYt.cYY = 2;
        }
        this.dKY.j(this.bIy);
        this.dKY.b(this.egm);
        return new com.baidu.tieba.card.a.a<>(this.dKY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<s> aVar) {
        if (kVar == null || kVar.WE() == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        this.cVz = kVar;
        kVar.lD(i + 1);
        r.alt().a(kVar.kD("c12641"));
        if (kVar.aNh != null && kVar.aNh.size() > 0) {
            kVar.WE().a(kVar.aNh);
        }
        be beVar = new be(kVar.WE());
        beVar.stType = "personalize_page";
        beVar.aQt = 1;
        beVar.aQu = 3;
        aVar.alY().a(this.bOT);
        beVar.threadData.aQp = this.cardShowType;
        aVar.alY().a(beVar);
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
