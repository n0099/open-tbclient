package com.baidu.tieba.homepage.topic.topicdetail.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topicdetail.b.c, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topicdetail.view.d>> {
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topicdetail.b.c.jXN);
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.homepage.topic.topicdetail.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(a.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.homepage.topic.topicdetail.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(a.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
        a(new ab() { // from class: com.baidu.tieba.homepage.topic.topicdetail.a.a.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                com.baidu.tieba.homepage.topic.topicdetail.view.d dVar;
                if ((view.getTag() instanceof com.baidu.tieba.card.a.a) && (dVar = (com.baidu.tieba.homepage.topic.topicdetail.view.d) ((com.baidu.tieba.card.a.a) view.getTag()).csN()) != null) {
                    dVar.bAr();
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topicdetail.view.d> c(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topicdetail.view.d dVar = new com.baidu.tieba.homepage.topic.topicdetail.view.d(this.mPageContext);
        dVar.setConstrainLayoutPool(this.iZr);
        dVar.setConstrainImagePool(this.iZs);
        dVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topicdetail.view.d> aVar) {
        if (cVar == null || aVar == null || aVar.csN() == null) {
            return null;
        }
        aVar.csN().a(cVar);
        return aVar.getView();
    }
}
