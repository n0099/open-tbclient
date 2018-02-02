package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<o>> {
    public BdUniqueId bGE;
    private c.a bMW;
    private int cardShowType;
    private v ebW;
    private o efE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.cardShowType = 0;
        this.ebW = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                s.akK().dg(true);
                if (view != null && e.this.efE != null && e.this.efE.getView() != null && lVar != null && lVar.VM() != null && !StringUtils.isNull(lVar.VM().getTid())) {
                    if (view.getId() != e.this.efE.getView().getId()) {
                        if (e.this.efE.getHeaderImg() == null || view.getId() != e.this.efE.getHeaderImg().getId()) {
                            if (e.this.efE.akj() == null || view.getId() != e.this.efE.akj().getId()) {
                                if (e.this.efE.ciT == null || e.this.efE.ciT.getBarNameTv() == null || view.getId() != e.this.efE.ciT.getBarNameTv().getId()) {
                                    if (e.this.efE.cSM == null || e.this.efE.cSM.bcH == null || view.getId() != e.this.efE.cSM.bcH.getId()) {
                                        if (e.this.efE.aki() != null && view.getId() == e.this.efE.aki().getId()) {
                                            TiebaStatic.log(lVar.kv("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(lVar.ald());
                                    return;
                                }
                                TiebaStatic.log(lVar.ald());
                                return;
                            }
                            TiebaStatic.log(lVar.ku("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.ku("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.ku("c12192"));
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
    public com.baidu.tieba.card.a.a<o> onCreateViewHolder(ViewGroup viewGroup) {
        this.efE = new o(this.mPageContext);
        this.efE.currentPageType = 2;
        if (this.efE.ciT != null) {
            this.efE.ciT.bbX = 2;
        }
        if (this.efE.cSM != null && this.efE.cSM.bcI != null) {
            this.efE.cSM.bcI.bbX = 2;
        }
        this.efE.j(this.bGE);
        return new com.baidu.tieba.card.a.a<>(this.efE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.alp() == null) {
            return null;
        }
        lVar.lH(i + 1);
        s.akK().a(lVar.kt("c12190"));
        if (lVar.threadData != null) {
            lVar.threadData.aPd = this.cardShowType;
        }
        aVar.alp().a(lVar);
        aVar.alp().b(this.ebW);
        aVar.alp().a(this.bMW);
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
