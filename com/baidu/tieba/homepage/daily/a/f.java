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
    private com.baidu.tieba.homepage.daily.view.c dUD;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.dUD != null && f.this.dUD.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.r("obj_type", 2);
                    anVar.ae("tid", bbVar.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.dUD.aDE() && view.getId() != f.this.dUD.aDF()) {
                        if (view.getId() == f.this.dUD.aDG()) {
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
        this.dUD = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.dUD.setTag(this.mPageId);
        this.dUD.setShareReportFrom(7);
        this.dUD.mz(11);
        this.dUD.setStType(o.uX());
        this.dUD.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.dUD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.r("obj_type", 2);
        anVar.ae("tid", bbVar.getTid());
        anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.ajb().a(anVar);
        aVar.ajC().b(this.bHC);
        aVar.ajC().a(bbVar);
        return aVar.getView();
    }
}
