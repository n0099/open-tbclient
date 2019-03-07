package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a>> {
    private ab<bg> dqn;
    private com.baidu.tieba.homepage.daily.view.a fHY;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdX;
    private com.baidu.adp.lib.e.b<TbImageView> fdY;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.daily.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beI */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fdY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.daily.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0236d.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.dqn = new ab<bg>() { // from class: com.baidu.tieba.homepage.daily.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null && b.this.fHY != null && b.this.fHY.getView() != null) {
                    am amVar = new am("c13175");
                    amVar.T("obj_type", 1);
                    amVar.bJ("tid", bgVar.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                    int i = 2;
                    if (view.getId() == b.this.fHY.blN() || view.getId() == b.this.fHY.blO()) {
                        i = 1;
                    } else if (view.getId() == b.this.fHY.blP()) {
                        i = 3;
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.fHY = new com.baidu.tieba.homepage.daily.view.a(this.mPageContext);
        this.fHY.setSingleImageRatio(0.75d);
        this.fHY.setTag(this.mPageId);
        this.fHY.setConstrainLayoutPool(this.fdX);
        this.fHY.setConstrainImagePool(this.fdY);
        this.fHY.setShareReportFrom(7);
        this.fHY.sk(11);
        this.fHY.setStType(n.YE());
        this.fHY.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.fHY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> aVar) {
        if (bgVar == null || aVar == null || aVar.aRi() == null) {
            return null;
        }
        am amVar = new am("c13176");
        amVar.T("obj_type", 1);
        amVar.bJ("tid", bgVar.getTid());
        amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
        t.aQF().b(amVar);
        aVar.aRi().d(this.dqn);
        aVar.aRi().a(bgVar);
        return aVar.getView();
    }
}
