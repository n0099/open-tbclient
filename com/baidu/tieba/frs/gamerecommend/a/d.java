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
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dIX;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDF */
            public CardFrsGameCompetitionItemView jB() {
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
    /* renamed from: aB */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_frs_game_competition_layout, viewGroup, false));
        aVar.dNl.setViewPool(this.dIX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.asx() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dNj.setText(cVar.asx().title);
            aVar.dNj.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dNl.setPageContext(this.mPageContext);
            aVar.dNl.setData(cVar.asx().sub_nodes);
            aVar.dNk.setMaxOverScrollDistance(aVar.dNl.getChildItemWidth());
            aVar.dNi.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dNm, e.d.cp_bg_line_e);
            al.i(aVar.dqw, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private LinearLayout dNi;
        private TextView dNj;
        private FlexibleHorizontalScrollView dNk;
        private CardFrsGameCompetitionLayout dNl;
        private View dNm;
        private View dqw;

        public a(View view) {
            super(view);
            this.dNi = (LinearLayout) view.findViewById(e.g.card_game_competition_content);
            this.dNj = (TextView) view.findViewById(e.g.game_competition_title);
            this.dNk = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_competition_scroll_container);
            this.dNl = (CardFrsGameCompetitionLayout) view.findViewById(e.g.game_competition_container);
            this.dNl.setItemSpace(l.h(view.getContext(), e.C0175e.tbds20));
            this.dNl.setItemWidth(((l.h(view.getContext(), e.C0175e.tbds170) * 2) * 21) / 9);
            this.dNm = view.findViewById(e.g.divider_line_1);
            this.dqw = view.findViewById(e.g.divider_line_2);
        }
    }
}
