package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.frs.k<by, CardViewHolder<com.baidu.tieba.card.v>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private com.baidu.tieba.card.aa ago;
    private String air;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jgX;
    private com.baidu.adp.lib.d.b<TbImageView> jgY;
    private com.baidu.tieba.frs.b.b jkJ;
    private TbPageContext mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.ago = new com.baidu.tieba.card.aa() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo, Object obj) {
                if (baseCardInfo instanceof bz) {
                    if (r.this.jag != null) {
                        r.this.jag.a(view, (View) baseCardInfo, (Object) bz.eOI);
                    }
                    bz bzVar = (bz) baseCardInfo;
                    com.baidu.tieba.frs.b.c.cIR().a(r.this.jkJ, bzVar, 1);
                    com.baidu.tieba.frs.b.a.a(bzVar, 1, r.this.mPageId, r.this.jkJ, r.this.getTbPageTag());
                }
            }
        };
        this.jgX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cDT */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(r.this.mPageContext.getPageActivity());
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
        this.jgY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(r.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10043));
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
    public void uN(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.v> e(ViewGroup viewGroup) {
        com.baidu.tieba.card.v vVar = new com.baidu.tieba.card.v(this.mPageContext, viewGroup);
        CardViewHolder<com.baidu.tieba.card.v> cardViewHolder = new CardViewHolder<>(vVar);
        vVar.setConstrainImagePool(this.jgY);
        vVar.setConstrainLayoutPool(this.jgX);
        vVar.c(this.ago);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, CardViewHolder<com.baidu.tieba.card.v> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        if (cardViewHolder.crP() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.crP().setPage(this.air);
        }
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) cardViewHolder);
        if (this.jkJ != null) {
            int i2 = 0;
            if (this.jaa != null) {
                i2 = this.jaa.getTopThreadSize();
            }
            byVar.eHK.eMg = (byVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.a.a(byVar.eHK, this.mPageId, this.jkJ, getTbPageTag());
        com.baidu.tieba.frs.b.c.cIR().a(this.jkJ, byVar.eHK);
        cardViewHolder.crP().c(this.ago);
        cardViewHolder.crP().a(byVar.eHK);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }
}
