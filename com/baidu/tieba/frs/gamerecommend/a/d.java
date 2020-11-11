package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class d extends k<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> iSB;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iSB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cCP */
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
    /* renamed from: bw */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        aVar.iXA.setViewPool(this.iSB);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.cpK() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iXy.setText(cVar.cpK().title);
            aVar.iXy.setTextColor(ap.getColor(skinType, R.color.cp_cont_b));
            aVar.iXA.setPageContext(this.mPageContext);
            aVar.iXA.setData(cVar.cpK().sub_nodes);
            aVar.iXz.setMaxOverScrollDistance(aVar.iXA.getChildItemWidth());
            aVar.iXx.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_d));
            ap.setBackgroundResource(aVar.iXB, R.color.cp_bg_line_e);
            ap.setBackgroundResource(aVar.iAp, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iAp;
        private CardFrsGameCompetitionLayout iXA;
        private View iXB;
        private LinearLayout iXx;
        private TextView iXy;
        private FlexibleHorizontalScrollView iXz;

        public a(View view) {
            super(view);
            this.iXx = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.iXy = (TextView) view.findViewById(R.id.game_competition_title);
            this.iXz = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.iXA = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.iXA.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.iXA.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.iXB = view.findViewById(R.id.divider_line_1);
            this.iAp = view.findViewById(R.id.divider_line_2);
        }
    }
}
