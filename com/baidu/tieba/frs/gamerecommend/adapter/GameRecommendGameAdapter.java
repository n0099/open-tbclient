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
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag;
import com.repackage.bg;
import com.repackage.f16;
import com.repackage.fb6;
import com.repackage.li;
/* loaded from: classes3.dex */
public class GameRecommendGameAdapter extends fb6<f16, CardFrsGameRecommendGameHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public ag<CardFrsGameRecommendGameItemView> u;

    /* loaded from: classes3.dex */
    public class CardFrsGameRecommendGameHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public FlexibleHorizontalScrollView c;
        public CardFrsGameRecommendGameLayout d;
        public View e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameRecommendGameHolder(GameRecommendGameAdapter gameRecommendGameAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecommendGameAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090528);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c27);
            this.c = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090c26);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c25);
            this.d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(li.f(view2.getContext(), R.dimen.tbds27));
            this.d.setItemWidth(li.f(view2.getContext(), R.dimen.tbds192));
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0907d9);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907da);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements bg<CardFrsGameRecommendGameItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecommendGameAdapter a;

        public a(GameRecommendGameAdapter gameRecommendGameAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecommendGameAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRecommendGameAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            e(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameRecommendGameItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public CardFrsGameRecommendGameItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(this.a.a);
                cardFrsGameRecommendGameItemView.setForumId(this.a.t);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new ag<>(new a(this), 10, 0);
        this.t = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: n0 */
    public CardFrsGameRecommendGameHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d018a, viewGroup, false));
            cardFrsGameRecommendGameHolder.d.setViewPool(this.u);
            return cardFrsGameRecommendGameHolder;
        }
        return (CardFrsGameRecommendGameHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, f16 f16Var, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, f16Var, cardFrsGameRecommendGameHolder})) == null) {
            if (f16Var != null && f16Var.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameRecommendGameHolder.b.setText(f16Var.a().title);
                cardFrsGameRecommendGameHolder.b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameRecommendGameHolder.d.setPageContext(this.k);
                cardFrsGameRecommendGameHolder.d.setData(f16Var.a().sub_nodes);
                cardFrsGameRecommendGameHolder.c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.d.getChildItemWidth());
                cardFrsGameRecommendGameHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f, R.color.CAM_X0205);
            }
            return cardFrsGameRecommendGameHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
