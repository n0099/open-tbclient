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
    public BdUniqueId bGw;
    private c.a bMO;
    private com.baidu.tieba.card.data.l cSs;
    private int cardShowType;
    private t dHJ;
    private v ebB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.cardShowType = 0;
        this.ebB = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.l lVar = h.this.cSs;
                s.akF().de(true);
                if (view != null && h.this.dHJ != null && h.this.dHJ.getView() != null && lVar != null && lVar.VK() != null && !StringUtils.isNull(lVar.VK().getTid())) {
                    if (view.getId() != h.this.dHJ.getView().getId()) {
                        if (h.this.dHJ.getHeaderImg() == null || view.getId() != h.this.dHJ.getHeaderImg().getId()) {
                            if (h.this.dHJ.ake() == null || view.getId() != h.this.dHJ.ake().getId()) {
                                if (h.this.dHJ.cSr != null && h.this.dHJ.cSr.bcz != null && view.getId() == h.this.dHJ.cSr.bcz.getId()) {
                                    TiebaStatic.log(lVar.akY());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.akZ());
                            return;
                        }
                        TiebaStatic.log(lVar.akZ());
                        return;
                    }
                    TiebaStatic.log(lVar.kp("c12642"));
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
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dHJ = new t(this.mPageContext);
        this.dHJ.currentPageType = 2;
        if (this.dHJ.ciL != null) {
            this.dHJ.ciL.bbP = 2;
        }
        if (this.dHJ.cSr != null && this.dHJ.cSr.bcA != null) {
            this.dHJ.cSr.bcA.bbP = 2;
        }
        if (this.dHJ.cVw != null) {
            this.dHJ.cVw.cVZ = 2;
        }
        this.dHJ.j(this.bGw);
        this.dHJ.b(this.ebB);
        return new com.baidu.tieba.card.a.a<>(this.dHJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.VK() == null || aVar == null || aVar.alk() == null) {
            return null;
        }
        this.cSs = lVar;
        lVar.lH(i + 1);
        s.akF().a(lVar.ko("c12641"));
        if (lVar.aLV != null && lVar.aLV.size() > 0) {
            lVar.VK().a(lVar.aLV);
        }
        be beVar = new be(lVar.VK());
        beVar.stType = "personalize_page";
        beVar.aPd = 1;
        beVar.aPe = 3;
        aVar.alk().a(this.bMO);
        beVar.threadData.aPa = this.cardShowType;
        aVar.alk().a(beVar);
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
