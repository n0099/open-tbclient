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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dQE;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dQE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aEM */
            public CardFrsGameCompetitionItemView jz() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(d.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(d.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void u(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView v(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameCompetitionItemView w(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_competition_layout, viewGroup, false));
        aVar.dUR.setViewPool(this.dQE);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.atJ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dUP.setText(cVar.atJ().title);
            aVar.dUP.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dUR.setPageContext(this.mPageContext);
            aVar.dUR.setData(cVar.atJ().sub_nodes);
            aVar.dUQ.setMaxOverScrollDistance(aVar.dUR.getChildItemWidth());
            aVar.dUO.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dUS, e.d.cp_bg_line_e);
            al.i(aVar.dya, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private LinearLayout dUO;
        private TextView dUP;
        private FlexibleHorizontalScrollView dUQ;
        private CardFrsGameCompetitionLayout dUR;
        private View dUS;
        private View dya;

        public a(View view) {
            super(view);
            this.dUO = (LinearLayout) view.findViewById(e.g.card_game_competition_content);
            this.dUP = (TextView) view.findViewById(e.g.game_competition_title);
            this.dUQ = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_competition_scroll_container);
            this.dUR = (CardFrsGameCompetitionLayout) view.findViewById(e.g.game_competition_container);
            this.dUR.setItemSpace(l.h(view.getContext(), e.C0210e.tbds20));
            this.dUR.setItemWidth(((l.h(view.getContext(), e.C0210e.tbds170) * 2) * 21) / 9);
            this.dUS = view.findViewById(e.g.divider_line_1);
            this.dya = view.findViewById(e.g.divider_line_2);
        }
    }
}
