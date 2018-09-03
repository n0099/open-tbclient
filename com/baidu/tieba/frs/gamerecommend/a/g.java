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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> duq;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.duq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axY */
            public CardFrsGameRecommendGameItemView ig() {
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
    /* renamed from: aC */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(f.h.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.dyL.setViewPool(this.duq);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.anq() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyJ.setText(fVar.anq().title);
            aVar.dyJ.setTextColor(am.getColor(skinType, f.d.cp_cont_b));
            aVar.dyL.setPageContext(this.mPageContext);
            aVar.dyL.setData(fVar.anq().sub_nodes);
            aVar.dyK.setMaxOverScrollDistance(aVar.dyL.getChildItemWidth());
            aVar.dyI.setBackgroundColor(am.getColor(skinType, f.d.cp_bg_line_d));
            am.i(aVar.dyD, f.d.cp_bg_line_e);
            am.i(aVar.dcy, f.d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcy;
        private View dyD;
        private LinearLayout dyI;
        private TextView dyJ;
        private FlexibleHorizontalScrollView dyK;
        private CardFrsGameRecommendGameLayout dyL;

        public a(View view) {
            super(view);
            this.dyI = (LinearLayout) view.findViewById(f.g.card_game_recommend_content);
            this.dyJ = (TextView) view.findViewById(f.g.game_recommend_title);
            this.dyK = (FlexibleHorizontalScrollView) view.findViewById(f.g.game_recommend_scroll_container);
            this.dyL = (CardFrsGameRecommendGameLayout) view.findViewById(f.g.game_recommend_container);
            this.dyL.setItemSpace(l.f(view.getContext(), f.e.tbds27));
            this.dyL.setItemWidth(l.f(view.getContext(), f.e.tbds192));
            this.dyD = view.findViewById(f.g.divider_line_1);
            this.dcy = view.findViewById(f.g.divider_line_2);
        }
    }
}
