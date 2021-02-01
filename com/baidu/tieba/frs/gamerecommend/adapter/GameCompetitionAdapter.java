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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class GameCompetitionAdapter extends k<com.baidu.tieba.e.c, CardFrsGameCompetitionHolder> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> jrL;
    private String mForumId;

    public GameCompetitionAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jrL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cIb */
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
        cardFrsGameCompetitionHolder.jzm.setViewPool(this.jrL);
        return cardFrsGameCompetitionHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        if (cVar != null && cVar.ctQ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameCompetitionHolder.jzk.setText(cVar.ctQ().title);
            cardFrsGameCompetitionHolder.jzk.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameCompetitionHolder.jzm.setPageContext(this.mPageContext);
            cardFrsGameCompetitionHolder.jzm.setData(cVar.ctQ().sub_nodes);
            cardFrsGameCompetitionHolder.jzl.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.jzm.getChildItemWidth());
            cardFrsGameCompetitionHolder.jzj.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(cardFrsGameCompetitionHolder.jzn, R.color.CAM_X0205);
            ap.setBackgroundResource(cardFrsGameCompetitionHolder.iZj, R.color.CAM_X0205);
        }
        return cardFrsGameCompetitionHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        private View iZj;
        private LinearLayout jzj;
        private TextView jzk;
        private FlexibleHorizontalScrollView jzl;
        private CardFrsGameCompetitionLayout jzm;
        private View jzn;

        public CardFrsGameCompetitionHolder(View view) {
            super(view);
            this.jzj = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.jzk = (TextView) view.findViewById(R.id.game_competition_title);
            this.jzl = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.jzm = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.jzm.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jzm.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jzn = view.findViewById(R.id.divider_line_1);
            this.iZj = view.findViewById(R.id.divider_line_2);
        }
    }
}
