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
public class i extends k<com.baidu.tieba.f.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> jem;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jem = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHH */
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
    /* renamed from: bx */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.jmd.setViewPool(this.jem);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.f.h hVar, a aVar) {
        if (hVar != null && hVar.ctH() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jmb.setText(hVar.ctH().title);
            aVar.jmb.setTextColor(ap.getColor(skinType, R.color.CAM_X0105));
            aVar.jmd.setPageContext(this.mPageContext);
            aVar.jmd.setData(hVar.ctH().sub_nodes);
            aVar.jmc.setMaxOverScrollDistance(aVar.jmd.getChildItemWidth());
            aVar.jma.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0201));
            ap.setBackgroundResource(aVar.jlO, R.color.CAM_X0205);
            ap.setBackgroundResource(aVar.iLY, R.color.CAM_X0205);
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public class a extends af.a {
        private View iLY;
        private View jlO;
        private LinearLayout jma;
        private TextView jmb;
        private FlexibleHorizontalScrollView jmc;
        private CardFrsGameSpecialTopicLayout jmd;

        public a(View view) {
            super(view);
            this.jma = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.jmb = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.jmc = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.jmd = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.jmd.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.jmd.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.jlO = view.findViewById(R.id.divider_line_1);
            this.iLY = view.findViewById(R.id.divider_line_2);
        }
    }
}
