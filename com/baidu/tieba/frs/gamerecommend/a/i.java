package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dIX;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDH */
            public CardFrsGameSpecialTopicItemView jB() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void u(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView v(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameSpecialTopicItemView w(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dNB.setViewPool(this.dIX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.asC() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dNz.setText(hVar.asC().title);
            aVar.dNz.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dNB.setPageContext(this.mPageContext);
            aVar.dNB.setData(hVar.asC().sub_nodes);
            aVar.dNA.setMaxOverScrollDistance(aVar.dNB.getChildItemWidth());
            aVar.dNy.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dNm, e.d.cp_bg_line_e);
            al.i(aVar.dqw, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private FlexibleHorizontalScrollView dNA;
        private CardFrsGameSpecialTopicLayout dNB;
        private View dNm;
        private LinearLayout dNy;
        private TextView dNz;
        private View dqw;

        public a(View view) {
            super(view);
            this.dNy = (LinearLayout) view.findViewById(e.g.card_game_special_topic_content);
            this.dNz = (TextView) view.findViewById(e.g.game_special_topic_title);
            this.dNA = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_special_topic_scroll_container);
            this.dNB = (CardFrsGameSpecialTopicLayout) view.findViewById(e.g.game_special_topic_container);
            this.dNB.setItemSpace(l.h(view.getContext(), e.C0175e.tbds20));
            this.dNB.setItemWidth(((l.h(view.getContext(), e.C0175e.tbds170) * 2) * 21) / 9);
            this.dNm = view.findViewById(e.g.divider_line_1);
            this.dqw = view.findViewById(e.g.divider_line_2);
        }
    }
}
