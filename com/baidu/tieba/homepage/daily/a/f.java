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
    private ab<bh> dSq;
    private com.baidu.tieba.homepage.daily.view.c geX;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dSq = new ab<bh>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                int i = 2;
                if (view != null && bhVar != null && f.this.geX != null && f.this.geX.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.O("obj_type", 2);
                    anVar.bS("tid", bhVar.getTid());
                    anVar.p("fid", bhVar.getFid());
                    if (view.getId() != f.this.geX.btq() && view.getId() != f.this.geX.btr()) {
                        if (view.getId() == f.this.geX.bts()) {
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
        this.geX = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.geX.setTag(this.mPageId);
        this.geX.setShareReportFrom(7);
        this.geX.sF(11);
        this.geX.setStType(n.air());
        this.geX.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.geX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bhVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.O("obj_type", 2);
        anVar.bS("tid", bhVar.getTid());
        anVar.p("fid", bhVar.getFid());
        t.bau().c(anVar);
        aVar.baX().d(this.dSq);
        aVar.baX().a(bhVar);
        return aVar.getView();
    }
}
