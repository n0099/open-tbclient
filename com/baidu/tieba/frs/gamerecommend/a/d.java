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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.f<com.baidu.tieba.e.c, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> dea;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dea = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: asL */
            public CardFrsGameCompetitionItemView fo() {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(d.this.mContext);
                cardFrsGameCompetitionItemView.setForumId(d.this.mForumId);
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameCompetitionItemView o(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameCompetitionItemView p(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
                return cardFrsGameCompetitionItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_competition_layout, viewGroup, false));
        aVar.dio.setViewPool(this.dea);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.ajv() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dim.setText(cVar.ajv().title);
            aVar.dim.setTextColor(ak.getColor(skinType, d.C0126d.cp_cont_b));
            aVar.dio.setPageContext(this.mPageContext);
            aVar.dio.setData(cVar.ajv().sub_nodes);
            aVar.din.setMaxOverScrollDistance(aVar.dio.getChildItemWidth());
            aVar.dil.setBackgroundColor(ak.getColor(skinType, d.C0126d.cp_bg_line_d));
            ak.i(aVar.dip, d.C0126d.cp_bg_line_e);
            ak.i(aVar.cRt, d.C0126d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cRt;
        private LinearLayout dil;
        private TextView dim;
        private FlexibleHorizontalScrollView din;
        private CardFrsGameCompetitionLayout dio;
        private View dip;

        public a(View view2) {
            super(view2);
            this.dil = (LinearLayout) view2.findViewById(d.g.card_game_competition_content);
            this.dim = (TextView) view2.findViewById(d.g.game_competition_title);
            this.din = (FlexibleHorizontalScrollView) view2.findViewById(d.g.game_competition_scroll_container);
            this.dio = (CardFrsGameCompetitionLayout) view2.findViewById(d.g.game_competition_container);
            this.dio.setItemSpace(l.e(view2.getContext(), d.e.tbds20));
            this.dio.setItemWidth(((l.e(view2.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dip = view2.findViewById(d.g.divider_line_1);
            this.cRt = view2.findViewById(d.g.divider_line_2);
        }
    }
}
