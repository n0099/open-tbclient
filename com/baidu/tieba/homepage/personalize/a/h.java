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
    public BdUniqueId aSy;
    private c.a aYP;
    private l bZi;
    private t cOe;
    private v dof;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dof = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = h.this.bZi;
                s.abX().cC(true);
                if (view != null && h.this.cOe != null && h.this.cOe.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != h.this.cOe.getView().getId()) {
                        if (h.this.cOe.getHeaderImg() == null || view.getId() != h.this.cOe.getHeaderImg().getId()) {
                            if (h.this.cOe.abw() != null && view.getId() == h.this.cOe.abw().getId()) {
                                TiebaStatic.log(lVar.acr());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.acr());
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
        this.cOe = new t(this.mPageContext);
        this.cOe.currentPageType = 2;
        if (this.cOe.bvI != null) {
            this.cOe.bvI.anO = 2;
        }
        if (this.cOe.ccm != null) {
            this.cOe.ccm.ccQ = 2;
        }
        this.cOe.k(this.aSy);
        this.cOe.b(this.dof);
        return new com.baidu.tieba.card.a.a<>(this.cOe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.Ox() == null || aVar == null || aVar.acC() == null) {
            return null;
        }
        this.bZi = lVar;
        lVar.iG(i + 1);
        s.abX().a(lVar.ka("c12641"));
        if (lVar.Xy != null && lVar.Xy.size() > 0) {
            lVar.Ox().a(lVar.Xy);
        }
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaF = 1;
        beVar.aaG = 3;
        aVar.acC().a(this.aYP);
        aVar.acC().a(beVar);
        return aVar.getView();
    }

    private void auu() {
        l.cdG = "c10705";
        l.cdH = "c10730";
        l.cdI = "c10731";
        l.cdJ = "c10704";
        l.cdK = "c10755";
        l.cdL = "c10710";
        l.cdM = "c10736";
        l.cdN = "c10737";
        l.cdO = "c10711";
        l.cdP = "c10758";
        l.cdQ = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aYP = aVar;
    }
}
