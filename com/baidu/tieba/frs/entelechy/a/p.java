package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class p extends com.baidu.tieba.frs.k<bw, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.ab afK;
    private String ahw;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iOy;
    private com.baidu.adp.lib.d.b<TbImageView> iOz;
    private com.baidu.tieba.frs.d.b iRY;
    private TbPageContext mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.afK = new com.baidu.tieba.card.ab() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo, Object obj) {
                if (baseCardInfo instanceof bx) {
                    if (p.this.iHH != null) {
                        p.this.iHH.a(view, (View) baseCardInfo, (Object) bx.eCy);
                    }
                    bx bxVar = (bx) baseCardInfo;
                    com.baidu.tieba.frs.d.c.cEu().a(p.this.iRY, bxVar, 1);
                    com.baidu.tieba.frs.d.a.a(bxVar, 1, p.this.mPageId, p.this.iRY, p.this.getTbPageTag());
                }
            }
        };
        this.iOy = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(p.this.mPageContext.getPageActivity());
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
        this.iOz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsp */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(p.this.mPageContext.getPageActivity());
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
    public void vB(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> c(ViewGroup viewGroup) {
        com.baidu.tieba.card.w wVar = new com.baidu.tieba.card.w(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar = new com.baidu.tieba.card.a.a<>(wVar);
        wVar.setConstrainImagePool(this.iOz);
        wVar.setConstrainLayoutPool(this.iOy);
        wVar.c(this.afK);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.w> aVar) {
        if (aVar == null || aVar.coz() == null) {
            return null;
        }
        if (aVar.coz() instanceof com.baidu.tieba.a.e) {
            aVar.coz().setPage(this.ahw);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) aVar);
        if (this.iRY != null) {
            int i2 = 0;
            if (this.iHB != null) {
                i2 = this.iHB.getTopThreadSize();
            }
            bwVar.evQ.eAb = (bwVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(bwVar.evQ, this.mPageId, this.iRY, getTbPageTag());
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bwVar.evQ);
        aVar.coz().c(this.afK);
        aVar.coz().a(bwVar.evQ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
