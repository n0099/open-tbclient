package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bh6 extends ln<rh6, CardViewHolder<oi6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public lka b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public TextView g;
    public boolean h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;
        public final /* synthetic */ bh6 b;

        public a(bh6 bh6Var, rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var, rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bh6Var;
            this.a = rh6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bh6 bh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), rh6.b);
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
        this.c = false;
        this.h = false;
        this.a = tbPageContext;
    }

    public final void z(TbPageContext tbPageContext) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        if (this.c) {
            str = this.d;
        } else {
            str = "0";
        }
        String str4 = str;
        if (this.c) {
            str2 = this.e;
        } else {
            str2 = null;
        }
        if (this.c) {
            str3 = this.f;
        } else {
            str3 = null;
        }
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
        sf.n().j(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                p55 p55Var = new p55(this.a.getPageActivity());
                p55Var.setAutoNight(false);
                p55Var.setTitle(R.string.obfuscated_res_0x7f0f115c);
                p55Var.setMessage(this.a.getResources().getString(R.string.disallow_open_live_by_android_v7_0));
                p55Var.setTitleShowCenter(true);
                p55Var.setMessageShowCenter(true);
                p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b3d, new b(this));
                p55Var.create(this.a).show();
            } else if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                if (this.b == null) {
                    this.b = new lka(this.a);
                }
                if (this.c) {
                    if (this.b.c()) {
                        return;
                    }
                } else if (this.b.d()) {
                    return;
                }
                z(this.a);
            }
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f = str;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public CardViewHolder<oi6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            return new CardViewHolder<>(new oi6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.h) {
            return;
        }
        this.h = true;
        if (!da5.p().l(da5.t("live_publish_live_has_showed"), false)) {
            da5.p().A(da5.t("live_publish_live_has_showed"), true);
            F(this.g, null, true);
            return;
        }
        F(this.g, null, false);
    }

    public final void F(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048581, this, textView, str, z) == null) && textView != null && this.a != null) {
            if (z) {
                textView.setText("");
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801fc);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText("");
            }
            textView.setCompoundDrawables(null, null, null, null);
        }
    }

    public final void t(rh6 rh6Var, oi6 oi6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, rh6Var, oi6Var) != null) || rh6Var.c() == null) {
            return;
        }
        this.g = oi6Var.r();
        E();
        oi6Var.y(8);
        oi6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0269));
        oi6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void u(rh6 rh6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, rh6Var) == null) && rh6Var != null && rh6Var.c() != null) {
            da5.p().A(da5.t("live_publish_live_has_showed"), true);
            F(this.g, null, false);
            A();
            TiebaStatic.log("c13618");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rh6 rh6Var, CardViewHolder<oi6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rh6Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            t(rh6Var, cardViewHolder.b());
            cardViewHolder.b().h().setOnClickListener(new a(this, rh6Var));
            return cardViewHolder.b().h();
        }
        return (View) invokeCommon.objValue;
    }
}
