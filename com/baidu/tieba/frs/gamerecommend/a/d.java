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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dut;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dut = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axZ */
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_competition_layout, viewGroup, false));
        aVar.dyF.setViewPool(this.dut);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.anl() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyD.setText(cVar.anl().title);
            aVar.dyD.setTextColor(am.getColor(skinType, d.C0140d.cp_cont_b));
            aVar.dyF.setPageContext(this.mPageContext);
            aVar.dyF.setData(cVar.anl().sub_nodes);
            aVar.dyE.setMaxOverScrollDistance(aVar.dyF.getChildItemWidth());
            aVar.dyC.setBackgroundColor(am.getColor(skinType, d.C0140d.cp_bg_line_d));
            am.i(aVar.dyG, d.C0140d.cp_bg_line_e);
            am.i(aVar.dcA, d.C0140d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcA;
        private LinearLayout dyC;
        private TextView dyD;
        private FlexibleHorizontalScrollView dyE;
        private CardFrsGameCompetitionLayout dyF;
        private View dyG;

        public a(View view) {
            super(view);
            this.dyC = (LinearLayout) view.findViewById(d.g.card_game_competition_content);
            this.dyD = (TextView) view.findViewById(d.g.game_competition_title);
            this.dyE = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_competition_scroll_container);
            this.dyF = (CardFrsGameCompetitionLayout) view.findViewById(d.g.game_competition_container);
            this.dyF.setItemSpace(l.f(view.getContext(), d.e.tbds20));
            this.dyF.setItemWidth(((l.f(view.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dyG = view.findViewById(d.g.divider_line_1);
            this.dcA = view.findViewById(d.g.divider_line_2);
        }
    }
}
