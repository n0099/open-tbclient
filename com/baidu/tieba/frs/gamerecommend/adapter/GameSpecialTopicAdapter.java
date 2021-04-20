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
import d.b.c.e.k.b;
import d.b.c.e.k.c;
import d.b.c.e.p.l;
import d.b.i0.d0.h;
import d.b.i0.q0.k;
/* loaded from: classes4.dex */
public class GameSpecialTopicAdapter extends k<h, CardFrsGameSpecialTopicHolder> {
    public String w;
    public b<CardFrsGameSpecialTopicItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16055a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16056b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f16057c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameSpecialTopicLayout f16058d;

        /* renamed from: e  reason: collision with root package name */
        public View f16059e;

        /* renamed from: f  reason: collision with root package name */
        public View f16060f;

        public CardFrsGameSpecialTopicHolder(GameSpecialTopicAdapter gameSpecialTopicAdapter, View view) {
            super(view);
            this.f16055a = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.f16056b = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.f16057c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.f16058d = cardFrsGameSpecialTopicLayout;
            cardFrsGameSpecialTopicLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f16058d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f16059e = view.findViewById(R.id.divider_line_1);
            this.f16060f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements c<CardFrsGameSpecialTopicItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            e(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            h(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        public CardFrsGameSpecialTopicItemView e(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            return cardFrsGameSpecialTopicItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public CardFrsGameSpecialTopicItemView d() {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(GameSpecialTopicAdapter.this.f42855e);
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
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public CardFrsGameSpecialTopicHolder R(ViewGroup viewGroup) {
        CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(this, LayoutInflater.from(this.f42855e).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
        cardFrsGameSpecialTopicHolder.f16058d.setViewPool(this.x);
        return cardFrsGameSpecialTopicHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        if (hVar != null && hVar.a() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameSpecialTopicHolder.f16056b.setText(hVar.a().title);
            cardFrsGameSpecialTopicHolder.f16056b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameSpecialTopicHolder.f16058d.setPageContext(this.o);
            cardFrsGameSpecialTopicHolder.f16058d.setData(hVar.a().sub_nodes);
            cardFrsGameSpecialTopicHolder.f16057c.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.f16058d.getChildItemWidth());
            cardFrsGameSpecialTopicHolder.f16055a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f16059e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f16060f, R.color.CAM_X0205);
        }
        return cardFrsGameSpecialTopicHolder.a();
    }
}
