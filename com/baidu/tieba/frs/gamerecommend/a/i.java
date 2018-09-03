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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> duq;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.duq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axZ */
            public CardFrsGameSpecialTopicItemView ig() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void q(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView r(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameSpecialTopicItemView s(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(f.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dyS.setViewPool(this.duq);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.ans() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyQ.setText(hVar.ans().title);
            aVar.dyQ.setTextColor(am.getColor(skinType, f.d.cp_cont_b));
            aVar.dyS.setPageContext(this.mPageContext);
            aVar.dyS.setData(hVar.ans().sub_nodes);
            aVar.dyR.setMaxOverScrollDistance(aVar.dyS.getChildItemWidth());
            aVar.dyP.setBackgroundColor(am.getColor(skinType, f.d.cp_bg_line_d));
            am.i(aVar.dyD, f.d.cp_bg_line_e);
            am.i(aVar.dcy, f.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcy;
        private View dyD;
        private LinearLayout dyP;
        private TextView dyQ;
        private FlexibleHorizontalScrollView dyR;
        private CardFrsGameSpecialTopicLayout dyS;

        public a(View view) {
            super(view);
            this.dyP = (LinearLayout) view.findViewById(f.g.card_game_special_topic_content);
            this.dyQ = (TextView) view.findViewById(f.g.game_special_topic_title);
            this.dyR = (FlexibleHorizontalScrollView) view.findViewById(f.g.game_special_topic_scroll_container);
            this.dyS = (CardFrsGameSpecialTopicLayout) view.findViewById(f.g.game_special_topic_container);
            this.dyS.setItemSpace(l.f(view.getContext(), f.e.tbds20));
            this.dyS.setItemWidth(((l.f(view.getContext(), f.e.tbds170) * 2) * 21) / 9);
            this.dyD = view.findViewById(f.g.divider_line_1);
            this.dcy = view.findViewById(f.g.divider_line_2);
        }
    }
}
