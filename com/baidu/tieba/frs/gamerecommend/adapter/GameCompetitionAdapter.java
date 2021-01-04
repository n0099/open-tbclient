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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class GameCompetitionAdapter extends k<com.baidu.tieba.e.c, CardFrsGameCompetitionHolder> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> jqL;
    private String mForumId;

    public GameCompetitionAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cKF */
            public CardFrsGameCompetitionItemView makeObject() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(GameCompetitionAdapter.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(GameCompetitionAdapter.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView activateObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public CardFrsGameCompetitionItemView passivateObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public CardFrsGameCompetitionHolder e(ViewGroup viewGroup) {
        CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        cardFrsGameCompetitionHolder.jym.setViewPool(this.jqL);
        return cardFrsGameCompetitionHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        if (cVar != null && cVar.cwv() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameCompetitionHolder.jyk.setText(cVar.cwv().title);
            cardFrsGameCompetitionHolder.jyk.setTextColor(ao.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameCompetitionHolder.jym.setPageContext(this.mPageContext);
            cardFrsGameCompetitionHolder.jym.setData(cVar.cwv().sub_nodes);
            cardFrsGameCompetitionHolder.jyl.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.jym.getChildItemWidth());
            cardFrsGameCompetitionHolder.jyj.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0201));
            ao.setBackgroundResource(cardFrsGameCompetitionHolder.jyn, R.color.CAM_X0205);
            ao.setBackgroundResource(cardFrsGameCompetitionHolder.iYj, R.color.CAM_X0205);
        }
        return cardFrsGameCompetitionHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        private View iYj;
        private LinearLayout jyj;
        private TextView jyk;
        private FlexibleHorizontalScrollView jyl;
        private CardFrsGameCompetitionLayout jym;
        private View jyn;

        public CardFrsGameCompetitionHolder(View view) {
            super(view);
            this.jyj = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.jyk = (TextView) view.findViewById(R.id.game_competition_title);
            this.jyl = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.jym = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.jym.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jym.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jyn = view.findViewById(R.id.divider_line_1);
            this.iYj = view.findViewById(R.id.divider_line_2);
        }
    }
}
