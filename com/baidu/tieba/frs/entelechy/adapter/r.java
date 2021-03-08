package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.frs.k<ca, CardViewHolder<com.baidu.tieba.card.w>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private com.baidu.tieba.card.ab ahy;
    private String ajx;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> joC;
    private com.baidu.adp.lib.d.b<TbImageView> joD;
    private com.baidu.tieba.frs.b.b jsn;
    private TbPageContext mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jsn = new com.baidu.tieba.frs.b.b();
        this.ahy = new com.baidu.tieba.card.ab() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo, Object obj) {
                if (baseCardInfo instanceof cb) {
                    if (r.this.jhJ != null) {
                        r.this.jhJ.a(view, (View) baseCardInfo, (Object) cb.eSv);
                    }
                    cb cbVar = (cb) baseCardInfo;
                    com.baidu.tieba.frs.b.c.cKr().a(r.this.jsn, cbVar, 1);
                    com.baidu.tieba.frs.b.a.a(cbVar, 1, r.this.mPageId, r.this.jsn, r.this.getTbPageTag());
                }
            }
        };
        this.joC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFs */
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
        this.joD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buO */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(r.this.mPageContext.getPageActivity());
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
    public void uZ(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.w> e(ViewGroup viewGroup) {
        com.baidu.tieba.card.w wVar = new com.baidu.tieba.card.w(this.mPageContext, viewGroup);
        CardViewHolder<com.baidu.tieba.card.w> cardViewHolder = new CardViewHolder<>(wVar);
        wVar.setConstrainImagePool(this.joD);
        wVar.setConstrainLayoutPool(this.joC);
        wVar.c(this.ahy);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, CardViewHolder<com.baidu.tieba.card.w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        if (cardViewHolder.cto() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.cto().setPage(this.ajx);
        }
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) cardViewHolder);
        if (this.jsn != null) {
            int i2 = 0;
            if (this.jhD != null) {
                i2 = this.jhD.getTopThreadSize();
            }
            caVar.eLr.ePT = (caVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.a.a(caVar.eLr, this.mPageId, this.jsn, getTbPageTag());
        com.baidu.tieba.frs.b.c.cKr().a(this.jsn, caVar.eLr);
        cardViewHolder.cto().c(this.ahy);
        cardViewHolder.cto().a(caVar.eLr);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }
}
