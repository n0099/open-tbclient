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
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.frs.d<com.baidu.tieba.frs.q, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.g> cEw;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cEw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.g>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alv */
            public com.baidu.tieba.frs.view.g fI() {
                return new com.baidu.tieba.frs.view.g(p.this.mContext);
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
    /* renamed from: ao */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, (ViewGroup) null, true));
        aVar.cEz.setViewPool(this.cEw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.cEA.setText(qVar.akc());
            aVar.cEz.setPageContext(this.mPageContext);
            aVar.cEz.setData(qVar.getUserInfo());
            aVar.cEy.setMaxOverScrollDistance(aVar.cEz.getChildItemWidth());
            aVar.cEA.setTextColor(aj.getColor(skinType, d.C0080d.cp_cont_b));
            aVar.aLG.setBackgroundColor(aj.getColor(skinType, d.C0080d.cp_bg_line_e));
            if (!qVar.akd()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        u.ZX().a(new ak("c12530").ac("obj_id", metaData.getUserId()));
                    }
                }
                qVar.eE(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        LinearLayout aLG;
        TextView cEA;
        View.OnClickListener cEB;
        View.OnClickListener cEC;
        FlexibleHorizontalScrollView cEy;
        UserRecommendLayout cEz;

        public a(View view) {
            super(view);
            this.cEB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a wR;
                    if (a.this.cEy != null && a.this.cEz != null) {
                        a.this.cEy.smoothScrollBy(a.this.cEz.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (wR = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).wR()) != null) {
                            a.this.R(wR.getUserId(), 2);
                        }
                    }
                }
            };
            this.cEC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.R(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.cEy = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.cEz = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.cEz.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds16));
            this.cEz.setAfterLikeBtnClickListener(this.cEB);
            this.cEz.setAfterHeaderLickListener(this.cEC);
            this.cEA = (TextView) view.findViewById(d.g.user_recommend_document);
            this.aLG = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").r("obj_locate", i).ac("obj_id", str));
            }
        }
    }
}
