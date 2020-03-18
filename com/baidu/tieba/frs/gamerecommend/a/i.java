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
/* loaded from: classes9.dex */
public class i extends com.baidu.tieba.frs.h<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> gyw;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gyw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bId */
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
    /* renamed from: bc */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.gDd.setViewPool(this.gyw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.bwM() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gDb.setText(hVar.bwM().title);
            aVar.gDb.setTextColor(am.getColor(skinType, R.color.cp_cont_b));
            aVar.gDd.setPageContext(this.mPageContext);
            aVar.gDd.setData(hVar.bwM().sub_nodes);
            aVar.gDc.setMaxOverScrollDistance(aVar.gDd.getChildItemWidth());
            aVar.gDa.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_d));
            am.setBackgroundResource(aVar.gCO, R.color.cp_bg_line_e);
            am.setBackgroundResource(aVar.giu, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public class a extends v.a {
        private View gCO;
        private LinearLayout gDa;
        private TextView gDb;
        private FlexibleHorizontalScrollView gDc;
        private CardFrsGameSpecialTopicLayout gDd;
        private View giu;

        public a(View view) {
            super(view);
            this.gDa = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.gDb = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.gDc = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.gDd = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.gDd.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.gDd.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.gCO = view.findViewById(R.id.divider_line_1);
            this.giu = view.findViewById(R.id.divider_line_2);
        }
    }
}
