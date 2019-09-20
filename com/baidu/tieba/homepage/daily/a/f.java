package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ab<bh> dGj;
    private com.baidu.tieba.homepage.daily.view.c ggr;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dGj = new ab<bh>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                int i = 2;
                if (view != null && bhVar != null && f.this.ggr != null && f.this.ggr.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.P("obj_type", 2);
                    anVar.bT("tid", bhVar.getTid());
                    anVar.n("fid", bhVar.getFid());
                    if (view.getId() != f.this.ggr.bwn() && view.getId() != f.this.ggr.bwo()) {
                        if (view.getId() == f.this.ggr.bwp()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    anVar.P("obj_locate", i);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.ggr = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.ggr.setTag(this.mPageId);
        this.ggr.setShareReportFrom(7);
        this.ggr.tL(11);
        this.ggr.setStType(n.aep());
        this.ggr.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.ggr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bhVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.P("obj_type", 2);
        anVar.bT("tid", bhVar.getTid());
        anVar.n("fid", bhVar.getFid());
        t.bat().c(anVar);
        aVar.baX().d(this.dGj);
        aVar.baX().a(bhVar);
        return aVar.getView();
    }
}
