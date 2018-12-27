package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> dTv;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aFC */
            public CardFrsGameRecommendGameItemView jz() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void u(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView v(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameRecommendGameItemView w(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.dXR.setViewPool(this.dTv);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.auB() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dXP.setText(fVar.auB().title);
            aVar.dXP.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dXR.setPageContext(this.mPageContext);
            aVar.dXR.setData(fVar.auB().sub_nodes);
            aVar.dXQ.setMaxOverScrollDistance(aVar.dXR.getChildItemWidth());
            aVar.dXO.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dXJ, e.d.cp_bg_line_e);
            al.i(aVar.dAN, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dAN;
        private View dXJ;
        private LinearLayout dXO;
        private TextView dXP;
        private FlexibleHorizontalScrollView dXQ;
        private CardFrsGameRecommendGameLayout dXR;

        public a(View view) {
            super(view);
            this.dXO = (LinearLayout) view.findViewById(e.g.card_game_recommend_content);
            this.dXP = (TextView) view.findViewById(e.g.game_recommend_title);
            this.dXQ = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_recommend_scroll_container);
            this.dXR = (CardFrsGameRecommendGameLayout) view.findViewById(e.g.game_recommend_container);
            this.dXR.setItemSpace(l.h(view.getContext(), e.C0210e.tbds27));
            this.dXR.setItemWidth(l.h(view.getContext(), e.C0210e.tbds192));
            this.dXJ = view.findViewById(e.g.divider_line_1);
            this.dAN = view.findViewById(e.g.divider_line_2);
        }
    }
}
