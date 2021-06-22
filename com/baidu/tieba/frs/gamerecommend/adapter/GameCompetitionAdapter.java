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
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import d.a.c.e.k.b;
import d.a.c.e.p.l;
import d.a.o0.e0.c;
import d.a.o0.r0.k;
/* loaded from: classes4.dex */
public class GameCompetitionAdapter extends k<c, CardFrsGameCompetitionHolder> {
    public String w;
    public b<CardFrsGameCompetitionItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15614a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15615b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f15616c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameCompetitionLayout f15617d;

        /* renamed from: e  reason: collision with root package name */
        public View f15618e;

        /* renamed from: f  reason: collision with root package name */
        public View f15619f;

        public CardFrsGameCompetitionHolder(GameCompetitionAdapter gameCompetitionAdapter, View view) {
            super(view);
            this.f15614a = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.f15615b = (TextView) view.findViewById(R.id.game_competition_title);
            this.f15616c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.f15617d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f15617d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f15618e = view.findViewById(R.id.divider_line_1);
            this.f15619f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<CardFrsGameCompetitionItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            e(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView c(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            h(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        public CardFrsGameCompetitionItemView e(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            return cardFrsGameCompetitionItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public CardFrsGameCompetitionItemView d() {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(GameCompetitionAdapter.this.f43012e);
            cardFrsGameCompetitionItemView.setForumId(GameCompetitionAdapter.this.w);
            return cardFrsGameCompetitionItemView;
        }

        public CardFrsGameCompetitionItemView h(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            return cardFrsGameCompetitionItemView;
        }
    }

    public GameCompetitionAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.x = new b<>(new a(), 10, 0);
        this.w = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public CardFrsGameCompetitionHolder Q(ViewGroup viewGroup) {
        CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.f43012e).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        cardFrsGameCompetitionHolder.f15617d.setViewPool(this.x);
        return cardFrsGameCompetitionHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        if (cVar != null && cVar.b() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameCompetitionHolder.f15615b.setText(cVar.b().title);
            cardFrsGameCompetitionHolder.f15615b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameCompetitionHolder.f15617d.setPageContext(this.o);
            cardFrsGameCompetitionHolder.f15617d.setData(cVar.b().sub_nodes);
            cardFrsGameCompetitionHolder.f15616c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.f15617d.getChildItemWidth());
            cardFrsGameCompetitionHolder.f15614a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15618e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15619f, R.color.CAM_X0205);
        }
        return cardFrsGameCompetitionHolder.a();
    }
}
