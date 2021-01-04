package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.k;
/* loaded from: classes8.dex */
public class c extends k<bz, CardViewHolder<v>> implements x {
    private aa<bz> gEi;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private String mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gEi = new aa<bz>() { // from class: com.baidu.tieba.hottopic.frs.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bz bzVar, Object obj) {
                if (view != null && bzVar != null && bzVar.brq() != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 4).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.card_root_layout) {
                        TiebaStatic.log(new aq("c13020").w("fid", bzVar.getFid()).dX("obj_name", bzVar.brq().getName_show()).dX("tid", bzVar.getTid()));
                    }
                }
            }
        };
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.frs.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(c.this.mPageContext.getPageActivity());
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.frs.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(c.this.mPageContext.getPageActivity());
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

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.x
    public String agu() {
        return "FrsHottopicDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<v> e(ViewGroup viewGroup) {
        v vVar = new v(this.mPageContext, viewGroup);
        vVar.setConstrainImagePool(this.jlF);
        vVar.setConstrainLayoutPool(this.jlE);
        return new CardViewHolder<>(vVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, CardViewHolder<v> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.cvG() == null) {
            return null;
        }
        cardViewHolder.cvG().c(this.gEi);
        cardViewHolder.cvG().a(bzVar);
        if (bzVar != null && bzVar.brq() != null) {
            aq aqVar = new aq("c13019");
            aqVar.dX("tid", bzVar.getTid()).w("fid", bzVar.getFid()).dX("obj_name", bzVar.brq().getName_show());
            s.cva().e(aqVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
