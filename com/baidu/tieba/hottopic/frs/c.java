package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.w;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
/* loaded from: classes8.dex */
public class c extends k<cb, CardViewHolder<w>> implements y {
    private ab<cb> gCz;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmT;
    private com.baidu.adp.lib.d.b<TbImageView> jmU;
    private String mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gCz = new ab<cb>() { // from class: com.baidu.tieba.hottopic.frs.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, cb cbVar, Object obj) {
                if (view != null && cbVar != null && cbVar.bnQ() != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 4).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.card_root_layout) {
                        TiebaStatic.log(new ar("c13020").v("fid", cbVar.getFid()).dR("obj_name", cbVar.bnQ().getName_show()).dR("tid", cbVar.getTid()));
                    }
                }
            }
        };
        this.jmT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.hottopic.frs.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFm */
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
        this.jmU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.hottopic.frs.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(c.this.mPageContext.getPageActivity());
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

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.y
    public String csD() {
        return "FrsHottopicDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<w> e(ViewGroup viewGroup) {
        w wVar = new w(this.mPageContext, viewGroup);
        wVar.setConstrainImagePool(this.jmU);
        wVar.setConstrainLayoutPool(this.jmT);
        return new CardViewHolder<>(wVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, CardViewHolder<w> cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().c(this.gCz);
        cardViewHolder.cti().a(cbVar);
        if (cbVar != null && cbVar.bnQ() != null) {
            ar arVar = new ar("c13019");
            arVar.dR("tid", cbVar.getTid()).v("fid", cbVar.getFid()).dR("obj_name", cbVar.bnQ().getName_show());
            t.csB().e(arVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
