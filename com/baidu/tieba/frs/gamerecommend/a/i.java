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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> fhA;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fhA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgq */
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
    /* renamed from: aU */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.flT.setViewPool(this.fhA);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.aUQ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.flR.setText(hVar.aUQ().title);
            aVar.flR.setTextColor(al.getColor(skinType, d.C0277d.cp_cont_b));
            aVar.flT.setPageContext(this.mPageContext);
            aVar.flT.setData(hVar.aUQ().sub_nodes);
            aVar.flS.setMaxOverScrollDistance(aVar.flT.getChildItemWidth());
            aVar.flQ.setBackgroundColor(al.getColor(skinType, d.C0277d.cp_bg_line_d));
            al.k(aVar.flE, d.C0277d.cp_bg_line_e);
            al.k(aVar.eOA, d.C0277d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View eOA;
        private View flE;
        private LinearLayout flQ;
        private TextView flR;
        private FlexibleHorizontalScrollView flS;
        private CardFrsGameSpecialTopicLayout flT;

        public a(View view) {
            super(view);
            this.flQ = (LinearLayout) view.findViewById(d.g.card_game_special_topic_content);
            this.flR = (TextView) view.findViewById(d.g.game_special_topic_title);
            this.flS = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_special_topic_scroll_container);
            this.flT = (CardFrsGameSpecialTopicLayout) view.findViewById(d.g.game_special_topic_container);
            this.flT.setItemSpace(l.h(view.getContext(), d.e.tbds20));
            this.flT.setItemWidth(((l.h(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.flE = view.findViewById(d.g.divider_line_1);
            this.eOA = view.findViewById(d.g.divider_line_2);
        }
    }
}
