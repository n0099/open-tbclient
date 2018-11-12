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
    private ad<bb> bWF;
    private com.baidu.tieba.homepage.daily.view.c elk;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWF = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.elk != null && f.this.elk.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.x("obj_type", 2);
                    amVar.ax("tid", bbVar.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.elk.aIH() && view.getId() != f.this.elk.aII()) {
                        if (view.getId() == f.this.elk.aIJ()) {
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.elk = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.elk.setTag(this.mPageId);
        this.elk.setShareReportFrom(7);
        this.elk.nT(11);
        this.elk.setStType(o.yq());
        this.elk.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.elk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.x("obj_type", 2);
        amVar.ax("tid", bbVar.getTid());
        amVar.h(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.anQ().a(amVar);
        aVar.aor().b(this.bWF);
        aVar.aor().a(bbVar);
        return aVar.getView();
    }
}
