package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ag8 extends ci<jh8, CardViewHolder<ul6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ul6 b;
    public BdUniqueId c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag8(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), lh8.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        ul6 ul6Var = new ul6(tbPageContext);
        this.b = ul6Var;
        ul6Var.K("c10714", "c10739", "c10712", "c10738");
        this.b.setFrom("home");
    }

    public void t(int i) {
        ul6 ul6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (ul6Var = this.b) != null) {
            ul6Var.k(this.a, i);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
            ul6 ul6Var = this.b;
            if (ul6Var != null) {
                ul6Var.J(bdUniqueId);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: u */
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (this.b == null) {
                ul6 ul6Var = new ul6(this.a);
                this.b = ul6Var;
                ul6Var.J(this.c);
                this.b.K("c10714", "c10739", "c10712", "c10738");
            }
            return new CardViewHolder(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jh8 jh8Var, CardViewHolder cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jh8Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            cardViewHolder.a().j(jh8Var);
            em6.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, xl6.e()));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
