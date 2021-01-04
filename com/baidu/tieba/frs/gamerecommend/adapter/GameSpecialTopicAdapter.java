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
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.e.h;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class GameSpecialTopicAdapter extends k<h, CardFrsGameSpecialTopicHolder> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> jqL;
    private String mForumId;

    public GameSpecialTopicAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cKH */
            public CardFrsGameSpecialTopicItemView makeObject() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(GameSpecialTopicAdapter.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(GameSpecialTopicAdapter.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView activateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public CardFrsGameSpecialTopicItemView passivateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public CardFrsGameSpecialTopicHolder e(ViewGroup viewGroup) {
        CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        cardFrsGameSpecialTopicHolder.jyC.setViewPool(this.jqL);
        return cardFrsGameSpecialTopicHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        if (hVar != null && hVar.cwA() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameSpecialTopicHolder.jyA.setText(hVar.cwA().title);
            cardFrsGameSpecialTopicHolder.jyA.setTextColor(ao.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameSpecialTopicHolder.jyC.setPageContext(this.mPageContext);
            cardFrsGameSpecialTopicHolder.jyC.setData(hVar.cwA().sub_nodes);
            cardFrsGameSpecialTopicHolder.jyB.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.jyC.getChildItemWidth());
            cardFrsGameSpecialTopicHolder.jyz.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0201));
            ao.setBackgroundResource(cardFrsGameSpecialTopicHolder.jyn, R.color.CAM_X0205);
            ao.setBackgroundResource(cardFrsGameSpecialTopicHolder.iYj, R.color.CAM_X0205);
        }
        return cardFrsGameSpecialTopicHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {
        private View iYj;
        private TextView jyA;
        private FlexibleHorizontalScrollView jyB;
        private CardFrsGameSpecialTopicLayout jyC;
        private View jyn;
        private LinearLayout jyz;

        public CardFrsGameSpecialTopicHolder(View view) {
            super(view);
            this.jyz = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.jyA = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.jyB = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.jyC = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.jyC.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jyC.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jyn = view.findViewById(R.id.divider_line_1);
            this.iYj = view.findViewById(R.id.divider_line_2);
        }
    }
}
