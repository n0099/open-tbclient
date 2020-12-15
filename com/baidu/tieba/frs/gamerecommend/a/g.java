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
public class g extends k<com.baidu.tieba.f.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> jem;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jem = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHG */
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
    /* renamed from: bw */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.jlW.setViewPool(this.jem);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.f fVar, a aVar) {
        if (fVar != null && fVar.ctF() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jlU.setText(fVar.ctF().title);
            aVar.jlU.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.jlW.setPageContext(this.mPageContext);
            aVar.jlW.setData(fVar.ctF().sub_nodes);
            aVar.jlV.setMaxOverScrollDistance(aVar.jlW.getChildItemWidth());
            aVar.jlT.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.jlO, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iLY, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iLY;
        private View jlO;
        private LinearLayout jlT;
        private TextView jlU;
        private FlexibleHorizontalScrollView jlV;
        private CardFrsGameRecommendGameLayout jlW;

        public a(View view) {
            super(view);
            this.jlT = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.jlU = (TextView) view.findViewById(R.id.game_recommend_title);
            this.jlV = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.jlW = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.jlW.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.jlW.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.jlO = view.findViewById(R.id.divider_line_1);
            this.iLY = view.findViewById(R.id.divider_line_2);
        }
    }
}
