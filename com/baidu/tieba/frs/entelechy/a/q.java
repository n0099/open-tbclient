package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
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
/* loaded from: classes2.dex */
public class q extends com.baidu.tieba.frs.g<com.baidu.tieba.frs.s, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.h> dIg;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.h>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awy */
            public com.baidu.tieba.frs.view.h nl() {
                return new com.baidu.tieba.frs.view.h(q.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(com.baidu.tieba.frs.view.h hVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.frs.view.h at(com.baidu.tieba.frs.view.h hVar) {
                return hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.frs.view.h au(com.baidu.tieba.frs.view.h hVar) {
                return hVar;
            }
        }, 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, viewGroup, false));
        aVar.dIj.setViewPool(this.dIg);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.s sVar, a aVar) {
        if (sVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dIk.setText(sVar.avl());
            aVar.dIj.setPageContext(this.mPageContext);
            aVar.dIj.setData(sVar.getUserInfo());
            aVar.dIi.setMaxOverScrollDistance(aVar.dIj.getChildItemWidth());
            aVar.dIk.setTextColor(aj.getColor(skinType, d.C0108d.cp_cont_b));
            aVar.bAA.setBackgroundColor(aj.getColor(skinType, d.C0108d.cp_bg_line_e));
            if (!sVar.avm()) {
                for (MetaData metaData : sVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.akK().a(new ak("c12530").aa("obj_id", metaData.getUserId()));
                    }
                }
                sVar.fN(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        LinearLayout bAA;
        FlexibleHorizontalScrollView dIi;
        UserRecommendLayout dIj;
        TextView dIk;
        View.OnClickListener dIl;
        View.OnClickListener dIm;

        public a(View view) {
            super(view);
            this.dIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a Ej;
                    if (a.this.dIi != null && a.this.dIj != null) {
                        a.this.dIi.smoothScrollBy(a.this.dIj.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (Ej = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).Ej()) != null) {
                            a.this.Y(Ej.getUserId(), 2);
                        }
                    }
                }
            };
            this.dIm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.Y(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.dIi = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.dIj = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.dIj.setItemSpace(com.baidu.adp.lib.util.l.s(view.getContext(), d.e.ds16));
            this.dIj.setAfterLikeBtnClickListener(this.dIl);
            this.dIj.setAfterHeaderLickListener(this.dIm);
            this.dIk = (TextView) view.findViewById(d.g.user_recommend_document);
            this.bAA = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").s("obj_locate", i).aa("obj_id", str));
            }
        }
    }
}
