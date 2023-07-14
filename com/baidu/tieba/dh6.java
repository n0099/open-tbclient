package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dh6 extends ln<th6, CardViewHolder<oi6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public xh6 b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th6 a;
        public final /* synthetic */ dh6 b;

        public a(dh6 dh6Var, th6 th6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, th6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
            this.a = th6Var;
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
    public dh6(TbPageContext tbPageContext, xh6 xh6Var) {
        super(tbPageContext.getPageActivity(), th6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xh6Var};
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
        this.b = xh6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public CardViewHolder<oi6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new oi6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(th6 th6Var, oi6 oi6Var) {
        hh6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, th6Var, oi6Var) == null) && (c = th6Var.c()) != null && c.b() != null) {
            oi6Var.y(0);
            oi6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0270));
            int i = c.b().certify_status;
            if (i == 0) {
                oi6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
                oi6Var.x(0);
            } else if (1 == i) {
                oi6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0273));
                oi6Var.x(4);
            } else if (2 == i) {
                oi6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0271));
                oi6Var.x(4);
            } else if (3 == i) {
                oi6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0272));
                oi6Var.x(0);
            }
            oi6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(th6 th6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, th6Var) == null) && th6Var != null && th6Var.c() != null && th6Var.c().b() != null && 1 != (i = (b = th6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            xh6 xh6Var = this.b;
            if (xh6Var != null) {
                xh6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, th6 th6Var, CardViewHolder<oi6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, th6Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            t(th6Var, cardViewHolder.b());
            cardViewHolder.b().h().setOnClickListener(new a(this, th6Var));
            return cardViewHolder.b().h();
        }
        return (View) invokeCommon.objValue;
    }
}
