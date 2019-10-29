package com.baidu.tieba.homepage.daily.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a>> {
    private ab<bh> dTh;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fAu;
    private com.baidu.adp.lib.e.b<TbImageView> fAv;
    private com.baidu.tieba.homepage.daily.view.a gfL;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.daily.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
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
        this.fAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.daily.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
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
        this.dTh = new ab<bh>() { // from class: com.baidu.tieba.homepage.daily.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null && b.this.gfL != null && b.this.gfL.getView() != null) {
                    an anVar = new an("c13175");
                    anVar.O("obj_type", 1);
                    anVar.bS("tid", bhVar.getTid());
                    anVar.p("fid", bhVar.getFid());
                    int i = 2;
                    if (view.getId() == b.this.gfL.bts() || view.getId() == b.this.gfL.btt()) {
                        i = 1;
                    } else if (view.getId() == b.this.gfL.btu()) {
                        i = 3;
                    }
                    anVar.O("obj_locate", i);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> b(ViewGroup viewGroup) {
        this.gfL = new com.baidu.tieba.homepage.daily.view.a(this.mPageContext);
        this.gfL.setSingleImageRatio(0.75d);
        this.gfL.setTag(this.mPageId);
        this.gfL.setConstrainLayoutPool(this.fAu);
        this.gfL.setConstrainImagePool(this.fAv);
        this.gfL.setShareReportFrom(7);
        this.gfL.sG(11);
        this.gfL.setStType(n.ait());
        this.gfL.currentPageType = 16;
        return new com.baidu.tieba.card.a.a<>(this.gfL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.daily.view.a> aVar) {
        if (bhVar == null || aVar == null || aVar.baZ() == null) {
            return null;
        }
        an anVar = new an("c13176");
        anVar.O("obj_type", 1);
        anVar.bS("tid", bhVar.getTid());
        anVar.p("fid", bhVar.getFid());
        t.baw().c(anVar);
        aVar.baZ().d(this.dTh);
        aVar.baZ().a(bhVar);
        return aVar.getView();
    }
}
