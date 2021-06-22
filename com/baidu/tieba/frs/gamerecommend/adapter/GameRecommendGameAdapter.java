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
import d.a.o0.e0.f;
import d.a.o0.r0.k;
/* loaded from: classes4.dex */
public class GameRecommendGameAdapter extends k<f, CardFrsGameRecommendGameHolder> {
    public String w;
    public b<CardFrsGameRecommendGameItemView> x;

    /* loaded from: classes4.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15621a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15622b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f15623c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameRecommendGameLayout f15624d;

        /* renamed from: e  reason: collision with root package name */
        public View f15625e;

        /* renamed from: f  reason: collision with root package name */
        public View f15626f;

        public CardFrsGameRecommendGameHolder(GameRecommendGameAdapter gameRecommendGameAdapter, View view) {
            super(view);
            this.f15621a = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.f15622b = (TextView) view.findViewById(R.id.game_recommend_title);
            this.f15623c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.f15624d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.f15624d.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.f15625e = view.findViewById(R.id.divider_line_1);
            this.f15626f = view.findViewById(R.id.divider_line_2);
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
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(GameRecommendGameAdapter.this.f43012e);
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
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public CardFrsGameRecommendGameHolder Q(ViewGroup viewGroup) {
        CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.f43012e).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
        cardFrsGameRecommendGameHolder.f15624d.setViewPool(this.x);
        return cardFrsGameRecommendGameHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        if (fVar != null && fVar.b() != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            cardFrsGameRecommendGameHolder.f15622b.setText(fVar.b().title);
            cardFrsGameRecommendGameHolder.f15622b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
            cardFrsGameRecommendGameHolder.f15624d.setPageContext(this.o);
            cardFrsGameRecommendGameHolder.f15624d.setData(fVar.b().sub_nodes);
            cardFrsGameRecommendGameHolder.f15623c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.f15624d.getChildItemWidth());
            cardFrsGameRecommendGameHolder.f15621a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f15625e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f15626f, R.color.CAM_X0205);
        }
        return cardFrsGameRecommendGameHolder.a();
    }
}
