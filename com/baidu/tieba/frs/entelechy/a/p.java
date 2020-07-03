package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class p extends com.baidu.tieba.frs.j<bt, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa adX;
    private String afG;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private com.baidu.tieba.frs.d.b hIE;
    private TbPageContext mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.adX = new com.baidu.tieba.card.aa() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar, Object obj) {
                if (bVar instanceof bu) {
                    if (p.this.hzo != null) {
                        p.this.hzo.a(view, (View) bVar, (Object) bu.dLQ);
                    }
                    bu buVar = (bu) bVar;
                    com.baidu.tieba.frs.d.c.ceq().a(p.this.hIE, buVar, 1);
                    com.baidu.tieba.frs.d.a.a(buVar, 1, p.this.mPageId, p.this.hIE, p.this.getTbPageTag());
                }
            }
        };
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cay */
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(p.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10043));
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
    public void qX(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> b(ViewGroup viewGroup) {
        com.baidu.tieba.card.v vVar = new com.baidu.tieba.card.v(this.mPageContext, viewGroup);
        com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar = new com.baidu.tieba.card.a.a<>(vVar);
        vVar.setConstrainImagePool(this.hFj);
        vVar.setConstrainLayoutPool(this.hFi);
        vVar.c(this.adX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.v> aVar) {
        if (aVar == null || aVar.bPg() == null) {
            return null;
        }
        if (aVar.bPg() instanceof com.baidu.tieba.a.e) {
            aVar.bPg().setPage(this.afG);
        }
        super.a(i, view, viewGroup, (ViewGroup) btVar, (bt) aVar);
        if (this.hIE != null) {
            int i2 = 0;
            if (this.hzi != null) {
                i2 = this.hzi.getTopThreadSize();
            }
            btVar.dLi.dJw = (btVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.a.a(btVar.dLi, this.mPageId, this.hIE, getTbPageTag());
        com.baidu.tieba.frs.d.c.ceq().a(this.hIE, btVar.dLi);
        aVar.bPg().c(this.adX);
        aVar.bPg().a(btVar.dLi);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }
}
