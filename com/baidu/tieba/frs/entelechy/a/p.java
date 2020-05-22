package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class p extends com.baidu.tieba.frs.h<bj, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa adt;
    private String aeX;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hsh;
    private com.baidu.adp.lib.d.b<TbImageView> hsi;
    private com.baidu.tieba.frs.d.b hvA;
    private TbPageContext mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hvA = new com.baidu.tieba.frs.d.b();
        this.adt = new com.baidu.tieba.card.aa() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bk) {
                    if (p.this.hmM != null) {
                        p.this.hmM.a(view, (View) bVar, (Object) bk.dFe);
                    }
                    bk bkVar = (bk) bVar;
                    com.baidu.tieba.frs.d.c.caQ().a(p.this.hvA, bkVar, 1);
                    com.baidu.tieba.frs.d.a.a(bkVar, 1, p.this.mPageId, p.this.hvA, p.this.getTbPageTag());
                }
            }
        };
        this.hsh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXl */
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
        this.hsi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWM */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(p.this.mPageContext.getPageActivity());
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

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> b(ViewGroup viewGroup) {
        com.baidu.tieba.card.v vVar = new com.baidu.tieba.card.v(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar = new com.baidu.tieba.card.a.a<>(vVar);
        vVar.setConstrainImagePool(this.hsi);
        vVar.setConstrainLayoutPool(this.hsh);
        vVar.c(this.adt);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar) {
        if (aVar == null || aVar.bLU() == null) {
            return null;
        }
        if (aVar.bLU() instanceof com.baidu.tieba.a.e) {
            aVar.bLU().setPage(this.aeX);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        if (this.hvA != null) {
            int i2 = 0;
            if (this.hmG != null) {
                i2 = this.hmG.getTopThreadSize();
            }
            bjVar.dEA.dDb = (bjVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(bjVar.dEA, this.mPageId, this.hvA, getTbPageTag());
        com.baidu.tieba.frs.d.c.caQ().a(this.hvA, bjVar.dEA);
        aVar.bLU().c(this.adt);
        aVar.bLU().a(bjVar.dEA);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
    }
}
