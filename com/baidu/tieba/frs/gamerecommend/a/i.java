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
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> drG;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.drG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axw */
            public CardFrsGameSpecialTopicItemView mo9if() {
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dwi.setViewPool(this.drG);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.amR() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dwg.setText(hVar.amR().title);
            aVar.dwg.setTextColor(am.getColor(skinType, d.C0142d.cp_cont_b));
            aVar.dwi.setPageContext(this.mPageContext);
            aVar.dwi.setData(hVar.amR().sub_nodes);
            aVar.dwh.setMaxOverScrollDistance(aVar.dwi.getChildItemWidth());
            aVar.dwf.setBackgroundColor(am.getColor(skinType, d.C0142d.cp_bg_line_d));
            am.i(aVar.dvT, d.C0142d.cp_bg_line_e);
            am.i(aVar.cZI, d.C0142d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cZI;
        private View dvT;
        private LinearLayout dwf;
        private TextView dwg;
        private FlexibleHorizontalScrollView dwh;
        private CardFrsGameSpecialTopicLayout dwi;

        public a(View view) {
            super(view);
            this.dwf = (LinearLayout) view.findViewById(d.g.card_game_special_topic_content);
            this.dwg = (TextView) view.findViewById(d.g.game_special_topic_title);
            this.dwh = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_special_topic_scroll_container);
            this.dwi = (CardFrsGameSpecialTopicLayout) view.findViewById(d.g.game_special_topic_container);
            this.dwi.setItemSpace(l.e(view.getContext(), d.e.tbds20));
            this.dwi.setItemWidth(((l.e(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dvT = view.findViewById(d.g.divider_line_1);
            this.cZI = view.findViewById(d.g.divider_line_2);
        }
    }
}
