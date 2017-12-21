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
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes.dex */
public class q extends e<com.baidu.tieba.frs.r, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.h> cOk;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cOk = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.h>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anN */
            public com.baidu.tieba.frs.view.h fI() {
                return new com.baidu.tieba.frs.view.h(q.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(com.baidu.tieba.frs.view.h hVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.frs.view.h o(com.baidu.tieba.frs.view.h hVar) {
                return hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.frs.view.h p(com.baidu.tieba.frs.view.h hVar) {
                return hVar;
            }
        }, 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, (ViewGroup) null, true));
        aVar.cOn.setViewPool(this.cOk);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.r rVar, a aVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.cOo.setText(rVar.amv());
            aVar.cOn.setPageContext(this.mPageContext);
            aVar.cOn.setData(rVar.getUserInfo());
            aVar.cOm.setMaxOverScrollDistance(aVar.cOn.getChildItemWidth());
            aVar.cOo.setTextColor(aj.getColor(skinType, d.C0095d.cp_cont_b));
            aVar.aMw.setBackgroundColor(aj.getColor(skinType, d.C0095d.cp_bg_line_e));
            if (!rVar.amw()) {
                for (MetaData metaData : rVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.abW().a(new ak("c12530").ac("obj_id", metaData.getUserId()));
                    }
                }
                rVar.fb(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        LinearLayout aMw;
        FlexibleHorizontalScrollView cOm;
        UserRecommendLayout cOn;
        TextView cOo;
        View.OnClickListener cOp;
        View.OnClickListener cOq;

        public a(View view) {
            super(view);
            this.cOp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a wR;
                    if (a.this.cOm != null && a.this.cOn != null) {
                        a.this.cOm.smoothScrollBy(a.this.cOn.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (wR = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).wR()) != null) {
                            a.this.U(wR.getUserId(), 2);
                        }
                    }
                }
            };
            this.cOq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.q.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.U(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.cOm = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.cOn = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.cOn.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds16));
            this.cOn.setAfterLikeBtnClickListener(this.cOp);
            this.cOn.setAfterHeaderLickListener(this.cOq);
            this.cOo = (TextView) view.findViewById(d.g.user_recommend_document);
            this.aMw = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").r("obj_locate", i).ac("obj_id", str));
            }
        }
    }
}
