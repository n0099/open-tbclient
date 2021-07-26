package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameCompetitionItemView;
import com.baidu.tieba.card.CardFrsGameCompetitionLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.k.b;
import d.a.d.e.p.l;
import d.a.q0.g0.c;
import d.a.q0.u0.k;
/* loaded from: classes4.dex */
public class GameCompetitionAdapter extends k<c, CardFrsGameCompetitionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public b<CardFrsGameCompetitionItemView> y;

    /* loaded from: classes4.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15789a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15790b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f15791c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameCompetitionLayout f15792d;

        /* renamed from: e  reason: collision with root package name */
        public View f15793e;

        /* renamed from: f  reason: collision with root package name */
        public View f15794f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameCompetitionHolder(GameCompetitionAdapter gameCompetitionAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCompetitionAdapter, view};
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
            this.f15789a = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.f15790b = (TextView) view.findViewById(R.id.game_competition_title);
            this.f15791c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.f15792d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f15792d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f15793e = view.findViewById(R.id.divider_line_1);
            this.f15794f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.d.e.k.c<CardFrsGameCompetitionItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameCompetitionAdapter f15795a;

        public a(GameCompetitionAdapter gameCompetitionAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCompetitionAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15795a = gameCompetitionAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            e(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView c(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            h(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        public CardFrsGameCompetitionItemView e(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardFrsGameCompetitionItemView)) == null) ? cardFrsGameCompetitionItemView : (CardFrsGameCompetitionItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameCompetitionItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public CardFrsGameCompetitionItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(this.f15795a.f42341e);
                cardFrsGameCompetitionItemView.setForumId(this.f15795a.x);
                return cardFrsGameCompetitionItemView;
            }
            return (CardFrsGameCompetitionItemView) invokeV.objValue;
        }

        public CardFrsGameCompetitionItemView h(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cardFrsGameCompetitionItemView)) == null) ? cardFrsGameCompetitionItemView : (CardFrsGameCompetitionItemView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCompetitionAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
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
    @Override // d.a.d.k.e.a
    /* renamed from: w0 */
    public CardFrsGameCompetitionHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.f42341e).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
            cardFrsGameCompetitionHolder.f15792d.setViewPool(this.y);
            return cardFrsGameCompetitionHolder;
        }
        return (CardFrsGameCompetitionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, cardFrsGameCompetitionHolder})) == null) {
            if (cVar != null && cVar.b() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameCompetitionHolder.f15790b.setText(cVar.b().title);
                cardFrsGameCompetitionHolder.f15790b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
                cardFrsGameCompetitionHolder.f15792d.setPageContext(this.o);
                cardFrsGameCompetitionHolder.f15792d.setData(cVar.b().sub_nodes);
                cardFrsGameCompetitionHolder.f15791c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.f15792d.getChildItemWidth());
                cardFrsGameCompetitionHolder.f15789a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15793e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f15794f, R.color.CAM_X0205);
            }
            return cardFrsGameCompetitionHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
