package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.frs.h<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameCompetitionItemView> gvw;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gvw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGk */
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
    /* renamed from: aZ */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        aVar.gzB.setViewPool(this.gvw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.buV() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gzz.setText(cVar.buV().title);
            aVar.gzz.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.gzB.setPageContext(this.mPageContext);
            aVar.gzB.setData(cVar.buV().sub_nodes);
            aVar.gzA.setMaxOverScrollDistance(aVar.gzB.getChildItemWidth());
            aVar.gzy.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.gzC, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.gfw, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes7.dex */
    public class a extends v.a {
        private View gfw;
        private FlexibleHorizontalScrollView gzA;
        private CardFrsGameCompetitionLayout gzB;
        private View gzC;
        private LinearLayout gzy;
        private TextView gzz;

        public a(View view) {
            super(view);
            this.gzy = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.gzz = (TextView) view.findViewById(R.id.game_competition_title);
            this.gzA = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            this.gzB = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.gzB.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.gzB.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.gzC = view.findViewById(R.id.divider_line_1);
            this.gfw = view.findViewById(R.id.divider_line_2);
        }
    }
}
