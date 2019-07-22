package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ab<bg> dEr;
    private com.baidu.tieba.homepage.daily.view.c gdJ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dEr = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                int i = 2;
                if (view != null && bgVar != null && f.this.gdJ != null && f.this.gdJ.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.P("obj_type", 2);
                    anVar.bT("tid", bgVar.getTid());
                    anVar.l("fid", bgVar.getFid());
                    if (view.getId() != f.this.gdJ.bvm() && view.getId() != f.this.gdJ.bvn()) {
                        if (view.getId() == f.this.gdJ.bvo()) {
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
        this.gdJ = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.gdJ.setTag(this.mPageId);
        this.gdJ.setShareReportFrom(7);
        this.gdJ.tF(11);
        this.gdJ.setStType(n.aek());
        this.gdJ.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.gdJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bgVar == null || aVar == null || aVar.bar() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.P("obj_type", 2);
        anVar.bT("tid", bgVar.getTid());
        anVar.l("fid", bgVar.getFid());
        t.aZN().c(anVar);
        aVar.bar().d(this.dEr);
        aVar.bar().a(bgVar);
        return aVar.getView();
    }
}
