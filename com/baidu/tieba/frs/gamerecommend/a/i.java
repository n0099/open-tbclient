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
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.frs.k;
/* loaded from: classes22.dex */
public class i extends k<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> iSB;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iSB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cCR */
            public CardFrsGameSpecialTopicItemView makeObject() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView activateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public CardFrsGameSpecialTopicItemView passivateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }
        }, 10, 0);
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.iXQ.setViewPool(this.iSB);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.cpP() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iXO.setText(hVar.cpP().title);
            aVar.iXO.setTextColor(ap.getColor(skinType, R.color.cp_cont_b));
            aVar.iXQ.setPageContext(this.mPageContext);
            aVar.iXQ.setData(hVar.cpP().sub_nodes);
            aVar.iXP.setMaxOverScrollDistance(aVar.iXQ.getChildItemWidth());
            aVar.iXN.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_d));
            ap.setBackgroundResource(aVar.iXB, R.color.cp_bg_line_e);
            ap.setBackgroundResource(aVar.iAp, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iAp;
        private View iXB;
        private LinearLayout iXN;
        private TextView iXO;
        private FlexibleHorizontalScrollView iXP;
        private CardFrsGameSpecialTopicLayout iXQ;

        public a(View view) {
            super(view);
            this.iXN = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.iXO = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.iXP = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.iXQ = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.iXQ.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.iXQ.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.iXB = view.findViewById(R.id.divider_line_1);
            this.iAp = view.findViewById(R.id.divider_line_2);
        }
    }
}
