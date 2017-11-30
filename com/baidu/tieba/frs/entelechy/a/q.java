package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.frs.d<com.baidu.tieba.frs.q, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.g> cNV;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cNV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.g>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anE */
            public com.baidu.tieba.frs.view.g fI() {
                return new com.baidu.tieba.frs.view.g(q.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(com.baidu.tieba.frs.view.g gVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.frs.view.g o(com.baidu.tieba.frs.view.g gVar) {
                return gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.frs.view.g p(com.baidu.tieba.frs.view.g gVar) {
                return gVar;
            }
        }, 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, (ViewGroup) null, true));
        aVar.cNY.setViewPool(this.cNV);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.cNZ.setText(qVar.amm());
            aVar.cNY.setPageContext(this.mPageContext);
            aVar.cNY.setData(qVar.getUserInfo());
            aVar.cNX.setMaxOverScrollDistance(aVar.cNY.getChildItemWidth());
            aVar.cNZ.setTextColor(aj.getColor(skinType, d.C0082d.cp_cont_b));
            aVar.aMp.setBackgroundColor(aj.getColor(skinType, d.C0082d.cp_bg_line_e));
            if (!qVar.amn()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.abU().a(new ak("c12530").ac("obj_id", metaData.getUserId()));
                    }
                }
                qVar.fa(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        LinearLayout aMp;
        FlexibleHorizontalScrollView cNX;
        UserRecommendLayout cNY;
        TextView cNZ;
        View.OnClickListener cOa;
        View.OnClickListener cOb;

        public a(View view) {
            super(view);
            this.cOa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a wS;
                    if (a.this.cNX != null && a.this.cNY != null) {
                        a.this.cNX.smoothScrollBy(a.this.cNY.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (wS = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).wS()) != null) {
                            a.this.T(wS.getUserId(), 2);
                        }
                    }
                }
            };
            this.cOb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.T(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.cNX = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.cNY = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.cNY.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds16));
            this.cNY.setAfterLikeBtnClickListener(this.cOa);
            this.cNY.setAfterHeaderLickListener(this.cOb);
            this.cNZ = (TextView) view.findViewById(d.g.user_recommend_document);
            this.aMp = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").r("obj_locate", i).ac("obj_id", str));
            }
        }
    }
}
