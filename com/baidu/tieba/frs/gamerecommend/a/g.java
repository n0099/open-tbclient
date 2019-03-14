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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> fhO;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fhO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bgr */
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
    /* renamed from: aT */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.fma.setViewPool(this.fhO);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.aUQ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.flY.setText(fVar.aUQ().title);
            aVar.flY.setTextColor(al.getColor(skinType, d.C0277d.cp_cont_b));
            aVar.fma.setPageContext(this.mPageContext);
            aVar.fma.setData(fVar.aUQ().sub_nodes);
            aVar.flZ.setMaxOverScrollDistance(aVar.fma.getChildItemWidth());
            aVar.flX.setBackgroundColor(al.getColor(skinType, d.C0277d.cp_bg_line_d));
            al.k(aVar.flS, d.C0277d.cp_bg_line_e);
            al.k(aVar.eON, d.C0277d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View eON;
        private View flS;
        private LinearLayout flX;
        private TextView flY;
        private FlexibleHorizontalScrollView flZ;
        private CardFrsGameRecommendGameLayout fma;

        public a(View view) {
            super(view);
            this.flX = (LinearLayout) view.findViewById(d.g.card_game_recommend_content);
            this.flY = (TextView) view.findViewById(d.g.game_recommend_title);
            this.flZ = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_recommend_scroll_container);
            this.fma = (CardFrsGameRecommendGameLayout) view.findViewById(d.g.game_recommend_container);
            this.fma.setItemSpace(l.h(view.getContext(), d.e.tbds27));
            this.fma.setItemWidth(l.h(view.getContext(), d.e.tbds192));
            this.flS = view.findViewById(d.g.divider_line_1);
            this.eON = view.findViewById(d.g.divider_line_2);
        }
    }
}
