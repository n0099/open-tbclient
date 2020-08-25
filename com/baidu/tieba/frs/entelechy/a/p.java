package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class p extends com.baidu.tieba.frs.k<bv, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa aeT;
    private String agH;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private com.baidu.tieba.frs.d.b icL;
    private TbPageContext mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.icL = new com.baidu.tieba.frs.d.b();
        this.aeT = new com.baidu.tieba.card.aa() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bw) {
                    if (p.this.hSt != null) {
                        p.this.hSt.a(view, (View) bVar, (Object) bw.ebx);
                    }
                    bw bwVar = (bw) bVar;
                    com.baidu.tieba.frs.d.c.csu().a(p.this.icL, bwVar, 1);
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, p.this.mPageId, p.this.icL, p.this.getTbPageTag());
                }
            }
        };
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
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
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
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

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> b(ViewGroup viewGroup) {
        com.baidu.tieba.card.v vVar = new com.baidu.tieba.card.v(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar = new com.baidu.tieba.card.a.a<>(vVar);
        vVar.setConstrainImagePool(this.hZm);
        vVar.setConstrainLayoutPool(this.hZl);
        vVar.c(this.aeT);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar) {
        if (aVar == null || aVar.ccE() == null) {
            return null;
        }
        if (aVar.ccE() instanceof com.baidu.tieba.a.e) {
            aVar.ccE().setPage(this.agH);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        if (this.icL != null) {
            int i2 = 0;
            if (this.hSn != null) {
                i2 = this.hSn.getTopThreadSize();
            }
            bvVar.dUS.dZb = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(bvVar.dUS, this.mPageId, this.icL, getTbPageTag());
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bvVar.dUS);
        aVar.ccE().c(this.aeT);
        aVar.ccE().a(bvVar.dUS);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }
}
