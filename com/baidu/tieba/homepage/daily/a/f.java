package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ad<bb> bVT;
    private com.baidu.tieba.homepage.daily.view.c ejQ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.ejQ != null && f.this.ejQ.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.x("obj_type", 2);
                    amVar.ax("tid", bbVar.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.ejQ.aJj() && view.getId() != f.this.ejQ.aJk()) {
                        if (view.getId() == f.this.ejQ.aJl()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    amVar.x("obj_locate", i);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejQ = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.ejQ.setTag(this.mPageId);
        this.ejQ.setShareReportFrom(7);
        this.ejQ.nB(11);
        this.ejQ.setStType(o.yj());
        this.ejQ.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.ejQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.aoQ() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.x("obj_type", 2);
        amVar.ax("tid", bbVar.getTid());
        amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.aop().a(amVar);
        aVar.aoQ().b(this.bVT);
        aVar.aoQ().a(bbVar);
        return aVar.getView();
    }
}
