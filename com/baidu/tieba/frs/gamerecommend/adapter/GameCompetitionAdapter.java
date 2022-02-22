package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.k.b;
import c.a.d.f.p.n;
import c.a.u0.e1.k;
import c.a.u0.n0.c;
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
/* loaded from: classes12.dex */
public class GameCompetitionAdapter extends k<c, CardFrsGameCompetitionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public b<CardFrsGameCompetitionItemView> y;

    /* loaded from: classes12.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43667b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f43668c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameCompetitionLayout f43669d;

        /* renamed from: e  reason: collision with root package name */
        public View f43670e;

        /* renamed from: f  reason: collision with root package name */
        public View f43671f;

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
            this.a = (LinearLayout) view.findViewById(R.id.card_game_competition_content);
            this.f43667b = (TextView) view.findViewById(R.id.game_competition_title);
            this.f43668c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_competition_scroll_container);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view.findViewById(R.id.game_competition_container);
            this.f43669d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(n.f(view.getContext(), R.dimen.tbds20));
            this.f43669d.setItemWidth(((n.f(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f43670e = view.findViewById(R.id.divider_line_1);
            this.f43671f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes12.dex */
    public class a implements c.a.d.f.k.c<CardFrsGameCompetitionItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameCompetitionAdapter a;

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
            this.a = gameCompetitionAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            e(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameCompetitionItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public CardFrsGameCompetitionItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(this.a.f2447e);
                cardFrsGameCompetitionItemView.setForumId(this.a.x);
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
    @Override // c.a.d.o.e.a
    /* renamed from: o0 */
    public CardFrsGameCompetitionHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.f2447e).inflate(R.layout.card_frs_game_competition_layout, viewGroup, false));
            cardFrsGameCompetitionHolder.f43669d.setViewPool(this.y);
            return cardFrsGameCompetitionHolder;
        }
        return (CardFrsGameCompetitionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.e1.k, c.a.d.o.e.a
    /* renamed from: p0 */
    public View S(int i2, View view, ViewGroup viewGroup, c cVar, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, cardFrsGameCompetitionHolder})) == null) {
            if (cVar != null && cVar.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameCompetitionHolder.f43667b.setText(cVar.a().title);
                cardFrsGameCompetitionHolder.f43667b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
                cardFrsGameCompetitionHolder.f43669d.setPageContext(this.o);
                cardFrsGameCompetitionHolder.f43669d.setData(cVar.a().sub_nodes);
                cardFrsGameCompetitionHolder.f43668c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.f43669d.getChildItemWidth());
                cardFrsGameCompetitionHolder.a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f43670e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f43671f, R.color.CAM_X0205);
            }
            return cardFrsGameCompetitionHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
