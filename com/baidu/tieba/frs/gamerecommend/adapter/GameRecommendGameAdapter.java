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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class GameRecommendGameAdapter extends k<com.baidu.tieba.e.f, CardFrsGameRecommendGameHolder> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> jrL;
    private String mForumId;

    public GameRecommendGameAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jrL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cIc */
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
        cardFrsGameRecommendGameHolder.jzv.setViewPool(this.jrL);
        return cardFrsGameRecommendGameHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        if (fVar != null && fVar.ctT() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameRecommendGameHolder.jzt.setText(fVar.ctT().title);
            cardFrsGameRecommendGameHolder.jzt.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameRecommendGameHolder.jzv.setPageContext(this.mPageContext);
            cardFrsGameRecommendGameHolder.jzv.setData(fVar.ctT().sub_nodes);
            cardFrsGameRecommendGameHolder.jzu.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.jzv.getChildItemWidth());
            cardFrsGameRecommendGameHolder.jzs.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(cardFrsGameRecommendGameHolder.jzn, R.color.CAM_X0205);
            ap.setBackgroundResource(cardFrsGameRecommendGameHolder.iZj, R.color.CAM_X0205);
        }
        return cardFrsGameRecommendGameHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {
        private View iZj;
        private View jzn;
        private LinearLayout jzs;
        private TextView jzt;
        private FlexibleHorizontalScrollView jzu;
        private CardFrsGameRecommendGameLayout jzv;

        public CardFrsGameRecommendGameHolder(View view) {
            super(view);
            this.jzs = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.jzt = (TextView) view.findViewById(R.id.game_recommend_title);
            this.jzu = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.jzv = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.jzv.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.jzv.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.jzn = view.findViewById(R.id.divider_line_1);
            this.iZj = view.findViewById(R.id.divider_line_2);
        }
    }
}
