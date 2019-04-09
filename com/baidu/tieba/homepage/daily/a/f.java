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
    private ab<bg> dqp;
    private com.baidu.tieba.homepage.daily.view.c fHO;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dqp = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                int i = 2;
                if (view != null && bgVar != null && f.this.fHO != null && f.this.fHO.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.T("obj_type", 2);
                    amVar.bJ("tid", bgVar.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                    if (view.getId() != f.this.fHO.blK() && view.getId() != f.this.fHO.blL()) {
                        if (view.getId() == f.this.fHO.blM()) {
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
        this.fHO = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.fHO.setTag(this.mPageId);
        this.fHO.setShareReportFrom(7);
        this.fHO.sg(11);
        this.fHO.setStType(n.YB());
        this.fHO.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.fHO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bgVar == null || aVar == null || aVar.aRg() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.T("obj_type", 2);
        amVar.bJ("tid", bgVar.getTid());
        amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
        t.aQD().b(amVar);
        aVar.aRg().d(this.dqp);
        aVar.aRg().a(bgVar);
        return aVar.getView();
    }
}
