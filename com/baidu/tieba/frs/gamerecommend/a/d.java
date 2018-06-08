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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.f<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dox;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dox = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awQ */
            public CardFrsGameCompetitionItemView mo9if() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(d.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(d.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void q(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView r(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameCompetitionItemView s(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_competition_layout, viewGroup, false));
        aVar.dsJ.setViewPool(this.dox);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.ans() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dsH.setText(cVar.ans().title);
            aVar.dsH.setTextColor(al.getColor(skinType, d.C0141d.cp_cont_b));
            aVar.dsJ.setPageContext(this.mPageContext);
            aVar.dsJ.setData(cVar.ans().sub_nodes);
            aVar.dsI.setMaxOverScrollDistance(aVar.dsJ.getChildItemWidth());
            aVar.dsG.setBackgroundColor(al.getColor(skinType, d.C0141d.cp_bg_line_d));
            al.i(aVar.dsK, d.C0141d.cp_bg_line_e);
            al.i(aVar.dbH, d.C0141d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dbH;
        private LinearLayout dsG;
        private TextView dsH;
        private FlexibleHorizontalScrollView dsI;
        private CardFrsGameCompetitionLayout dsJ;
        private View dsK;

        public a(View view) {
            super(view);
            this.dsG = (LinearLayout) view.findViewById(d.g.card_game_competition_content);
            this.dsH = (TextView) view.findViewById(d.g.game_competition_title);
            this.dsI = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_competition_scroll_container);
            this.dsJ = (CardFrsGameCompetitionLayout) view.findViewById(d.g.game_competition_container);
            this.dsJ.setItemSpace(l.e(view.getContext(), d.e.tbds20));
            this.dsJ.setItemWidth(((l.e(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dsK = view.findViewById(d.g.divider_line_1);
            this.dbH = view.findViewById(d.g.divider_line_2);
        }
    }
}
