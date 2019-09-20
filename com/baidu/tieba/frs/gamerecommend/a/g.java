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
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> fFu;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fFu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bqJ */
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
        aVar.fJJ.setViewPool(this.fFu);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.beG() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fJH.setText(fVar.beG().title);
            aVar.fJH.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.fJJ.setPageContext(this.mPageContext);
            aVar.fJJ.setData(fVar.beG().sub_nodes);
            aVar.fJI.setMaxOverScrollDistance(aVar.fJJ.getChildItemWidth());
            aVar.fJG.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.k(aVar.fJB, R.color.cp_bg_line_e);
            am.k(aVar.flY, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View fJB;
        private LinearLayout fJG;
        private TextView fJH;
        private FlexibleHorizontalScrollView fJI;
        private CardFrsGameRecommendGameLayout fJJ;
        private View flY;

        public a(View view) {
            super(view);
            this.fJG = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.fJH = (TextView) view.findViewById(R.id.game_recommend_title);
            this.fJI = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.fJJ = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.fJJ.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.fJJ.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.fJB = view.findViewById(R.id.divider_line_1);
            this.flY = view.findViewById(R.id.divider_line_2);
        }
    }
}
