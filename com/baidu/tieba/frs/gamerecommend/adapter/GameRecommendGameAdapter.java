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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import d.a.c.e.k.b;
import d.a.c.e.k.c;
import d.a.c.e.p.l;
import d.a.j0.d0.f;
import d.a.j0.q0.k;
/* loaded from: classes4.dex */
public class GameRecommendGameAdapter extends k<f, CardFrsGameRecommendGameHolder> {
    public String w;
    public b<CardFrsGameRecommendGameItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16259a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16260b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f16261c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameRecommendGameLayout f16262d;

        /* renamed from: e  reason: collision with root package name */
        public View f16263e;

        /* renamed from: f  reason: collision with root package name */
        public View f16264f;

        public CardFrsGameRecommendGameHolder(GameRecommendGameAdapter gameRecommendGameAdapter, View view) {
            super(view);
            this.f16259a = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.f16260b = (TextView) view.findViewById(R.id.game_recommend_title);
            this.f16261c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.f16262d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.f16262d.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.f16263e = view.findViewById(R.id.divider_line_1);
            this.f16264f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements c<CardFrsGameRecommendGameItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            e(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            h(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        public CardFrsGameRecommendGameItemView e(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            return cardFrsGameRecommendGameItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public CardFrsGameRecommendGameItemView d() {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(GameRecommendGameAdapter.this.f40319e);
            cardFrsGameRecommendGameItemView.setForumId(GameRecommendGameAdapter.this.w);
            return cardFrsGameRecommendGameItemView;
        }

        public CardFrsGameRecommendGameItemView h(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            return cardFrsGameRecommendGameItemView;
        }
    }

    public GameRecommendGameAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.x = new b<>(new a(), 10, 0);
        this.w = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public CardFrsGameRecommendGameHolder P(ViewGroup viewGroup) {
        CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.f40319e).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        cardFrsGameRecommendGameHolder.f16262d.setViewPool(this.x);
        return cardFrsGameRecommendGameHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: w0 */
    public View W(int i2, View view, ViewGroup viewGroup, f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        if (fVar != null && fVar.c() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameRecommendGameHolder.f16260b.setText(fVar.c().title);
            cardFrsGameRecommendGameHolder.f16260b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameRecommendGameHolder.f16262d.setPageContext(this.o);
            cardFrsGameRecommendGameHolder.f16262d.setData(fVar.c().sub_nodes);
            cardFrsGameRecommendGameHolder.f16261c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.f16262d.getChildItemWidth());
            cardFrsGameRecommendGameHolder.f16259a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f16263e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f16264f, R.color.CAM_X0205);
        }
        return cardFrsGameRecommendGameHolder.a();
    }
}
