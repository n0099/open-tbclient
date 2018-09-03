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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> duq;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.duq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axX */
            public CardFrsGameCompetitionItemView ig() {
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
    /* renamed from: aB */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(f.h.card_frs_game_competition_layout, viewGroup, false));
        aVar.dyC.setViewPool(this.duq);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.ann() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyA.setText(cVar.ann().title);
            aVar.dyA.setTextColor(am.getColor(skinType, f.d.cp_cont_b));
            aVar.dyC.setPageContext(this.mPageContext);
            aVar.dyC.setData(cVar.ann().sub_nodes);
            aVar.dyB.setMaxOverScrollDistance(aVar.dyC.getChildItemWidth());
            aVar.dyz.setBackgroundColor(am.getColor(skinType, f.d.cp_bg_line_d));
            am.i(aVar.dyD, f.d.cp_bg_line_e);
            am.i(aVar.dcy, f.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcy;
        private TextView dyA;
        private FlexibleHorizontalScrollView dyB;
        private CardFrsGameCompetitionLayout dyC;
        private View dyD;
        private LinearLayout dyz;

        public a(View view) {
            super(view);
            this.dyz = (LinearLayout) view.findViewById(f.g.card_game_competition_content);
            this.dyA = (TextView) view.findViewById(f.g.game_competition_title);
            this.dyB = (FlexibleHorizontalScrollView) view.findViewById(f.g.game_competition_scroll_container);
            this.dyC = (CardFrsGameCompetitionLayout) view.findViewById(f.g.game_competition_container);
            this.dyC.setItemSpace(l.f(view.getContext(), f.e.tbds20));
            this.dyC.setItemWidth(((l.f(view.getContext(), f.e.tbds170) * 2) * 21) / 9);
            this.dyD = view.findViewById(f.g.divider_line_1);
            this.dcy = view.findViewById(f.g.divider_line_2);
        }
    }
}
