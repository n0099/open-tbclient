package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId bGE;
    private c.a bMW;
    private com.baidu.tieba.card.data.l cSN;
    private int cardShowType;
    private t dIe;
    private v ebW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.cardShowType = 0;
        this.ebW = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.l lVar = h.this.cSN;
                s.akK().df(true);
                if (view != null && h.this.dIe != null && h.this.dIe.getView() != null && lVar != null && lVar.VM() != null && !StringUtils.isNull(lVar.VM().getTid())) {
                    if (view.getId() != h.this.dIe.getView().getId()) {
                        if (h.this.dIe.getHeaderImg() == null || view.getId() != h.this.dIe.getHeaderImg().getId()) {
                            if (h.this.dIe.akj() == null || view.getId() != h.this.dIe.akj().getId()) {
                                if (h.this.dIe.cSM != null && h.this.dIe.cSM.bcH != null && view.getId() == h.this.dIe.cSM.bcH.getId()) {
                                    TiebaStatic.log(lVar.ald());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.ale());
                            return;
                        }
                        TiebaStatic.log(lVar.ale());
                        return;
                    }
                    TiebaStatic.log(lVar.kw("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBH();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIe = new t(this.mPageContext);
        this.dIe.currentPageType = 2;
        if (this.dIe.ciT != null) {
            this.dIe.ciT.bbX = 2;
        }
        if (this.dIe.cSM != null && this.dIe.cSM.bcI != null) {
            this.dIe.cSM.bcI.bbX = 2;
        }
        if (this.dIe.cVR != null) {
            this.dIe.cVR.cWu = 2;
        }
        this.dIe.j(this.bGE);
        this.dIe.b(this.ebW);
        return new com.baidu.tieba.card.a.a<>(this.dIe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.VM() == null || aVar == null || aVar.alp() == null) {
            return null;
        }
        this.cSN = lVar;
        lVar.lH(i + 1);
        s.akK().a(lVar.kv("c12641"));
        if (lVar.aLY != null && lVar.aLY.size() > 0) {
            lVar.VM().a(lVar.aLY);
        }
        be beVar = new be(lVar.VM());
        beVar.stType = "personalize_page";
        beVar.aPg = 1;
        beVar.aPh = 3;
        aVar.alp().a(this.bMW);
        beVar.threadData.aPd = this.cardShowType;
        aVar.alp().a(beVar);
        return aVar.getView();
    }

    private void aBH() {
        com.baidu.tieba.card.data.l.cXl = "c10705";
        com.baidu.tieba.card.data.l.cXm = "c10730";
        com.baidu.tieba.card.data.l.cXn = "c10731";
        com.baidu.tieba.card.data.l.cXo = "c10704";
        com.baidu.tieba.card.data.l.cXp = "c10755";
        com.baidu.tieba.card.data.l.cXq = "c10710";
        com.baidu.tieba.card.data.l.cXr = "c10736";
        com.baidu.tieba.card.data.l.cXs = "c10737";
        com.baidu.tieba.card.data.l.cXt = "c10711";
        com.baidu.tieba.card.data.l.cXu = "c10758";
        com.baidu.tieba.card.data.l.cXv = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
