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
    private ab<bh> dEy;
    private com.baidu.tieba.homepage.daily.view.c geA;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dEy = new ab<bh>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                int i = 2;
                if (view != null && bhVar != null && f.this.geA != null && f.this.geA.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.P("obj_type", 2);
                    anVar.bT("tid", bhVar.getTid());
                    anVar.l("fid", bhVar.getFid());
                    if (view.getId() != f.this.geA.bvz() && view.getId() != f.this.geA.bvA()) {
                        if (view.getId() == f.this.geA.bvB()) {
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
        this.geA = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.geA.setTag(this.mPageId);
        this.geA.setShareReportFrom(7);
        this.geA.tH(11);
        this.geA.setStType(n.ael());
        this.geA.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.geA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bhVar == null || aVar == null || aVar.bat() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.P("obj_type", 2);
        anVar.bT("tid", bhVar.getTid());
        anVar.l("fid", bhVar.getFid());
        t.aZP().c(anVar);
        aVar.bat().d(this.dEy);
        aVar.bat().a(bhVar);
        return aVar.getView();
    }
}
