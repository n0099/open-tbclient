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
/* loaded from: classes21.dex */
public class g extends k<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> ill;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ill = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ctL */
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
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.iqx.setViewPool(this.ill);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.cgJ() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iqv.setText(fVar.cgJ().title);
            aVar.iqv.setTextColor(ap.getColor(skinType, R.color.cp_cont_b));
            aVar.iqx.setPageContext(this.mPageContext);
            aVar.iqx.setData(fVar.cgJ().sub_nodes);
            aVar.iqw.setMaxOverScrollDistance(aVar.iqx.getChildItemWidth());
            aVar.iqu.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_d));
            ap.setBackgroundResource(aVar.iqp, R.color.cp_bg_line_e);
            ap.setBackgroundResource(aVar.hSV, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public class a extends af.a {
        private View hSV;
        private View iqp;
        private LinearLayout iqu;
        private TextView iqv;
        private FlexibleHorizontalScrollView iqw;
        private CardFrsGameRecommendGameLayout iqx;

        public a(View view) {
            super(view);
            this.iqu = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.iqv = (TextView) view.findViewById(R.id.game_recommend_title);
            this.iqw = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.iqx = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.iqx.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.iqx.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.iqp = view.findViewById(R.id.divider_line_1);
            this.hSV = view.findViewById(R.id.divider_line_2);
        }
    }
}
