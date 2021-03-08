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
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> jtI;
    private String mForumId;

    public GameCompetitionAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jtI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cIo */
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
        cardFrsGameCompetitionHolder.jBj.setViewPool(this.jtI);
        return cardFrsGameCompetitionHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        if (cVar != null && cVar.cud() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameCompetitionHolder.jBh.setText(cVar.cud().title);
            cardFrsGameCompetitionHolder.jBh.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameCompetitionHolder.jBj.setPageContext(this.mPageContext);
            cardFrsGameCompetitionHolder.jBj.setData(cVar.cud().sub_nodes);
            cardFrsGameCompetitionHolder.jBi.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.jBj.getChildItemWidth());
            cardFrsGameCompetitionHolder.jBg.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(cardFrsGameCompetitionHolder.jBk, R.color.CAM_X0205);
            ap.setBackgroundResource(cardFrsGameCompetitionHolder.jbg, R.color.CAM_X0205);
        }
        return cardFrsGameCompetitionHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        private LinearLayout jBg;
        private TextView jBh;
        private FlexibleHorizontalScrollView jBi;
        private CardFrsGameCompetitionLayout jBj;
        private View jBk;
        private View jbg;

        public CardFrsGameCompetitionHolder(View view) {
            super(view);
            this.jBg = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.jBh = (TextView) view.findViewById(R.id.game_competition_title);
            this.jBi = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.jBj = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.jBj.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jBj.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jBk = view.findViewById(R.id.divider_line_1);
            this.jbg = view.findViewById(R.id.divider_line_2);
        }
    }
}
