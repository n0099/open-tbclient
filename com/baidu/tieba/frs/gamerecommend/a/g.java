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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class g extends k<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> iSB;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iSB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cCQ */
            public CardFrsGameRecommendGameItemView makeObject() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView activateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public CardFrsGameRecommendGameItemView passivateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.iXJ.setViewPool(this.iSB);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.cpN() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iXH.setText(fVar.cpN().title);
            aVar.iXH.setTextColor(ap.getColor(skinType, R.color.cp_cont_b));
            aVar.iXJ.setPageContext(this.mPageContext);
            aVar.iXJ.setData(fVar.cpN().sub_nodes);
            aVar.iXI.setMaxOverScrollDistance(aVar.iXJ.getChildItemWidth());
            aVar.iXG.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_d));
            ap.setBackgroundResource(aVar.iXB, R.color.cp_bg_line_e);
            ap.setBackgroundResource(aVar.iAp, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iAp;
        private View iXB;
        private LinearLayout iXG;
        private TextView iXH;
        private FlexibleHorizontalScrollView iXI;
        private CardFrsGameRecommendGameLayout iXJ;

        public a(View view) {
            super(view);
            this.iXG = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.iXH = (TextView) view.findViewById(R.id.game_recommend_title);
            this.iXI = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.iXJ = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.iXJ.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.iXJ.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.iXB = view.findViewById(R.id.divider_line_1);
            this.iAp = view.findViewById(R.id.divider_line_2);
        }
    }
}
