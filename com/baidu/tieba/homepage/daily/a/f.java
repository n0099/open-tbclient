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
    private ad<bb> cbm;
    private com.baidu.tieba.homepage.daily.view.c evD;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cbm = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                int i = 2;
                if (view != null && bbVar != null && f.this.evD != null && f.this.evD.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.y("obj_type", 2);
                    amVar.aB("tid", bbVar.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    if (view.getId() != f.this.evD.aLL() && view.getId() != f.this.evD.aLM()) {
                        if (view.getId() == f.this.evD.aLN()) {
                            i = 3;
                        }
                    } else {
                        i = 1;
                    }
                    amVar.y("obj_locate", i);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.evD = new com.baidu.tieba.homepage.daily.view.c(this.mPageContext);
        this.evD.setTag(this.mPageId);
        this.evD.setShareReportFrom(7);
        this.evD.oB(11);
        this.evD.setStType(o.zH());
        this.evD.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.evD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.c> aVar) {
        if (bbVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.y("obj_type", 2);
        amVar.aB("tid", bbVar.getTid());
        amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.aqP().a(amVar);
        aVar.arr().b(this.cbm);
        aVar.arr().a(bbVar);
        return aVar.getView();
    }
}
