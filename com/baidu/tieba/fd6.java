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
public class fd6 extends ci<vd6, CardViewHolder<qe6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public zd6 b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd6 a;
        public final /* synthetic */ fd6 b;

        public a(fd6 fd6Var, vd6 vd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd6Var, vd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fd6Var;
            this.a = vd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.x(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd6(TbPageContext tbPageContext, zd6 zd6Var) {
        super(tbPageContext.getPageActivity(), vd6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zd6Var};
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
        this.b = zd6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public CardViewHolder<qe6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new qe6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void u(vd6 vd6Var, qe6 qe6Var) {
        jd6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vd6Var, qe6Var) == null) && (c = vd6Var.c()) != null && c.b() != null) {
            qe6Var.A(0);
            qe6Var.B(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f027b));
            int i = c.b().certify_status;
            if (i == 0) {
                qe6Var.y(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f027f));
                qe6Var.z(0);
            } else if (1 == i) {
                qe6Var.y(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f027e));
                qe6Var.z(4);
            } else if (2 == i) {
                qe6Var.y(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f027c));
                qe6Var.z(4);
            } else if (3 == i) {
                qe6Var.y(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f027d));
                qe6Var.z(0);
            }
            qe6Var.k(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void x(vd6 vd6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, vd6Var) == null) && vd6Var != null && vd6Var.c() != null && vd6Var.c().b() != null && 1 != (i = (b = vd6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            zd6 zd6Var = this.b;
            if (zd6Var != null) {
                zd6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vd6 vd6Var, CardViewHolder<qe6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vd6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            u(vd6Var, cardViewHolder.a());
            cardViewHolder.a().i().setOnClickListener(new a(this, vd6Var));
            return cardViewHolder.a().i();
        }
        return (View) invokeCommon.objValue;
    }
}
