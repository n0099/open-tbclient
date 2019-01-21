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
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dUc;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dUc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGa */
            public CardFrsGameSpecialTopicItemView jz() {
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
    /* renamed from: aF */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dYF.setViewPool(this.dUc);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.avb() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dYD.setText(hVar.avb().title);
            aVar.dYD.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dYF.setPageContext(this.mPageContext);
            aVar.dYF.setData(hVar.avb().sub_nodes);
            aVar.dYE.setMaxOverScrollDistance(aVar.dYF.getChildItemWidth());
            aVar.dYC.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dYq, e.d.cp_bg_line_e);
            al.i(aVar.dBx, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dBx;
        private LinearLayout dYC;
        private TextView dYD;
        private FlexibleHorizontalScrollView dYE;
        private CardFrsGameSpecialTopicLayout dYF;
        private View dYq;

        public a(View view) {
            super(view);
            this.dYC = (LinearLayout) view.findViewById(e.g.card_game_special_topic_content);
            this.dYD = (TextView) view.findViewById(e.g.game_special_topic_title);
            this.dYE = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_special_topic_scroll_container);
            this.dYF = (CardFrsGameSpecialTopicLayout) view.findViewById(e.g.game_special_topic_container);
            this.dYF.setItemSpace(l.h(view.getContext(), e.C0210e.tbds20));
            this.dYF.setItemWidth(((l.h(view.getContext(), e.C0210e.tbds170) * 2) * 21) / 9);
            this.dYq = view.findViewById(e.g.divider_line_1);
            this.dBx = view.findViewById(e.g.divider_line_2);
        }
    }
}
