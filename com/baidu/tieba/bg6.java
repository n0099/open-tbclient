package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bg6 extends pm<rg6, CardViewHolder<wh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rg6 a;
        public final /* synthetic */ bg6 b;

        public a(bg6 bg6Var, rg6 rg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg6Var, rg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bg6Var;
            this.a = rg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.t(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), rg6.b);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public CardViewHolder<wh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return new CardViewHolder<>(new wh6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(rg6 rg6Var) {
        og6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rg6Var) == null) && rg6Var != null && (c = rg6Var.c()) != null && c.b() != null) {
            if (!c.c()) {
                TiebaStatic.log("c11864");
            } else {
                TiebaStatic.log("c11857");
            }
            String string = SharedPrefHelper.getInstance().getString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            if (string == null) {
                return;
            }
            if (string.endsWith("/")) {
                string = string.substring(0, string.length() - 1);
            }
            BrowserHelper.startWebActivity(this.a.getPageActivity(), string);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rg6 rg6Var, CardViewHolder<wh6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rg6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            cardViewHolder.a().i(rg6Var);
            cardViewHolder.a().j(this.a, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.a().k.setOnClickListener(new a(this, rg6Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
