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
import com.baidu.tieba.fj;
import com.baidu.tieba.i76;
import com.baidu.tieba.kh6;
import com.baidu.tieba.vg;
import com.baidu.tieba.wg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GameCompetitionAdapter extends kh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public vg m;

    /* loaded from: classes4.dex */
    public class CardFrsGameCompetitionHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public FlexibleHorizontalScrollView c;
        public CardFrsGameCompetitionLayout d;
        public View e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameCompetitionHolder(GameCompetitionAdapter gameCompetitionAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCompetitionAdapter, view2};
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09053c);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c71);
            this.c = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090c70);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c6f);
            this.d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(fj.f(view2.getContext(), R.dimen.tbds20));
            this.d.setItemWidth(((fj.f(view2.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090816);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090817);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameCompetitionAdapter a;

        public CardFrsGameCompetitionItemView e(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardFrsGameCompetitionItemView)) == null) ? cardFrsGameCompetitionItemView : (CardFrsGameCompetitionItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameCompetitionItemView) == null) {
            }
        }

        public CardFrsGameCompetitionItemView h(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cardFrsGameCompetitionItemView)) == null) ? cardFrsGameCompetitionItemView : (CardFrsGameCompetitionItemView) invokeL.objValue;
        }

        public a(GameCompetitionAdapter gameCompetitionAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCompetitionAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameCompetitionAdapter;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) obj;
            e(cardFrsGameCompetitionItemView);
            return cardFrsGameCompetitionItemView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) obj;
            h(cardFrsGameCompetitionItemView);
            return cardFrsGameCompetitionItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public CardFrsGameCompetitionItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(this.a.mContext);
                cardFrsGameCompetitionItemView.setForumId(this.a.l);
                return cardFrsGameCompetitionItemView;
            }
            return (CardFrsGameCompetitionItemView) invokeV.objValue;
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
        this.m = new vg(new a(this), 10, 0);
        this.l = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: G */
    public CardFrsGameCompetitionHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0187, viewGroup, false));
            cardFrsGameCompetitionHolder.d.setViewPool(this.m);
            return cardFrsGameCompetitionHolder;
        }
        return (CardFrsGameCompetitionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6, com.baidu.tieba.rn
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, i76 i76Var, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, i76Var, cardFrsGameCompetitionHolder})) == null) {
            if (i76Var != null && i76Var.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameCompetitionHolder.b.setText(i76Var.a().title);
                cardFrsGameCompetitionHolder.b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameCompetitionHolder.d.setPageContext(this.c);
                cardFrsGameCompetitionHolder.d.setData(i76Var.a().sub_nodes);
                cardFrsGameCompetitionHolder.c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.d.getChildItemWidth());
                cardFrsGameCompetitionHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f, R.color.CAM_X0205);
            }
            return cardFrsGameCompetitionHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
