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
    private ab<bh> dTh;
    private com.baidu.tieba.homepage.daily.view.c gfO;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTh = new ab<bh>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                int i = 2;
                if (view != null && bhVar != null && f.this.gfO != null && f.this.gfO.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.O("obj_type", 2);
                    anVar.bS("tid", bhVar.getTid());
                    anVar.p("fid", bhVar.getFid());
                    if (view.getId() != f.this.gfO.bts() && view.getId() != f.this.gfO.btt()) {
                        if (view.getId() == f.this.gfO.btu()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    anVar.O("obj_locate", i);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> b(ViewGroup viewGroup) {
        this.gfO = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.gfO.setTag(this.mPageId);
        this.gfO.setShareReportFrom(7);
        this.gfO.sG(11);
        this.gfO.setStType(n.ait());
        this.gfO.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.gfO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bhVar == null || aVar == null || aVar.baZ() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.O("obj_type", 2);
        anVar.bS("tid", bhVar.getTid());
        anVar.p("fid", bhVar.getFid());
        t.baw().c(anVar);
        aVar.baZ().d(this.dTh);
        aVar.baZ().a(bhVar);
        return aVar.getView();
    }
}
