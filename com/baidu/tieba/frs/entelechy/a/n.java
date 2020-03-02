package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class n extends com.baidu.tieba.frs.h<bi, com.baidu.tieba.card.a.a<com.baidu.tieba.card.u>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.z JZ;
    private String LC;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gtl;
    private com.baidu.adp.lib.d.b<TbImageView> gtm;
    private com.baidu.tieba.frs.d.b gwq;
    private TbPageContext mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwq = new com.baidu.tieba.frs.d.b();
        this.JZ = new com.baidu.tieba.card.z() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bj) {
                    if (n.this.gnS != null) {
                        n.this.gnS.a(view, (View) bVar, (Object) bj.cRI);
                    }
                    bj bjVar = (bj) bVar;
                    com.baidu.tieba.frs.d.c.bJJ().a(n.this.gwq, bjVar, 1);
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, n.this.mPageId, n.this.gwq, n.this.getTbPageTag());
                }
            }
        };
        this.gtl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGc */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(n.this.mPageContext.getPageActivity());
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
        this.gtm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIg */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
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

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> b(ViewGroup viewGroup) {
        com.baidu.tieba.card.u uVar = new com.baidu.tieba.card.u(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> aVar = new com.baidu.tieba.card.a.a<>(uVar);
        uVar.setConstrainImagePool(this.gtm);
        uVar.setConstrainLayoutPool(this.gtl);
        uVar.c(this.JZ);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.u> aVar) {
        if (aVar == null || aVar.bvK() == null) {
            return null;
        }
        if (aVar.bvK() instanceof com.baidu.tieba.a.e) {
            aVar.bvK().setPage(this.LC);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) aVar);
        if (this.gwq != null) {
            int i2 = 0;
            if (this.gnM != null) {
                i2 = this.gnM.getTopThreadSize();
            }
            biVar.cRf.cPF = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(biVar.cRf, this.mPageId, this.gwq, getTbPageTag());
        com.baidu.tieba.frs.d.c.bJJ().a(this.gwq, biVar.cRf);
        aVar.bvK().c(this.JZ);
        aVar.bvK().a(biVar.cRf);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGX() {
        return this.gwq;
    }
}
