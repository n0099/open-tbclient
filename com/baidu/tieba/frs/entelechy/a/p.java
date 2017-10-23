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
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.g> cwN;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.g>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aji */
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
    /* renamed from: X */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.j.card_user_recommend_layout, (ViewGroup) null, true));
        aVar.cwQ.setViewPool(this.cwN);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.cwR.setText(qVar.ahU());
            aVar.cwQ.setPageContext(this.mH);
            aVar.cwQ.setData(qVar.getUserInfo());
            aVar.cwP.setMaxOverScrollDistance(aVar.cwQ.getChildItemWidth());
            aVar.cwR.setTextColor(aj.getColor(skinType, d.e.cp_cont_b));
            aVar.aKW.setBackgroundColor(aj.getColor(skinType, d.e.cp_bg_line_e));
            if (!qVar.ahV()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        u.XN().a(new ak("c12530").ac("obj_id", metaData.getUserId()));
                    }
                }
                qVar.eI(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        LinearLayout aKW;
        FlexibleHorizontalScrollView cwP;
        UserRecommendLayout cwQ;
        TextView cwR;
        View.OnClickListener cwS;
        View.OnClickListener cwT;

        public a(View view) {
            super(view);
            this.cwS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a wK;
                    if (a.this.cwP != null && a.this.cwQ != null) {
                        a.this.cwP.smoothScrollBy(a.this.cwQ.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (wK = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).wK()) != null) {
                            a.this.L(wK.getUserId(), 2);
                        }
                    }
                }
            };
            this.cwT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.L(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.cwP = (FlexibleHorizontalScrollView) view.findViewById(d.h.user_recommend_scroll_container);
            this.cwQ = (UserRecommendLayout) view.findViewById(d.h.user_recommend_container);
            this.cwQ.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.f.ds16));
            this.cwQ.setAfterLikeBtnClickListener(this.cwS);
            this.cwQ.setAfterHeaderLickListener(this.cwT);
            this.cwR = (TextView) view.findViewById(d.h.user_recommend_document);
            this.aKW = (LinearLayout) view.findViewById(d.h.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").r("obj_locate", i).ac("obj_id", str));
            }
        }
    }
}
