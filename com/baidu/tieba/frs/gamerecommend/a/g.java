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
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> jek;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jek = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHF */
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
        aVar.jlU.setViewPool(this.jek);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.f fVar, a aVar) {
        if (fVar != null && fVar.ctE() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jlS.setText(fVar.ctE().title);
            aVar.jlS.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.jlU.setPageContext(this.mPageContext);
            aVar.jlU.setData(fVar.ctE().sub_nodes);
            aVar.jlT.setMaxOverScrollDistance(aVar.jlU.getChildItemWidth());
            aVar.jlR.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.jlM, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iLW, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iLW;
        private View jlM;
        private LinearLayout jlR;
        private TextView jlS;
        private FlexibleHorizontalScrollView jlT;
        private CardFrsGameRecommendGameLayout jlU;

        public a(View view) {
            super(view);
            this.jlR = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.jlS = (TextView) view.findViewById(R.id.game_recommend_title);
            this.jlT = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.jlU = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.jlU.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.jlU.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.jlM = view.findViewById(R.id.divider_line_1);
            this.iLW = view.findViewById(R.id.divider_line_2);
        }
    }
}
