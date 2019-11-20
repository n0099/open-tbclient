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
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.e.b<CardFrsGameSpecialTopicItemView> fDU;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fDU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnN */
            public CardFrsGameSpecialTopicItemView makeObject() {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(i.this.mContext);
                cardFrsGameSpecialTopicItemView.setForumId(i.this.mForumId);
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void destroyObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public CardFrsGameSpecialTopicItemView activateObject(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
                return cardFrsGameSpecialTopicItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
    /* renamed from: ba */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.fIs.setViewPool(this.fDU);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.bcB() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fIq.setText(hVar.bcB().title);
            aVar.fIq.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.fIs.setPageContext(this.mPageContext);
            aVar.fIs.setData(hVar.bcB().sub_nodes);
            aVar.fIr.setMaxOverScrollDistance(aVar.fIs.getChildItemWidth());
            aVar.fIp.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.fId, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.fnP, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public class a extends v.a {
        private View fId;
        private LinearLayout fIp;
        private TextView fIq;
        private FlexibleHorizontalScrollView fIr;
        private CardFrsGameSpecialTopicLayout fIs;
        private View fnP;

        public a(View view) {
            super(view);
            this.fIp = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.fIq = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.fIr = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.fIs = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.fIs.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.fIs.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.fId = view.findViewById(R.id.divider_line_1);
            this.fnP = view.findViewById(R.id.divider_line_2);
        }
    }
}
