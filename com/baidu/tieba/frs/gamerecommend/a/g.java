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
    private com.baidu.adp.lib.e.b<CardFrsGameRecommendGameItemView> dut;
    private String mForumId;

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dut = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameRecommendGameItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aya */
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
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_frs_game_recommend_game_layout, viewGroup, false));
        aVar.dyO.setViewPool(this.dut);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.f fVar, a aVar) {
        if (fVar != null && fVar.ano() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dyM.setText(fVar.ano().title);
            aVar.dyM.setTextColor(am.getColor(skinType, d.C0140d.cp_cont_b));
            aVar.dyO.setPageContext(this.mPageContext);
            aVar.dyO.setData(fVar.ano().sub_nodes);
            aVar.dyN.setMaxOverScrollDistance(aVar.dyO.getChildItemWidth());
            aVar.dyL.setBackgroundColor(am.getColor(skinType, d.C0140d.cp_bg_line_d));
            am.i(aVar.dyG, d.C0140d.cp_bg_line_e);
            am.i(aVar.dcA, d.C0140d.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes3.dex */
    public class a extends q.a {
        private View dcA;
        private View dyG;
        private LinearLayout dyL;
        private TextView dyM;
        private FlexibleHorizontalScrollView dyN;
        private CardFrsGameRecommendGameLayout dyO;

        public a(View view) {
            super(view);
            this.dyL = (LinearLayout) view.findViewById(d.g.card_game_recommend_content);
            this.dyM = (TextView) view.findViewById(d.g.game_recommend_title);
            this.dyN = (FlexibleHorizontalScrollView) view.findViewById(d.g.game_recommend_scroll_container);
            this.dyO = (CardFrsGameRecommendGameLayout) view.findViewById(d.g.game_recommend_container);
            this.dyO.setItemSpace(l.f(view.getContext(), d.e.tbds27));
            this.dyO.setItemWidth(l.f(view.getContext(), d.e.tbds192));
            this.dyG = view.findViewById(d.g.divider_line_1);
            this.dcA = view.findViewById(d.g.divider_line_2);
        }
    }
}
