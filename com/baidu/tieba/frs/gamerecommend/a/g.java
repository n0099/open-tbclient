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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.f<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> ded;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ded = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: asM */
            public CardFrsGameRecommendGameItemView fo() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView o(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public CardFrsGameRecommendGameItemView p(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.diA.setViewPool(this.ded);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.ajy() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.diy.setText(fVar.ajy().title);
            aVar.diy.setTextColor(ak.getColor(skinType, d.C0126d.cp_cont_b));
            aVar.diA.setPageContext(this.mPageContext);
            aVar.diA.setData(fVar.ajy().sub_nodes);
            aVar.diz.setMaxOverScrollDistance(aVar.diA.getChildItemWidth());
            aVar.dix.setBackgroundColor(ak.getColor(skinType, d.C0126d.cp_bg_line_d));
            ak.i(aVar.dis, d.C0126d.cp_bg_line_e);
            ak.i(aVar.cRw, d.C0126d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cRw;
        private CardFrsGameRecommendGameLayout diA;
        private View dis;
        private LinearLayout dix;
        private TextView diy;
        private FlexibleHorizontalScrollView diz;

        public a(View view2) {
            super(view2);
            this.dix = (LinearLayout) view2.findViewById(d.g.card_game_recommend_content);
            this.diy = (TextView) view2.findViewById(d.g.game_recommend_title);
            this.diz = (FlexibleHorizontalScrollView) view2.findViewById(d.g.game_recommend_scroll_container);
            this.diA = (CardFrsGameRecommendGameLayout) view2.findViewById(d.g.game_recommend_container);
            this.diA.setItemSpace(l.e(view2.getContext(), d.e.tbds27));
            this.diA.setItemWidth(l.e(view2.getContext(), d.e.tbds192));
            this.dis = view2.findViewById(d.g.divider_line_1);
            this.cRw = view2.findViewById(d.g.divider_line_2);
        }
    }
}
