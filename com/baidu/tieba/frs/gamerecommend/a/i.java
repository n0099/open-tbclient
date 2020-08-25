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
/* loaded from: classes16.dex */
public class i extends k<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> ief;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ief = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cqy */
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
    /* renamed from: bt */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.ijw.setViewPool(this.ief);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.cdv() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iju.setText(hVar.cdv().title);
            aVar.iju.setTextColor(ap.getColor(skinType, R.color.cp_cont_b));
            aVar.ijw.setPageContext(this.mPageContext);
            aVar.ijw.setData(hVar.cdv().sub_nodes);
            aVar.ijv.setMaxOverScrollDistance(aVar.ijw.getChildItemWidth());
            aVar.ijt.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_d));
            ap.setBackgroundResource(aVar.ijh, R.color.cp_bg_line_e);
            ap.setBackgroundResource(aVar.hLO, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public class a extends af.a {
        private View hLO;
        private View ijh;
        private LinearLayout ijt;
        private TextView iju;
        private FlexibleHorizontalScrollView ijv;
        private CardFrsGameSpecialTopicLayout ijw;

        public a(View view) {
            super(view);
            this.ijt = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.iju = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.ijv = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.ijw = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.ijw.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.ijw.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.ijh = view.findViewById(R.id.divider_line_1);
            this.hLO = view.findViewById(R.id.divider_line_2);
        }
    }
}
