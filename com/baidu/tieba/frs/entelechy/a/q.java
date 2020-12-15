package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class q extends com.baidu.tieba.frs.k<bx, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.ab agG;
    private String aiw;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    private com.baidu.tieba.frs.d.b jcU;
    private TbPageContext mPageContext;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jcU = new com.baidu.tieba.frs.d.b();
        this.agG = new com.baidu.tieba.card.ab() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo, Object obj) {
                if (baseCardInfo instanceof by) {
                    if (q.this.iSB != null) {
                        q.this.iSB.a(view, (View) baseCardInfo, (Object) by.eJA);
                    }
                    by byVar = (by) baseCardInfo;
                    com.baidu.tieba.frs.d.c.cJI().a(q.this.jcU, byVar, 1);
                    com.baidu.tieba.frs.d.a.a(byVar, 1, q.this.mPageId, q.this.jcU, q.this.getTbPageTag());
                }
            }
        };
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(q.this.mPageContext.getPageActivity());
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
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(q.this.mPageContext.getPageActivity());
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
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> c(ViewGroup viewGroup) {
        com.baidu.tieba.card.w wVar = new com.baidu.tieba.card.w(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar = new com.baidu.tieba.card.a.a<>(wVar);
        wVar.setConstrainImagePool(this.iZs);
        wVar.setConstrainLayoutPool(this.iZr);
        wVar.c(this.agG);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar) {
        if (aVar == null || aVar.csN() == null) {
            return null;
        }
        if (aVar.csN() instanceof com.baidu.tieba.a.e) {
            aVar.csN().setPage(this.aiw);
        }
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) aVar);
        if (this.jcU != null) {
            int i2 = 0;
            if (this.iSv != null) {
                i2 = this.iSv.getTopThreadSize();
            }
            bxVar.eCR.eHa = (bxVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcU, getTbPageTag());
        com.baidu.tieba.frs.d.c.cJI().a(this.jcU, bxVar.eCR);
        aVar.csN().c(this.agG);
        aVar.csN().a(bxVar.eCR);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }
}
