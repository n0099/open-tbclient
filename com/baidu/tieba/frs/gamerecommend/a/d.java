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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> fhA;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fhA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgo */
            public CardFrsGameCompetitionItemView makeObject() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(d.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(d.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView activateObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameCompetitionItemView passivateObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_competition_layout, viewGroup, false));
        aVar.flD.setViewPool(this.fhA);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.aUL() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.flB.setText(cVar.aUL().title);
            aVar.flB.setTextColor(al.getColor(skinType, d.C0277d.cp_cont_b));
            aVar.flD.setPageContext(this.mPageContext);
            aVar.flD.setData(cVar.aUL().sub_nodes);
            aVar.flC.setMaxOverScrollDistance(aVar.flD.getChildItemWidth());
            aVar.flA.setBackgroundColor(al.getColor(skinType, d.C0277d.cp_bg_line_d));
            al.k(aVar.flE, d.C0277d.cp_bg_line_e);
            al.k(aVar.eOA, d.C0277d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View eOA;
        private LinearLayout flA;
        private TextView flB;
        private FlexibleHorizontalScrollView flC;
        private CardFrsGameCompetitionLayout flD;
        private View flE;

        public a(View view) {
            super(view);
            this.flA = (LinearLayout) view.findViewById(d.g.card_game_competition_content);
            this.flB = (TextView) view.findViewById(d.g.game_competition_title);
            this.flC = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_competition_scroll_container);
            this.flD = (CardFrsGameCompetitionLayout) view.findViewById(d.g.game_competition_container);
            this.flD.setItemSpace(l.h(view.getContext(), d.e.tbds20));
            this.flD.setItemWidth(((l.h(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.flE = view.findViewById(d.g.divider_line_1);
            this.eOA = view.findViewById(d.g.divider_line_2);
        }
    }
}
