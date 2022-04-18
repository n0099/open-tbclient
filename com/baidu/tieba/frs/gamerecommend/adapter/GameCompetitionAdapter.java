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
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.kd6;
import com.repackage.oi;
import com.repackage.q26;
/* loaded from: classes3.dex */
public class GameCompetitionAdapter extends kd6<q26, CardFrsGameCompetitionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public dg<CardFrsGameCompetitionItemView> u;

    /* loaded from: classes3.dex */
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090530);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c4a);
            this.c = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090c49);
            CardFrsGameCompetitionLayout cardFrsGameCompetitionLayout = (CardFrsGameCompetitionLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c48);
            this.d = cardFrsGameCompetitionLayout;
            cardFrsGameCompetitionLayout.setItemSpace(oi.f(view2.getContext(), R.dimen.tbds20));
            this.d.setItemWidth(((oi.f(view2.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0907fe);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907ff);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements eg<CardFrsGameCompetitionItemView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ CardFrsGameCompetitionItemView a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView2 = cardFrsGameCompetitionItemView;
            e(cardFrsGameCompetitionItemView2);
            return cardFrsGameCompetitionItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameCompetitionItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public CardFrsGameCompetitionItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = new CardFrsGameCompetitionItemView(this.a.a);
                cardFrsGameCompetitionItemView.setForumId(this.a.t);
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
        this.u = new dg<>(new a(this), 10, 0);
        this.t = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: n0 */
    public CardFrsGameCompetitionHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder = new CardFrsGameCompetitionHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d018e, viewGroup, false));
            cardFrsGameCompetitionHolder.d.setViewPool(this.u);
            return cardFrsGameCompetitionHolder;
        }
        return (CardFrsGameCompetitionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kd6, com.repackage.ho
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, q26 q26Var, CardFrsGameCompetitionHolder cardFrsGameCompetitionHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q26Var, cardFrsGameCompetitionHolder})) == null) {
            if (q26Var != null && q26Var.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameCompetitionHolder.b.setText(q26Var.a().title);
                cardFrsGameCompetitionHolder.b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameCompetitionHolder.d.setPageContext(this.k);
                cardFrsGameCompetitionHolder.d.setData(q26Var.a().sub_nodes);
                cardFrsGameCompetitionHolder.c.setMaxOverScrollDistance(cardFrsGameCompetitionHolder.d.getChildItemWidth());
                cardFrsGameCompetitionHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameCompetitionHolder.f, R.color.CAM_X0205);
            }
            return cardFrsGameCompetitionHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
