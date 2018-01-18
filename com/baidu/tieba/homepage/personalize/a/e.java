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
    public BdUniqueId bGw;
    private c.a bMO;
    private int cardShowType;
    private v ebB;
    private o efj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.cardShowType = 0;
        this.ebB = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                s.akF().de(true);
                if (view != null && e.this.efj != null && e.this.efj.getView() != null && lVar != null && lVar.VK() != null && !StringUtils.isNull(lVar.VK().getTid())) {
                    if (view.getId() != e.this.efj.getView().getId()) {
                        if (e.this.efj.getHeaderImg() == null || view.getId() != e.this.efj.getHeaderImg().getId()) {
                            if (e.this.efj.ake() == null || view.getId() != e.this.efj.ake().getId()) {
                                if (e.this.efj.ciL == null || e.this.efj.ciL.getBarNameTv() == null || view.getId() != e.this.efj.ciL.getBarNameTv().getId()) {
                                    if (e.this.efj.cSr == null || e.this.efj.cSr.bcz == null || view.getId() != e.this.efj.cSr.bcz.getId()) {
                                        if (e.this.efj.akd() != null && view.getId() == e.this.efj.akd().getId()) {
                                            TiebaStatic.log(lVar.kn("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(lVar.akY());
                                    return;
                                }
                                TiebaStatic.log(lVar.akY());
                                return;
                            }
                            TiebaStatic.log(lVar.km("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.km("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.km("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBC();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<o> onCreateViewHolder(ViewGroup viewGroup) {
        this.efj = new o(this.mPageContext);
        this.efj.currentPageType = 2;
        if (this.efj.ciL != null) {
            this.efj.ciL.bbP = 2;
        }
        if (this.efj.cSr != null && this.efj.cSr.bcA != null) {
            this.efj.cSr.bcA.bbP = 2;
        }
        this.efj.j(this.bGw);
        return new com.baidu.tieba.card.a.a<>(this.efj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.alk() == null) {
            return null;
        }
        lVar.lH(i + 1);
        s.akF().a(lVar.kl("c12190"));
        if (lVar.threadData != null) {
            lVar.threadData.aPa = this.cardShowType;
        }
        aVar.alk().a(lVar);
        aVar.alk().b(this.ebB);
        aVar.alk().a(this.bMO);
        return aVar.getView();
    }

    private void aBC() {
        com.baidu.tieba.card.data.l.cWQ = "c10705";
        com.baidu.tieba.card.data.l.cWR = "c10730";
        com.baidu.tieba.card.data.l.cWS = "c10731";
        com.baidu.tieba.card.data.l.cWT = "c10704";
        com.baidu.tieba.card.data.l.cWU = "c10755";
        com.baidu.tieba.card.data.l.cWV = "c10710";
        com.baidu.tieba.card.data.l.cWW = "c10736";
        com.baidu.tieba.card.data.l.cWX = "c10737";
        com.baidu.tieba.card.data.l.cWY = "c10711";
        com.baidu.tieba.card.data.l.cWZ = "c10758";
        com.baidu.tieba.card.data.l.cXa = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
