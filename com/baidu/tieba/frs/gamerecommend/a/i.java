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
/* loaded from: classes21.dex */
public class i extends k<com.baidu.tieba.f.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> iTo;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iTo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cCv */
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
    /* renamed from: bu */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.iYC.setViewPool(this.iTo);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.h hVar, a aVar) {
        if (hVar != null && hVar.cps() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iYA.setText(hVar.cps().title);
            aVar.iYA.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.iYC.setPageContext(this.mPageContext);
            aVar.iYC.setData(hVar.cps().sub_nodes);
            aVar.iYB.setMaxOverScrollDistance(aVar.iYC.getChildItemWidth());
            aVar.iYz.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.iYn, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iBe, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public class a extends af.a {
        private View iBe;
        private TextView iYA;
        private FlexibleHorizontalScrollView iYB;
        private CardFrsGameSpecialTopicLayout iYC;
        private View iYn;
        private LinearLayout iYz;

        public a(View view) {
            super(view);
            this.iYz = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.iYA = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.iYB = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.iYC = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.iYC.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.iYC.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.iYn = view.findViewById(R.id.divider_line_1);
            this.iBe = view.findViewById(R.id.divider_line_2);
        }
    }
}
