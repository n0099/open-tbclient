package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a>> {
    private ad<bb> cax;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    private com.baidu.tieba.homepage.daily.view.a esc;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.daily.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.daily.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.cax = new ad<bb>() { // from class: com.baidu.tieba.homepage.daily.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null && b.this.esc != null && b.this.esc.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.x("obj_type", 1);
                    amVar.aA("tid", bbVar.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
                    int i = 2;
                    if (view.getId() == b.this.esc.aKy() || view.getId() == b.this.esc.aKz()) {
                        i = 1;
                    } else if (view.getId() == b.this.esc.aKA()) {
                        i = 3;
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.esc = new com.baidu.tieba.homepage.daily.view.a(this.mPageContext);
        this.esc.setSingleImageRatio(0.75d);
        this.esc.setTag(this.mPageId);
        this.esc.setConstrainLayoutPool(this.dMD);
        this.esc.setConstrainImagePool(this.dME);
        this.esc.setShareReportFrom(7);
        this.esc.on(11);
        this.esc.setStType(o.zu());
        this.esc.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.esc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> aVar) {
        if (bbVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.x("obj_type", 1);
        amVar.aA("tid", bbVar.getTid());
        amVar.i(ImageViewerConfig.FORUM_ID, bbVar.getFid());
        v.apD().a(amVar);
        aVar.aqe().b(this.cax);
        aVar.aqe().a(bbVar);
        return aVar.getView();
    }
}
