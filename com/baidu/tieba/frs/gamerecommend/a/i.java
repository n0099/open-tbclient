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
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> fFu;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fFu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bqK */
            public CardFrsGameSpecialTopicItemView makeObject() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView activateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
    /* renamed from: aY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.fJQ.setViewPool(this.fFu);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.beI() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fJO.setText(hVar.beI().title);
            aVar.fJO.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.fJQ.setPageContext(this.mPageContext);
            aVar.fJQ.setData(hVar.beI().sub_nodes);
            aVar.fJP.setMaxOverScrollDistance(aVar.fJQ.getChildItemWidth());
            aVar.fJN.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.k(aVar.fJB, R.color.cp_bg_line_e);
            am.k(aVar.flY, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View fJB;
        private LinearLayout fJN;
        private TextView fJO;
        private FlexibleHorizontalScrollView fJP;
        private CardFrsGameSpecialTopicLayout fJQ;
        private View flY;

        public a(View view) {
            super(view);
            this.fJN = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.fJO = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.fJP = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.fJQ = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.fJQ.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.fJQ.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.fJB = view.findViewById(R.id.divider_line_1);
            this.flY = view.findViewById(R.id.divider_line_2);
        }
    }
}
