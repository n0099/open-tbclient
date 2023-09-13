package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gg6 extends pm<wg6, CardViewHolder<vh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg6 a;
        public final /* synthetic */ gg6 b;

        public a(gg6 gg6Var, wg6 wg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg6Var, wg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gg6Var;
            this.a = wg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), wg6.b);
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
    }

    public final void u(wg6 wg6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wg6Var) == null) && wg6Var != null && wg6Var.c() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLoveFamilyActivityConfig(this.mContext, wg6Var.c().b().user_id)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public CardViewHolder<vh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new vh6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(wg6 wg6Var, vh6 vh6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wg6Var, vh6Var) != null) || wg6Var.c() == null) {
            return;
        }
        vh6Var.y(8);
        vh6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f026f));
        vh6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wg6 wg6Var, CardViewHolder<vh6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wg6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(wg6Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, wg6Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
