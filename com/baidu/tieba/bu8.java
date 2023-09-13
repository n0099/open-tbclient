package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bu8 extends pm<xt8, CardViewHolder<cu8>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public mp6 b;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    }

    @Override // com.baidu.tieba.pm
    public mn getOnAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.getOnAdapterItemClickListener();
        }
        return (mn) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public CardViewHolder<cu8> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cu8 cu8Var = new cu8(this.a, viewGroup);
            mp6 mp6Var = this.b;
            if (mp6Var != null) {
                cu8Var.k(mp6Var);
            }
            return new CardViewHolder<>(cu8Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public void x(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mp6Var) == null) {
            this.b = mp6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xt8 xt8Var, CardViewHolder<cu8> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xt8Var, cardViewHolder})) == null) {
            if (xt8Var != null && cardViewHolder != null && cardViewHolder.a() != null) {
                cardViewHolder.a().z(this.c);
                cardViewHolder.a().i(xt8Var);
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
