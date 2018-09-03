package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a>> {
    private ad<bb> bHC;
    private com.baidu.tieba.homepage.daily.view.a dUA;
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.daily.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.daily.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(f.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null && b.this.dUA != null && b.this.dUA.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.r("obj_type", 1);
                    anVar.ae("tid", bbVar.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    int i = 2;
                    if (view.getId() == b.this.dUA.aDE() || view.getId() == b.this.dUA.aDF()) {
                        i = 1;
                    } else if (view.getId() == b.this.dUA.aDG()) {
                        i = 3;
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dUA = new com.baidu.tieba.homepage.daily.view.a(this.mPageContext);
        this.dUA.setSingleImageRatio(0.75d);
        this.dUA.setTag(this.mPageId);
        this.dUA.setConstrainLayoutPool(this.dqz);
        this.dUA.setConstrainImagePool(this.dqA);
        this.dUA.setShareReportFrom(7);
        this.dUA.mz(11);
        this.dUA.setStType(o.uX());
        this.dUA.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.dUA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> aVar) {
        if (bbVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.r("obj_type", 1);
        anVar.ae("tid", bbVar.getTid());
        anVar.f(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.ajb().a(anVar);
        aVar.ajC().b(this.bHC);
        aVar.ajC().a(bbVar);
        return aVar.getView();
    }
}
