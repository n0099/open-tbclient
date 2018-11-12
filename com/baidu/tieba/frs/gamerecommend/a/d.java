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
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dKb;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dKb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDa */
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
        aVar.dOo.setViewPool(this.dKb);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.arX() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dOm.setText(cVar.arX().title);
            aVar.dOm.setTextColor(al.getColor(skinType, e.d.cp_cont_b));
            aVar.dOo.setPageContext(this.mPageContext);
            aVar.dOo.setData(cVar.arX().sub_nodes);
            aVar.dOn.setMaxOverScrollDistance(aVar.dOo.getChildItemWidth());
            aVar.dOl.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_d));
            al.i(aVar.dOp, e.d.cp_bg_line_e);
            al.i(aVar.drA, e.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private LinearLayout dOl;
        private TextView dOm;
        private FlexibleHorizontalScrollView dOn;
        private CardFrsGameCompetitionLayout dOo;
        private View dOp;
        private View drA;

        public a(View view) {
            super(view);
            this.dOl = (LinearLayout) view.findViewById(e.g.card_game_competition_content);
            this.dOm = (TextView) view.findViewById(e.g.game_competition_title);
            this.dOn = (FlexibleHorizontalScrollView) view.findViewById(e.g.game_competition_scroll_container);
            this.dOo = (CardFrsGameCompetitionLayout) view.findViewById(e.g.game_competition_container);
            this.dOo.setItemSpace(l.h(view.getContext(), e.C0200e.tbds20));
            this.dOo.setItemWidth(((l.h(view.getContext(), e.C0200e.tbds170) * 2) * 21) / 9);
            this.dOp = view.findViewById(e.g.divider_line_1);
            this.drA = view.findViewById(e.g.divider_line_2);
        }
    }
}
