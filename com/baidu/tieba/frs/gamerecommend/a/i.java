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
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dKb;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dKb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDc */
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
    /* renamed from: aE */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dOE.setViewPool(this.dKb);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.asc() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dOC.setText(hVar.asc().title);
            aVar.dOC.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dOE.setPageContext(this.mPageContext);
            aVar.dOE.setData(hVar.asc().sub_nodes);
            aVar.dOD.setMaxOverScrollDistance(aVar.dOE.getChildItemWidth());
            aVar.dOB.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dOp, e.d.cp_bg_line_e);
            al.i(aVar.drA, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private LinearLayout dOB;
        private TextView dOC;
        private FlexibleHorizontalScrollView dOD;
        private CardFrsGameSpecialTopicLayout dOE;
        private View dOp;
        private View drA;

        public a(View view) {
            super(view);
            this.dOB = (LinearLayout) view.findViewById(e.g.card_game_special_topic_content);
            this.dOC = (TextView) view.findViewById(e.g.game_special_topic_title);
            this.dOD = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_special_topic_scroll_container);
            this.dOE = (CardFrsGameSpecialTopicLayout) view.findViewById(e.g.game_special_topic_container);
            this.dOE.setItemSpace(l.h(view.getContext(), e.C0200e.tbds20));
            this.dOE.setItemWidth(((l.h(view.getContext(), e.C0200e.tbds170) * 2) * 21) / 9);
            this.dOp = view.findViewById(e.g.divider_line_1);
            this.drA = view.findViewById(e.g.divider_line_2);
        }
    }
}
