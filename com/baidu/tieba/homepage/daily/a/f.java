package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ad<bb> bHC;
    private com.baidu.tieba.homepage.daily.view.c dUI;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.dUI != null && f.this.dUI.getView() != null) {
                    an anVar = new an("c13177");
                    anVar.r("obj_type", 2);
                    anVar.af("tid", bbVar.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.dUI.aDH() && view.getId() != f.this.dUI.aDI()) {
                        if (view.getId() == f.this.dUI.aDJ()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    anVar.r("obj_locate", i);
                    TiebaStatic.log(anVar);
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
        this.dUI = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.dUI.setTag(this.mPageId);
        this.dUI.setShareReportFrom(7);
        this.dUI.mz(11);
        this.dUI.setStType(o.uY());
        this.dUI.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.dUI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        an anVar = new an("c13177");
        anVar.r("obj_type", 2);
        anVar.af("tid", bbVar.getTid());
        anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.aiY().a(anVar);
        aVar.ajz().b(this.bHC);
        aVar.ajz().a(bbVar);
        return aVar.getView();
    }
}
