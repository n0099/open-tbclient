package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ab<bg> dqn;
    private com.baidu.tieba.homepage.daily.view.c fIb;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dqn = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                int i = 2;
                if (view != null && bgVar != null && f.this.fIb != null && f.this.fIb.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.T("obj_type", 2);
                    amVar.bJ("tid", bgVar.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                    if (view.getId() != f.this.fIb.blN() && view.getId() != f.this.fIb.blO()) {
                        if (view.getId() == f.this.fIb.blP()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    amVar.T("obj_locate", i);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.fIb = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.fIb.setTag(this.mPageId);
        this.fIb.setShareReportFrom(7);
        this.fIb.sk(11);
        this.fIb.setStType(n.YE());
        this.fIb.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.fIb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bgVar == null || aVar == null || aVar.aRi() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.T("obj_type", 2);
        amVar.bJ("tid", bgVar.getTid());
        amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
        t.aQF().b(amVar);
        aVar.aRi().d(this.dqn);
        aVar.aRi().a(bgVar);
        return aVar.getView();
    }
}
