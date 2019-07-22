package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> fCT;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCT = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bpK */
            public CardFrsGameRecommendGameItemView makeObject() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView activateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameRecommendGameItemView passivateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.fHg.setViewPool(this.fCT);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.bea() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fHe.setText(fVar.bea().title);
            aVar.fHe.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.fHg.setPageContext(this.mPageContext);
            aVar.fHg.setData(fVar.bea().sub_nodes);
            aVar.fHf.setMaxOverScrollDistance(aVar.fHg.getChildItemWidth());
            aVar.fHd.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.k(aVar.fGY, R.color.cp_bg_line_e);
            am.k(aVar.fjL, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View fGY;
        private LinearLayout fHd;
        private TextView fHe;
        private FlexibleHorizontalScrollView fHf;
        private CardFrsGameRecommendGameLayout fHg;
        private View fjL;

        public a(View view) {
            super(view);
            this.fHd = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.fHe = (TextView) view.findViewById(R.id.game_recommend_title);
            this.fHf = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.fHg = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.fHg.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.fHg.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.fGY = view.findViewById(R.id.divider_line_1);
            this.fjL = view.findViewById(R.id.divider_line_2);
        }
    }
}
