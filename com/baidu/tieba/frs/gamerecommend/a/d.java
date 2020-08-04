package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.frs.j;
/* loaded from: classes16.dex */
public class d extends j<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> hPW;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hPW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cfR */
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
    /* renamed from: bs */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        aVar.hUZ.setViewPool(this.hPW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.bTe() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hUX.setText(cVar.bTe().title);
            aVar.hUX.setTextColor(ao.getColor(skinType, R.color.cp_cont_b));
            aVar.hUZ.setPageContext(this.mPageContext);
            aVar.hUZ.setData(cVar.bTe().sub_nodes);
            aVar.hUY.setMaxOverScrollDistance(aVar.hUZ.getChildItemWidth());
            aVar.hUW.setBackgroundColor(ao.getColor(skinType, R.color.cp_bg_line_d));
            ao.setBackgroundResource(aVar.hVa, R.color.cp_bg_line_e);
            ao.setBackgroundResource(aVar.hyz, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public class a extends ad.a {
        private LinearLayout hUW;
        private TextView hUX;
        private FlexibleHorizontalScrollView hUY;
        private CardFrsGameCompetitionLayout hUZ;
        private View hVa;
        private View hyz;

        public a(View view) {
            super(view);
            this.hUW = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.hUX = (TextView) view.findViewById(R.id.game_competition_title);
            this.hUY = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.hUZ = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.hUZ.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.hUZ.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.hVa = view.findViewById(R.id.divider_line_1);
            this.hyz = view.findViewById(R.id.divider_line_2);
        }
    }
}
