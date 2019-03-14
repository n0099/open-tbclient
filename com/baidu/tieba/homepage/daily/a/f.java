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
    private ab<bg> dql;
    private com.baidu.tieba.homepage.daily.view.c fIa;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dql = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                int i = 2;
                if (view != null && bgVar != null && f.this.fIa != null && f.this.fIa.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.T("obj_type", 2);
                    amVar.bJ("tid", bgVar.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                    if (view.getId() != f.this.fIa.blN() && view.getId() != f.this.fIa.blO()) {
                        if (view.getId() == f.this.fIa.blP()) {
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
        this.fIa = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.fIa.setTag(this.mPageId);
        this.fIa.setShareReportFrom(7);
        this.fIa.sk(11);
        this.fIa.setStType(n.YE());
        this.fIa.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.fIa);
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
        aVar.aRi().d(this.dql);
        aVar.aRi().a(bgVar);
        return aVar.getView();
    }
}
