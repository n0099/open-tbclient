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
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameRecommendGameItemView> gsn;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gsn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bFj */
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
    /* renamed from: aW */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.gwA.setViewPool(this.gsn);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.btW() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gwy.setText(fVar.btW().title);
            aVar.gwy.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.gwA.setPageContext(this.mPageContext);
            aVar.gwA.setData(fVar.btW().sub_nodes);
            aVar.gwz.setMaxOverScrollDistance(aVar.gwA.getChildItemWidth());
            aVar.gwx.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.gws, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.gcl, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        private View gcl;
        private CardFrsGameRecommendGameLayout gwA;
        private View gws;
        private LinearLayout gwx;
        private TextView gwy;
        private FlexibleHorizontalScrollView gwz;

        public a(View view) {
            super(view);
            this.gwx = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.gwy = (TextView) view.findViewById(R.id.game_recommend_title);
            this.gwz = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            this.gwA = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.gwA.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds27));
            this.gwA.setItemWidth(l.getDimens(view.getContext(), R.dimen.tbds192));
            this.gws = view.findViewById(R.id.divider_line_1);
            this.gcl = view.findViewById(R.id.divider_line_2);
        }
    }
}
