package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> hwW;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hwW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bZc */
            public CardFrsGameCompetitionItemView makeObject() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(d.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(d.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView activateObject(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
    /* renamed from: bn */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        aVar.hBQ.setViewPool(this.hwW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.bMN() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hBO.setText(cVar.bMN().title);
            aVar.hBO.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.hBQ.setPageContext(this.mPageContext);
            aVar.hBQ.setData(cVar.bMN().sub_nodes);
            aVar.hBP.setMaxOverScrollDistance(aVar.hBQ.getChildItemWidth());
            aVar.hBN.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.hBR, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.hgD, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends aa.a {
        private LinearLayout hBN;
        private TextView hBO;
        private FlexibleHorizontalScrollView hBP;
        private CardFrsGameCompetitionLayout hBQ;
        private View hBR;
        private View hgD;

        public a(View view) {
            super(view);
            this.hBN = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.hBO = (TextView) view.findViewById(R.id.game_competition_title);
            this.hBP = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.hBQ = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.hBQ.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.hBQ.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.hBR = view.findViewById(R.id.divider_line_1);
            this.hgD = view.findViewById(R.id.divider_line_2);
        }
    }
}
