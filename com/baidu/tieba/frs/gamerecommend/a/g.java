package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.frs.j;
/* loaded from: classes16.dex */
public class g extends j<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> hPW;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hPW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cfS */
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
    /* renamed from: bt */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.hVi.setViewPool(this.hPW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.bTh() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hVg.setText(fVar.bTh().title);
            aVar.hVg.setTextColor(ao.getColor(skinType, R.color.cp_cont_b));
            aVar.hVi.setPageContext(this.mPageContext);
            aVar.hVi.setData(fVar.bTh().sub_nodes);
            aVar.hVh.setMaxOverScrollDistance(aVar.hVi.getChildItemWidth());
            aVar.hVf.setBackgroundColor(ao.getColor(skinType, R.color.cp_bg_line_d));
            ao.setBackgroundResource(aVar.hVa, R.color.cp_bg_line_e);
            ao.setBackgroundResource(aVar.hyz, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public class a extends ad.a {
        private View hVa;
        private LinearLayout hVf;
        private TextView hVg;
        private FlexibleHorizontalScrollView hVh;
        private CardFrsGameRecommendGameLayout hVi;
        private View hyz;

        public a(View view) {
            super(view);
            this.hVf = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.hVg = (TextView) view.findViewById(R.id.game_recommend_title);
            this.hVh = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.hVi = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.hVi.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.hVi.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.hVa = view.findViewById(R.id.divider_line_1);
            this.hyz = view.findViewById(R.id.divider_line_2);
        }
    }
}
