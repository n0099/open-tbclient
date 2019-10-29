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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> fEL;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fEL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnO */
            public CardFrsGameRecommendGameItemView makeObject() {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(g.this.mContext);
                cardFrsGameRecommendGameItemView.setForumId(g.this.mForumId);
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameRecommendGameItemView activateObject(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
                return cardFrsGameRecommendGameItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
    /* renamed from: aZ */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.fJc.setViewPool(this.fEL);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.bcB() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fJa.setText(fVar.bcB().title);
            aVar.fJa.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.fJc.setPageContext(this.mPageContext);
            aVar.fJc.setData(fVar.bcB().sub_nodes);
            aVar.fJb.setMaxOverScrollDistance(aVar.fJc.getChildItemWidth());
            aVar.fIZ.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.fIU, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.foG, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View fIU;
        private LinearLayout fIZ;
        private TextView fJa;
        private FlexibleHorizontalScrollView fJb;
        private CardFrsGameRecommendGameLayout fJc;
        private View foG;

        public a(View view) {
            super(view);
            this.fIZ = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.fJa = (TextView) view.findViewById(R.id.game_recommend_title);
            this.fJb = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.fJc = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.fJc.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.fJc.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.fIU = view.findViewById(R.id.divider_line_1);
            this.foG = view.findViewById(R.id.divider_line_2);
        }
    }
}
