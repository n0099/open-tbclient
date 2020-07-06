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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.frs.j;
/* loaded from: classes9.dex */
public class g extends j<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> hJU;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hJU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ccu */
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
    /* renamed from: bs */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.hPh.setViewPool(this.hJU);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.bPW() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hPf.setText(fVar.bPW().title);
            aVar.hPf.setTextColor(an.getColor(skinType, R.color.cp_cont_b));
            aVar.hPh.setPageContext(this.mPageContext);
            aVar.hPh.setData(fVar.bPW().sub_nodes);
            aVar.hPg.setMaxOverScrollDistance(aVar.hPh.getChildItemWidth());
            aVar.hPe.setBackgroundColor(an.getColor(skinType, R.color.cp_bg_line_d));
            an.setBackgroundResource(aVar.hOZ, R.color.cp_bg_line_e);
            an.setBackgroundResource(aVar.hsN, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends ad.a {
        private View hOZ;
        private LinearLayout hPe;
        private TextView hPf;
        private FlexibleHorizontalScrollView hPg;
        private CardFrsGameRecommendGameLayout hPh;
        private View hsN;

        public a(View view) {
            super(view);
            this.hPe = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.hPf = (TextView) view.findViewById(R.id.game_recommend_title);
            this.hPg = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.hPh = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.hPh.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.hPh.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.hOZ = view.findViewById(R.id.divider_line_1);
            this.hsN = view.findViewById(R.id.divider_line_2);
        }
    }
}
