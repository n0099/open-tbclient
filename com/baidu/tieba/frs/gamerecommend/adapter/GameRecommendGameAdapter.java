package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class GameRecommendGameAdapter extends k<com.baidu.tieba.e.f, CardFrsGameRecommendGameHolder> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> jqL;
    private String mForumId;

    public GameRecommendGameAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cKG */
            public CardFrsGameRecommendGameItemView makeObject() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(GameRecommendGameAdapter.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(GameRecommendGameAdapter.this.mForumId);
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
    /* renamed from: bI */
    public CardFrsGameRecommendGameHolder e(ViewGroup viewGroup) {
        CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        cardFrsGameRecommendGameHolder.jyv.setViewPool(this.jqL);
        return cardFrsGameRecommendGameHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        if (fVar != null && fVar.cwy() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameRecommendGameHolder.jyt.setText(fVar.cwy().title);
            cardFrsGameRecommendGameHolder.jyt.setTextColor(ao.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameRecommendGameHolder.jyv.setPageContext(this.mPageContext);
            cardFrsGameRecommendGameHolder.jyv.setData(fVar.cwy().sub_nodes);
            cardFrsGameRecommendGameHolder.jyu.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.jyv.getChildItemWidth());
            cardFrsGameRecommendGameHolder.jys.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0201));
            ao.setBackgroundResource(cardFrsGameRecommendGameHolder.jyn, R.color.CAM_X0205);
            ao.setBackgroundResource(cardFrsGameRecommendGameHolder.iYj, R.color.CAM_X0205);
        }
        return cardFrsGameRecommendGameHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {
        private View iYj;
        private View jyn;
        private LinearLayout jys;
        private TextView jyt;
        private FlexibleHorizontalScrollView jyu;
        private CardFrsGameRecommendGameLayout jyv;

        public CardFrsGameRecommendGameHolder(View view) {
            super(view);
            this.jys = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.jyt = (TextView) view.findViewById(R.id.game_recommend_title);
            this.jyu = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.jyv = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.jyv.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.jyv.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.jyn = view.findViewById(R.id.divider_line_1);
            this.iYj = view.findViewById(R.id.divider_line_2);
        }
    }
}
