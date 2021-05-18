package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import d.a.c.e.k.b;
import d.a.c.e.k.c;
import d.a.c.e.p.l;
import d.a.k0.d0.h;
import d.a.k0.q0.k;
/* loaded from: classes4.dex */
public class GameSpecialTopicAdapter extends k<h, CardFrsGameSpecialTopicHolder> {
    public String w;
    public b<CardFrsGameSpecialTopicItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15581a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15582b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f15583c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameSpecialTopicLayout f15584d;

        /* renamed from: e  reason: collision with root package name */
        public View f15585e;

        /* renamed from: f  reason: collision with root package name */
        public View f15586f;

        public CardFrsGameSpecialTopicHolder(GameSpecialTopicAdapter gameSpecialTopicAdapter, View view) {
            super(view);
            this.f15581a = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.f15582b = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.f15583c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.f15584d = cardFrsGameSpecialTopicLayout;
            cardFrsGameSpecialTopicLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f15584d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f15585e = view.findViewById(R.id.divider_line_1);
            this.f15586f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements c<CardFrsGameSpecialTopicItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            e(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            h(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        public CardFrsGameSpecialTopicItemView e(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            return cardFrsGameSpecialTopicItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public CardFrsGameSpecialTopicItemView d() {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(GameSpecialTopicAdapter.this.f39564e);
            cardFrsGameSpecialTopicItemView.setForumId(GameSpecialTopicAdapter.this.w);
            return cardFrsGameSpecialTopicItemView;
        }

        public CardFrsGameSpecialTopicItemView h(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            return cardFrsGameSpecialTopicItemView;
        }
    }

    public GameSpecialTopicAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.x = new b<>(new a(), 10, 0);
        this.w = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public CardFrsGameSpecialTopicHolder P(ViewGroup viewGroup) {
        CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(this, LayoutInflater.from(this.f39564e).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        cardFrsGameSpecialTopicHolder.f15584d.setViewPool(this.x);
        return cardFrsGameSpecialTopicHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        if (hVar != null && hVar.c() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameSpecialTopicHolder.f15582b.setText(hVar.c().title);
            cardFrsGameSpecialTopicHolder.f15582b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameSpecialTopicHolder.f15584d.setPageContext(this.o);
            cardFrsGameSpecialTopicHolder.f15584d.setData(hVar.c().sub_nodes);
            cardFrsGameSpecialTopicHolder.f15583c.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.f15584d.getChildItemWidth());
            cardFrsGameSpecialTopicHolder.f15581a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f15585e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f15586f, R.color.CAM_X0205);
        }
        return cardFrsGameSpecialTopicHolder.a();
    }
}
