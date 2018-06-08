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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.f<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> dox;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dox = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awR */
            public CardFrsGameRecommendGameItemView mo9if() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void q(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView r(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameRecommendGameItemView s(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.dsS.setViewPool(this.dox);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.anv() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dsQ.setText(fVar.anv().title);
            aVar.dsQ.setTextColor(al.getColor(skinType, d.C0141d.cp_cont_b));
            aVar.dsS.setPageContext(this.mPageContext);
            aVar.dsS.setData(fVar.anv().sub_nodes);
            aVar.dsR.setMaxOverScrollDistance(aVar.dsS.getChildItemWidth());
            aVar.dsP.setBackgroundColor(al.getColor(skinType, d.C0141d.cp_bg_line_d));
            al.i(aVar.dsK, d.C0141d.cp_bg_line_e);
            al.i(aVar.dbH, d.C0141d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dbH;
        private View dsK;
        private LinearLayout dsP;
        private TextView dsQ;
        private FlexibleHorizontalScrollView dsR;
        private CardFrsGameRecommendGameLayout dsS;

        public a(View view) {
            super(view);
            this.dsP = (LinearLayout) view.findViewById(d.g.card_game_recommend_content);
            this.dsQ = (TextView) view.findViewById(d.g.game_recommend_title);
            this.dsR = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_recommend_scroll_container);
            this.dsS = (CardFrsGameRecommendGameLayout) view.findViewById(d.g.game_recommend_container);
            this.dsS.setItemSpace(l.e(view.getContext(), d.e.tbds27));
            this.dsS.setItemWidth(l.e(view.getContext(), d.e.tbds192));
            this.dsK = view.findViewById(d.g.divider_line_1);
            this.dbH = view.findViewById(d.g.divider_line_2);
        }
    }
}
