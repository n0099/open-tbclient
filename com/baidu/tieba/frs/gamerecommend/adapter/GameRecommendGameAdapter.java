package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.bg;
import com.baidu.tieba.card.CardFrsGameRecommendGameItemView;
import com.baidu.tieba.card.CardFrsGameRecommendGameLayout;
import com.baidu.tieba.cg;
import com.baidu.tieba.fi7;
import com.baidu.tieba.yx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GameRecommendGameAdapter extends fi7<yx6, CardFrsGameRecommendGameHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public bg<CardFrsGameRecommendGameItemView> m;

    /* loaded from: classes5.dex */
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905e2);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dfe);
            this.c = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090dfd);
            CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout = (CardFrsGameRecommendGameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dfc);
            this.d = cardFrsGameRecommendGameLayout;
            cardFrsGameRecommendGameLayout.setItemSpace(BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds27));
            this.d.setItemWidth(BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds192));
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090906);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090907);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements cg<CardFrsGameRecommendGameItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecommendGameAdapter a;

        public CardFrsGameRecommendGameItemView e(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardFrsGameRecommendGameItemView)) == null) ? cardFrsGameRecommendGameItemView : (CardFrsGameRecommendGameItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameRecommendGameItemView) == null) {
            }
        }

        public CardFrsGameRecommendGameItemView h(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cardFrsGameRecommendGameItemView)) == null) ? cardFrsGameRecommendGameItemView : (CardFrsGameRecommendGameItemView) invokeL.objValue;
        }

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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            e(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ CardFrsGameRecommendGameItemView c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView2 = cardFrsGameRecommendGameItemView;
            h(cardFrsGameRecommendGameItemView2);
            return cardFrsGameRecommendGameItemView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public CardFrsGameRecommendGameItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = new CardFrsGameRecommendGameItemView(this.a.mContext);
                cardFrsGameRecommendGameItemView.setForumId(this.a.l);
                return cardFrsGameRecommendGameItemView;
            }
            return (CardFrsGameRecommendGameItemView) invokeV.objValue;
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
        this.m = new bg<>(new a(this), 10, 0);
        this.l = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: I */
    public CardFrsGameRecommendGameHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder = new CardFrsGameRecommendGameHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d01b9, viewGroup, false));
            cardFrsGameRecommendGameHolder.d.setViewPool(this.m);
            return cardFrsGameRecommendGameHolder;
        }
        return (CardFrsGameRecommendGameHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: J */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yx6 yx6Var, CardFrsGameRecommendGameHolder cardFrsGameRecommendGameHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yx6Var, cardFrsGameRecommendGameHolder})) == null) {
            if (yx6Var != null && yx6Var.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameRecommendGameHolder.b.setText(yx6Var.a().title);
                cardFrsGameRecommendGameHolder.b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameRecommendGameHolder.d.setPageContext(this.c);
                cardFrsGameRecommendGameHolder.d.setData(yx6Var.a().sub_nodes);
                cardFrsGameRecommendGameHolder.c.setMaxOverScrollDistance(cardFrsGameRecommendGameHolder.d.getChildItemWidth());
                cardFrsGameRecommendGameHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameRecommendGameHolder.f, R.color.CAM_X0205);
            }
            return cardFrsGameRecommendGameHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
