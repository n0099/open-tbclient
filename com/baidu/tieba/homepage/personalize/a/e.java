package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<o>> {
    public BdUniqueId aSy;
    private c.a aYP;
    private v dof;
    private o drL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dof = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.abX().cC(true);
                if (view != null && e.this.drL != null && e.this.drL.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != e.this.drL.getView().getId()) {
                        if (e.this.drL.getHeaderImg() == null || view.getId() != e.this.drL.getHeaderImg().getId()) {
                            if (e.this.drL.abw() == null || view.getId() != e.this.drL.abw().getId()) {
                                if (e.this.drL.bvI == null || e.this.drL.bvI.getBarNameTv() == null || view.getId() != e.this.drL.bvI.getBarNameTv().getId()) {
                                    if (e.this.drL.abv() != null && view.getId() == e.this.drL.abv().getId()) {
                                        TiebaStatic.log(lVar.jZ("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.acq());
                                return;
                            }
                            TiebaStatic.log(lVar.jY("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jY("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jY("c12192"));
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
    public com.baidu.tieba.card.a.a<o> onCreateViewHolder(ViewGroup viewGroup) {
        this.drL = new o(this.mPageContext);
        this.drL.currentPageType = 2;
        if (this.drL.bvI != null) {
            this.drL.bvI.anO = 2;
        }
        this.drL.k(this.aSy);
        return new com.baidu.tieba.card.a.a<>(this.drL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.acC() == null) {
            return null;
        }
        lVar.iG(i + 1);
        s.abX().a(lVar.jX("c12190"));
        aVar.acC().a(lVar);
        aVar.acC().b(this.dof);
        aVar.acC().a(this.aYP);
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
