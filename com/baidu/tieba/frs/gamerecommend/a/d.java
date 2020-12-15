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
public class d extends k<com.baidu.tieba.f.c, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> jem;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jem = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHF */
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
    /* renamed from: bv */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        aVar.jlN.setViewPool(this.jem);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.c cVar, a aVar) {
        if (cVar != null && cVar.ctC() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jlL.setText(cVar.ctC().title);
            aVar.jlL.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.jlN.setPageContext(this.mPageContext);
            aVar.jlN.setData(cVar.ctC().sub_nodes);
            aVar.jlM.setMaxOverScrollDistance(aVar.jlN.getChildItemWidth());
            aVar.jlK.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.jlO, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iLY, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iLY;
        private LinearLayout jlK;
        private TextView jlL;
        private FlexibleHorizontalScrollView jlM;
        private CardFrsGameCompetitionLayout jlN;
        private View jlO;

        public a(View view) {
            super(view);
            this.jlK = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.jlL = (TextView) view.findViewById(R.id.game_competition_title);
            this.jlM = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.jlN = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.jlN.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jlN.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jlO = view.findViewById(R.id.divider_line_1);
            this.iLY = view.findViewById(R.id.divider_line_2);
        }
    }
}
