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
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c>> {
    private ad<bb> bNr;
    private com.baidu.tieba.homepage.daily.view.c ebW;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bNr = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.ebW != null && f.this.ebW.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.w("obj_type", 2);
                    amVar.al("tid", bbVar.getTid());
                    amVar.g(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.ebW.aFR() && view.getId() != f.this.ebW.aFS()) {
                        if (view.getId() == f.this.ebW.aFT()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    amVar.w("obj_locate", i);
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
        this.ebW = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.ebW.setTag(this.mPageId);
        this.ebW.setShareReportFrom(7);
        this.ebW.nd(11);
        this.ebW.setStType(o.wa());
        this.ebW.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.ebW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.w("obj_type", 2);
        amVar.al("tid", bbVar.getTid());
        amVar.g(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.akM().a(amVar);
        aVar.aln().b(this.bNr);
        aVar.aln().a(bbVar);
        return aVar.getView();
    }
}
