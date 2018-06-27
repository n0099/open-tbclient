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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.e.f, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> drG;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.drG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axv */
            public CardFrsGameRecommendGameItemView mo9if() {
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.dwb.setViewPool(this.drG);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.amP() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dvZ.setText(fVar.amP().title);
            aVar.dvZ.setTextColor(am.getColor(skinType, d.C0142d.cp_cont_b));
            aVar.dwb.setPageContext(this.mPageContext);
            aVar.dwb.setData(fVar.amP().sub_nodes);
            aVar.dwa.setMaxOverScrollDistance(aVar.dwb.getChildItemWidth());
            aVar.dvY.setBackgroundColor(am.getColor(skinType, d.C0142d.cp_bg_line_d));
            am.i(aVar.dvT, d.C0142d.cp_bg_line_e);
            am.i(aVar.cZI, d.C0142d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View cZI;
        private View dvT;
        private LinearLayout dvY;
        private TextView dvZ;
        private FlexibleHorizontalScrollView dwa;
        private CardFrsGameRecommendGameLayout dwb;

        public a(View view) {
            super(view);
            this.dvY = (LinearLayout) view.findViewById(d.g.card_game_recommend_content);
            this.dvZ = (TextView) view.findViewById(d.g.game_recommend_title);
            this.dwa = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_recommend_scroll_container);
            this.dwb = (CardFrsGameRecommendGameLayout) view.findViewById(d.g.game_recommend_container);
            this.dwb.setItemSpace(l.e(view.getContext(), d.e.tbds27));
            this.dwb.setItemWidth(l.e(view.getContext(), d.e.tbds192));
            this.dvT = view.findViewById(d.g.divider_line_1);
            this.cZI = view.findViewById(d.g.divider_line_2);
        }
    }
}
