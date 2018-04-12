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
    private com.baidu.adp.lib.e.b<CardFrsGameCompetitionItemView> ded;
    private String mForumId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ded = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameCompetitionItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.d.1
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
        aVar.dir.setViewPool(this.ded);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.e.c cVar, a aVar) {
        if (cVar != null && cVar.ajv() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dip.setText(cVar.ajv().title);
            aVar.dip.setTextColor(ak.getColor(skinType, d.C0126d.cp_cont_b));
            aVar.dir.setPageContext(this.mPageContext);
            aVar.dir.setData(cVar.ajv().sub_nodes);
            aVar.diq.setMaxOverScrollDistance(aVar.dir.getChildItemWidth());
            aVar.dio.setBackgroundColor(ak.getColor(skinType, d.C0126d.cp_bg_line_d));
            ak.i(aVar.dis, d.C0126d.cp_bg_line_e);
            ak.i(aVar.cRw, d.C0126d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cRw;
        private LinearLayout dio;
        private TextView dip;
        private FlexibleHorizontalScrollView diq;
        private CardFrsGameCompetitionLayout dir;
        private View dis;

        public a(View view2) {
            super(view2);
            this.dio = (LinearLayout) view2.findViewById(d.g.card_game_competition_content);
            this.dip = (TextView) view2.findViewById(d.g.game_competition_title);
            this.diq = (FlexibleHorizontalScrollView) view2.findViewById(d.g.game_competition_scroll_container);
            this.dir = (CardFrsGameCompetitionLayout) view2.findViewById(d.g.game_competition_container);
            this.dir.setItemSpace(l.e(view2.getContext(), d.e.tbds20));
            this.dir.setItemWidth(((l.e(view2.getContext(), d.e.tbds170) * 2) * 21) / 9);
            this.dis = view2.findViewById(d.g.divider_line_1);
            this.cRw = view2.findViewById(d.g.divider_line_2);
        }
    }
}
