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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.f<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dfi;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dfi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: asM */
            public CardFrsGameSpecialTopicItemView fo() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView o(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameSpecialTopicItemView p(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.djL.setViewPool(this.dfi);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.ajA() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.djJ.setText(hVar.ajA().title);
            aVar.djJ.setTextColor(ak.getColor(skinType, d.C0126d.cp_cont_b));
            aVar.djL.setPageContext(this.mPageContext);
            aVar.djL.setData(hVar.ajA().sub_nodes);
            aVar.djK.setMaxOverScrollDistance(aVar.djL.getChildItemWidth());
            aVar.djI.setBackgroundColor(ak.getColor(skinType, d.C0126d.cp_bg_line_d));
            ak.i(aVar.djw, d.C0126d.cp_bg_line_e);
            ak.i(aVar.cSA, d.C0126d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cSA;
        private LinearLayout djI;
        private TextView djJ;
        private FlexibleHorizontalScrollView djK;
        private CardFrsGameSpecialTopicLayout djL;
        private View djw;

        public a(View view2) {
            super(view2);
            this.djI = (LinearLayout) view2.findViewById(d.g.card_game_special_topic_content);
            this.djJ = (TextView) view2.findViewById(d.g.game_special_topic_title);
            this.djK = (FlexibleHorizontalScrollView) view2.findViewById(d.g.game_special_topic_scroll_container);
            this.djL = (CardFrsGameSpecialTopicLayout) view2.findViewById(d.g.game_special_topic_container);
            this.djL.setItemSpace(l.e(view2.getContext(), d.e.tbds20));
            this.djL.setItemWidth(((l.e(view2.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.djw = view2.findViewById(d.g.divider_line_1);
            this.cSA = view2.findViewById(d.g.divider_line_2);
        }
    }
}
