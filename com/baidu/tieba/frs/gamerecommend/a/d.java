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
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> jek;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jek = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHE */
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
        aVar.jlL.setViewPool(this.jek);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.c cVar, a aVar) {
        if (cVar != null && cVar.ctB() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jlJ.setText(cVar.ctB().title);
            aVar.jlJ.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.jlL.setPageContext(this.mPageContext);
            aVar.jlL.setData(cVar.ctB().sub_nodes);
            aVar.jlK.setMaxOverScrollDistance(aVar.jlL.getChildItemWidth());
            aVar.jlI.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.jlM, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iLW, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iLW;
        private LinearLayout jlI;
        private TextView jlJ;
        private FlexibleHorizontalScrollView jlK;
        private CardFrsGameCompetitionLayout jlL;
        private View jlM;

        public a(View view) {
            super(view);
            this.jlI = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.jlJ = (TextView) view.findViewById(R.id.game_competition_title);
            this.jlK = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.jlL = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.jlL.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jlL.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jlM = view.findViewById(R.id.divider_line_1);
            this.iLW = view.findViewById(R.id.divider_line_2);
        }
    }
}
