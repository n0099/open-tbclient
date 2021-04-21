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
import d.b.c.e.k.b;
import d.b.c.e.k.c;
import d.b.c.e.p.l;
import d.b.j0.d0.f;
import d.b.j0.q0.k;
/* loaded from: classes4.dex */
public class GameRecommendGameAdapter extends k<f, CardFrsGameRecommendGameHolder> {
    public String w;
    public b<CardFrsGameRecommendGameItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16056a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16057b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f16058c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameRecommendGameLayout f16059d;

        /* renamed from: e  reason: collision with root package name */
        public View f16060e;

        /* renamed from: f  reason: collision with root package name */
        public View f16061f;

        public CardFrsGameRecommendGameHolder(GameRecommendGameAdapter gameRecommendGameAdapter, View view) {
            super(view);
            this.f16056a = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.f16057b = (TextView) view.findViewById(R.id.game_recommend_title);
            this.f16058c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.f16059d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.f16059d.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.f16060e = view.findViewById(R.id.divider_line_1);
            this.f16061f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements c<CardFrsGameRecommendGameItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            e(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            h(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        public CardFrsGameRecommendGameItemView e(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            return cardFrsGameRecommendGameItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public CardFrsGameRecommendGameItemView d() {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(GameRecommendGameAdapter.this.f43095e);
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
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public CardFrsGameRecommendGameHolder R(ViewGroup viewGroup) {
        CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.f43095e).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        cardFrsGameRecommendGameHolder.f16059d.setViewPool(this.x);
        return cardFrsGameRecommendGameHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        if (fVar != null && fVar.a() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameRecommendGameHolder.f16057b.setText(fVar.a().title);
            cardFrsGameRecommendGameHolder.f16057b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameRecommendGameHolder.f16059d.setPageContext(this.o);
            cardFrsGameRecommendGameHolder.f16059d.setData(fVar.a().sub_nodes);
            cardFrsGameRecommendGameHolder.f16058c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.f16059d.getChildItemWidth());
            cardFrsGameRecommendGameHolder.f16056a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f16060e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f16061f, R.color.CAM_X0205);
        }
        return cardFrsGameRecommendGameHolder.a();
    }
}
