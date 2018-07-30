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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dut;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dut = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayb */
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dyV.setViewPool(this.dut);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.anq() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyT.setText(hVar.anq().title);
            aVar.dyT.setTextColor(am.getColor(skinType, d.C0140d.cp_cont_b));
            aVar.dyV.setPageContext(this.mPageContext);
            aVar.dyV.setData(hVar.anq().sub_nodes);
            aVar.dyU.setMaxOverScrollDistance(aVar.dyV.getChildItemWidth());
            aVar.dyS.setBackgroundColor(am.getColor(skinType, d.C0140d.cp_bg_line_d));
            am.i(aVar.dyG, d.C0140d.cp_bg_line_e);
            am.i(aVar.dcA, d.C0140d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcA;
        private View dyG;
        private LinearLayout dyS;
        private TextView dyT;
        private FlexibleHorizontalScrollView dyU;
        private CardFrsGameSpecialTopicLayout dyV;

        public a(View view) {
            super(view);
            this.dyS = (LinearLayout) view.findViewById(d.g.card_game_special_topic_content);
            this.dyT = (TextView) view.findViewById(d.g.game_special_topic_title);
            this.dyU = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_special_topic_scroll_container);
            this.dyV = (CardFrsGameSpecialTopicLayout) view.findViewById(d.g.game_special_topic_container);
            this.dyV.setItemSpace(l.f(view.getContext(), d.e.tbds20));
            this.dyV.setItemWidth(((l.f(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dyG = view.findViewById(d.g.divider_line_1);
            this.dcA = view.findViewById(d.g.divider_line_2);
        }
    }
}
