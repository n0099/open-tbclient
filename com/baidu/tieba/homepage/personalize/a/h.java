package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId aSB;
    private c.a aYT;
    private l bZm;
    private t cOi;
    private v doj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYT = null;
        this.doj = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = h.this.bZm;
                s.abW().cC(true);
                if (view != null && h.this.cOi != null && h.this.cOi.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != h.this.cOi.getView().getId()) {
                        if (h.this.cOi.getHeaderImg() == null || view.getId() != h.this.cOi.getHeaderImg().getId()) {
                            if (h.this.cOi.abw() != null && view.getId() == h.this.cOi.abw().getId()) {
                                TiebaStatic.log(lVar.acq());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.acq());
                        return;
                    }
                    TiebaStatic.log(lVar.kb("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        auu();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.cOi = new t(this.mPageContext);
        this.cOi.currentPageType = 2;
        if (this.cOi.bvM != null) {
            this.cOi.bvM.anR = 2;
        }
        if (this.cOi.ccq != null) {
            this.cOi.ccq.ccU = 2;
        }
        this.cOi.k(this.aSB);
        this.cOi.b(this.doj);
        return new com.baidu.tieba.card.a.a<>(this.cOi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.Ox() == null || aVar == null || aVar.acB() == null) {
            return null;
        }
        this.bZm = lVar;
        lVar.iG(i + 1);
        s.abW().a(lVar.ka("c12641"));
        if (lVar.XB != null && lVar.XB.size() > 0) {
            lVar.Ox().a(lVar.XB);
        }
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaI = 1;
        beVar.aaJ = 3;
        aVar.acB().a(this.aYT);
        aVar.acB().a(beVar);
        return aVar.getView();
    }

    private void auu() {
        l.cdK = "c10705";
        l.cdL = "c10730";
        l.cdM = "c10731";
        l.cdN = "c10704";
        l.cdO = "c10755";
        l.cdP = "c10710";
        l.cdQ = "c10736";
        l.cdR = "c10737";
        l.cdS = "c10711";
        l.cdT = "c10758";
        l.cdU = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aYT = aVar;
    }
}
