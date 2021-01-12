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
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> jme;
    private String mForumId;

    public GameSpecialTopicAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jme = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cGQ */
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
        cardFrsGameSpecialTopicHolder.jtW.setViewPool(this.jme);
        return cardFrsGameSpecialTopicHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        if (hVar != null && hVar.csJ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameSpecialTopicHolder.jtU.setText(hVar.csJ().title);
            cardFrsGameSpecialTopicHolder.jtU.setTextColor(ao.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameSpecialTopicHolder.jtW.setPageContext(this.mPageContext);
            cardFrsGameSpecialTopicHolder.jtW.setData(hVar.csJ().sub_nodes);
            cardFrsGameSpecialTopicHolder.jtV.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.jtW.getChildItemWidth());
            cardFrsGameSpecialTopicHolder.jtT.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0201));
            ao.setBackgroundResource(cardFrsGameSpecialTopicHolder.jtH, R.color.CAM_X0205);
            ao.setBackgroundResource(cardFrsGameSpecialTopicHolder.iTC, R.color.CAM_X0205);
        }
        return cardFrsGameSpecialTopicHolder.getView();
    }

    /* loaded from: classes2.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {
        private View iTC;
        private View jtH;
        private LinearLayout jtT;
        private TextView jtU;
        private FlexibleHorizontalScrollView jtV;
        private CardFrsGameSpecialTopicLayout jtW;

        public CardFrsGameSpecialTopicHolder(View view) {
            super(view);
            this.jtT = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.jtU = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.jtV = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.jtW = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.jtW.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jtW.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jtH = view.findViewById(R.id.divider_line_1);
            this.iTC = view.findViewById(R.id.divider_line_2);
        }
    }
}
