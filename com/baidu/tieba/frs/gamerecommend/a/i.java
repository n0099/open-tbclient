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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.frs.f<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> dox;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dox = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awS */
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
    /* renamed from: aF */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.dsZ.setViewPool(this.dox);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.anx() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dsX.setText(hVar.anx().title);
            aVar.dsX.setTextColor(al.getColor(skinType, d.C0141d.cp_cont_b));
            aVar.dsZ.setPageContext(this.mPageContext);
            aVar.dsZ.setData(hVar.anx().sub_nodes);
            aVar.dsY.setMaxOverScrollDistance(aVar.dsZ.getChildItemWidth());
            aVar.dsW.setBackgroundColor(al.getColor(skinType, d.C0141d.cp_bg_line_d));
            al.i(aVar.dsK, d.C0141d.cp_bg_line_e);
            al.i(aVar.dbH, d.C0141d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dbH;
        private View dsK;
        private LinearLayout dsW;
        private TextView dsX;
        private FlexibleHorizontalScrollView dsY;
        private CardFrsGameSpecialTopicLayout dsZ;

        public a(View view) {
            super(view);
            this.dsW = (LinearLayout) view.findViewById(d.g.card_game_special_topic_content);
            this.dsX = (TextView) view.findViewById(d.g.game_special_topic_title);
            this.dsY = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_special_topic_scroll_container);
            this.dsZ = (CardFrsGameSpecialTopicLayout) view.findViewById(d.g.game_special_topic_container);
            this.dsZ.setItemSpace(l.e(view.getContext(), d.e.tbds20));
            this.dsZ.setItemWidth(((l.e(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dsK = view.findViewById(d.g.divider_line_1);
            this.dbH = view.findViewById(d.g.divider_line_2);
        }
    }
}
