package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> hwW;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hwW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bZd */
            public CardFrsGameRecommendGameItemView makeObject() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView activateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
    /* renamed from: bo */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.hBZ.setViewPool(this.hwW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.bMQ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hBX.setText(fVar.bMQ().title);
            aVar.hBX.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.hBZ.setPageContext(this.mPageContext);
            aVar.hBZ.setData(fVar.bMQ().sub_nodes);
            aVar.hBY.setMaxOverScrollDistance(aVar.hBZ.getChildItemWidth());
            aVar.hBW.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.hBR, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.hgD, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends aa.a {
        private View hBR;
        private LinearLayout hBW;
        private TextView hBX;
        private FlexibleHorizontalScrollView hBY;
        private CardFrsGameRecommendGameLayout hBZ;
        private View hgD;

        public a(View view) {
            super(view);
            this.hBW = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.hBX = (TextView) view.findViewById(R.id.game_recommend_title);
            this.hBY = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.hBZ = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.hBZ.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.hBZ.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.hBR = view.findViewById(R.id.divider_line_1);
            this.hgD = view.findViewById(R.id.divider_line_2);
        }
    }
}
