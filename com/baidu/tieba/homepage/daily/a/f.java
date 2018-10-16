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
    private com.baidu.tieba.homepage.daily.view.c ejP;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.ejP != null && f.this.ejP.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.x("obj_type", 2);
                    amVar.ax("tid", bbVar.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.ejP.aJj() && view.getId() != f.this.ejP.aJk()) {
                        if (view.getId() == f.this.ejP.aJl()) {
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
        this.ejP = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.ejP.setTag(this.mPageId);
        this.ejP.setShareReportFrom(7);
        this.ejP.nB(11);
        this.ejP.setStType(o.yj());
        this.ejP.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.ejP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.aoP() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.x("obj_type", 2);
        amVar.ax("tid", bbVar.getTid());
        amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.aoo().a(amVar);
        aVar.aoP().b(this.bVT);
        aVar.aoP().a(bbVar);
        return aVar.getView();
    }
}
