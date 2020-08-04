package com.baidu.tieba.frs.gamerecommend.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.tieba.frs.j;
/* loaded from: classes16.dex */
public class i extends j<com.baidu.tieba.e.h, a> {
    private com.baidu.adp.lib.d.b<CardFrsGameSpecialTopicItemView> hPW;
    private String mForumId;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hPW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<CardFrsGameSpecialTopicItemView>() { // from class: com.baidu.tieba.frs.gamerecommend.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cfT */
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
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        aVar.hVp.setViewPool(this.hPW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.h hVar, a aVar) {
        if (hVar != null && hVar.bTj() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hVn.setText(hVar.bTj().title);
            aVar.hVn.setTextColor(ao.getColor(skinType, R.color.cp_cont_b));
            aVar.hVp.setPageContext(this.mPageContext);
            aVar.hVp.setData(hVar.bTj().sub_nodes);
            aVar.hVo.setMaxOverScrollDistance(aVar.hVp.getChildItemWidth());
            aVar.hVm.setBackgroundColor(ao.getColor(skinType, R.color.cp_bg_line_d));
            ao.setBackgroundResource(aVar.hVa, R.color.cp_bg_line_e);
            ao.setBackgroundResource(aVar.hyz, R.color.cp_bg_line_e);
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public class a extends ad.a {
        private View hVa;
        private LinearLayout hVm;
        private TextView hVn;
        private FlexibleHorizontalScrollView hVo;
        private CardFrsGameSpecialTopicLayout hVp;
        private View hyz;

        public a(View view) {
            super(view);
            this.hVm = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.hVn = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.hVo = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            this.hVp = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.hVp.setItemSpace(l.getDimens(view.getContext(), R.dimen.tbds20));
            this.hVp.setItemWidth(((l.getDimens(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.hVa = view.findViewById(R.id.divider_line_1);
            this.hyz = view.findViewById(R.id.divider_line_2);
        }
    }
}
