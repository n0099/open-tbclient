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
import d.a.n0.e0.c;
import d.a.n0.r0.k;
/* loaded from: classes4.dex */
public class GameCompetitionAdapter extends k<c, CardFrsGameCompetitionHolder> {
    public String w;
    public b<CardFrsGameCompetitionItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15532a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15533b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f15534c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameCompetitionLayout f15535d;

        /* renamed from: e  reason: collision with root package name */
        public View f15536e;

        /* renamed from: f  reason: collision with root package name */
        public View f15537f;

        public CardFrsGameCompetitionHolder(GameCompetitionAdapter gameCompetitionAdapter, View view) {
            super(view);
            this.f15532a = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.f15533b = (TextView) view.findViewById(R.id.game_competition_title);
            this.f15534c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.f15535d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f15535d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f15536e = view.findViewById(R.id.divider_line_1);
            this.f15537f = view.findViewById(R.id.divider_line_2);
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
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(GameCompetitionAdapter.this.f42909e);
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
        CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.f42909e).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
        cardFrsGameCompetitionHolder.f15535d.setViewPool(this.x);
        return cardFrsGameCompetitionHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        if (cVar != null && cVar.b() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameCompetitionHolder.f15533b.setText(cVar.b().title);
            cardFrsGameCompetitionHolder.f15533b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameCompetitionHolder.f15535d.setPageContext(this.o);
            cardFrsGameCompetitionHolder.f15535d.setData(cVar.b().sub_nodes);
            cardFrsGameCompetitionHolder.f15534c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.f15535d.getChildItemWidth());
            cardFrsGameCompetitionHolder.f15532a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15536e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15537f, R.color.CAM_X0205);
        }
        return cardFrsGameCompetitionHolder.a();
    }
}
