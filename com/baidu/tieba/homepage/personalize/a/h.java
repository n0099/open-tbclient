package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId bGo;
    private c.a bMG;
    private l cNR;
    private t dDi;
    private v ear;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.ear = new v<bf>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bf bfVar) {
                l lVar = h.this.cNR;
                s.ajC().df(true);
                if (view != null && h.this.dDi != null && h.this.dDi.getView() != null && lVar != null && lVar.VW() != null && !StringUtils.isNull(lVar.VW().getTid())) {
                    if (view.getId() != h.this.dDi.getView().getId()) {
                        if (h.this.dDi.getHeaderImg() == null || view.getId() != h.this.dDi.getHeaderImg().getId()) {
                            if (h.this.dDi.ajb() != null && view.getId() == h.this.dDi.ajb().getId()) {
                                TiebaStatic.log(lVar.ajW());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.ajW());
                        return;
                    }
                    TiebaStatic.log(lVar.kh("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dDi = new t(this.mPageContext);
        this.dDi.currentPageType = 2;
        if (this.dDi.ciE != null) {
            this.dDi.ciE.bbP = 2;
        }
        if (this.dDi.cQU != null) {
            this.dDi.cQU.cRx = 2;
        }
        this.dDi.j(this.bGo);
        this.dDi.b(this.ear);
        return new com.baidu.tieba.card.a.a<>(this.dDi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.VW() == null || aVar == null || aVar.akh() == null) {
            return null;
        }
        this.cNR = lVar;
        lVar.lE(i + 1);
        s.ajC().a(lVar.kg("c12641"));
        if (lVar.aLZ != null && lVar.aLZ.size() > 0) {
            lVar.VW().a(lVar.aLZ);
        }
        bf bfVar = new bf(lVar.VW());
        bfVar.stType = "personalize_page";
        bfVar.aPe = 1;
        bfVar.aPf = 3;
        aVar.akh().a(this.bMG);
        aVar.akh().a(bfVar);
        return aVar.getView();
    }

    private void aBx() {
        l.cSo = "c10705";
        l.cSp = "c10730";
        l.cSq = "c10731";
        l.cSr = "c10704";
        l.cSs = "c10755";
        l.cSt = "c10710";
        l.cSu = "c10736";
        l.cSv = "c10737";
        l.cSw = "c10711";
        l.cSx = "c10758";
        l.cSy = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }
}
