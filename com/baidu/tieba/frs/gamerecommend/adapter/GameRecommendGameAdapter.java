package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.k.b;
import c.a.e.e.k.c;
import c.a.e.e.p.l;
import c.a.p0.g0.f;
import c.a.p0.v0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class GameRecommendGameAdapter extends k<f, CardFrsGameRecommendGameHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public b<CardFrsGameRecommendGameItemView> y;

    /* loaded from: classes7.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f50964a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50965b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f50966c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameRecommendGameLayout f50967d;

        /* renamed from: e  reason: collision with root package name */
        public View f50968e;

        /* renamed from: f  reason: collision with root package name */
        public View f50969f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameRecommendGameHolder(GameRecommendGameAdapter gameRecommendGameAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecommendGameAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50964a = (LinearLayout) view.findViewById(R.id.card_game_recommend_content);
            this.f50965b = (TextView) view.findViewById(R.id.game_recommend_title);
            this.f50966c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_recommend_scroll_container);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view.findViewById(R.id.game_recommend_container);
            this.f50967d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds27));
            this.f50967d.setItemWidth(l.g(view.getContext(), R.dimen.tbds192));
            this.f50968e = view.findViewById(R.id.divider_line_1);
            this.f50969f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements c<CardFrsGameRecommendGameItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameRecommendGameAdapter f50970a;

        public a(GameRecommendGameAdapter gameRecommendGameAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecommendGameAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50970a = gameRecommendGameAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            e(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            h(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        public CardFrsGameRecommendGameItemView e(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardFrsGameRecommendGameItemView)) == null) ? cardFrsGameRecommendGameItemView : (CardFrsGameRecommendGameItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameRecommendGameItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public CardFrsGameRecommendGameItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(this.f50970a.f2904e);
                cardFrsGameRecommendGameItemView.setForumId(this.f50970a.x);
                return cardFrsGameRecommendGameItemView;
            }
            return (CardFrsGameRecommendGameItemView) invokeV.objValue;
        }

        public CardFrsGameRecommendGameItemView h(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cardFrsGameRecommendGameItemView)) == null) ? cardFrsGameRecommendGameItemView : (CardFrsGameRecommendGameItemView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRecommendGameAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = new b<>(new a(this), 10, 0);
        this.x = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: w0 */
    public CardFrsGameRecommendGameHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.f2904e).inflate(R.layout.card_frs_game_recommend_game_layout, viewGroup, false));
            cardFrsGameRecommendGameHolder.f50967d.setViewPool(this.y);
            return cardFrsGameRecommendGameHolder;
        }
        return (CardFrsGameRecommendGameHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    /* renamed from: x0 */
    public View a0(int i2, View view, ViewGroup viewGroup, f fVar, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, cardFrsGameRecommendGameHolder})) == null) {
            if (fVar != null && fVar.b() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameRecommendGameHolder.f50965b.setText(fVar.b().title);
                cardFrsGameRecommendGameHolder.f50965b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
                cardFrsGameRecommendGameHolder.f50967d.setPageContext(this.o);
                cardFrsGameRecommendGameHolder.f50967d.setData(fVar.b().sub_nodes);
                cardFrsGameRecommendGameHolder.f50966c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.f50967d.getChildItemWidth());
                cardFrsGameRecommendGameHolder.f50964a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f50968e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f50969f, R.color.CAM_X0205);
            }
            return cardFrsGameRecommendGameHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
