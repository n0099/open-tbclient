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
    public BdUniqueId aSB;
    private c.a aYT;
    private v doj;
    private o drP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYT = null;
        this.doj = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.abW().cC(true);
                if (view != null && e.this.drP != null && e.this.drP.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != e.this.drP.getView().getId()) {
                        if (e.this.drP.getHeaderImg() == null || view.getId() != e.this.drP.getHeaderImg().getId()) {
                            if (e.this.drP.abw() == null || view.getId() != e.this.drP.abw().getId()) {
                                if (e.this.drP.bvM == null || e.this.drP.bvM.getBarNameTv() == null || view.getId() != e.this.drP.bvM.getBarNameTv().getId()) {
                                    if (e.this.drP.abv() != null && view.getId() == e.this.drP.abv().getId()) {
                                        TiebaStatic.log(lVar.jZ("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.acp());
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
        this.drP = new o(this.mPageContext);
        this.drP.currentPageType = 2;
        if (this.drP.bvM != null) {
            this.drP.bvM.anR = 2;
        }
        this.drP.k(this.aSB);
        return new com.baidu.tieba.card.a.a<>(this.drP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.acB() == null) {
            return null;
        }
        lVar.iG(i + 1);
        s.abW().a(lVar.jX("c12190"));
        aVar.acB().a(lVar);
        aVar.acB().b(this.doj);
        aVar.acB().a(this.aYT);
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
