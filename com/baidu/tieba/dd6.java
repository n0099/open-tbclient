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
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.f05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dd6 extends ci<td6, CardViewHolder<qe6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public u4b b;
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
        public final /* synthetic */ td6 a;
        public final /* synthetic */ dd6 b;

        public a(dd6 dd6Var, td6 td6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd6Var, td6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dd6Var;
            this.a = td6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.x(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dd6 dd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), td6.b);
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

    public final void A(TbPageContext tbPageContext) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbPageContext) != null) || tbPageContext == null) {
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
        BdLocationMananger.getInstance().getAddress(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                f05 f05Var = new f05(this.a.getPageActivity());
                f05Var.setAutoNight(false);
                f05Var.setTitle(R.string.obfuscated_res_0x7f0f11b9);
                f05Var.setMessage(this.a.getResources().getString(R.string.disallow_open_live_by_android_v7_0));
                f05Var.setTitleShowCenter(true);
                f05Var.setMessageShowCenter(true);
                f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b86, new b(this));
                f05Var.create(this.a).show();
            } else if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                if (this.b == null) {
                    this.b = new u4b(this.a);
                }
                if (this.c) {
                    if (this.b.c()) {
                        return;
                    }
                } else if (this.b.d()) {
                    return;
                }
                A(this.a);
            }
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public CardViewHolder<qe6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            return new CardViewHolder<>(new qe6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.h) {
            return;
        }
        this.h = true;
        if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), false)) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
            G(this.g, null, true);
            return;
        }
        G(this.g, null, false);
    }

    public final void G(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048582, this, textView, str, z) == null) && textView != null && this.a != null) {
            if (z) {
                textView.setText("");
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080204);
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

    public final void u(td6 td6Var, qe6 qe6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, td6Var, qe6Var) != null) || td6Var.c() == null) {
            return;
        }
        this.g = qe6Var.p();
        F();
        qe6Var.A(8);
        qe6Var.B(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
        qe6Var.k(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void x(td6 td6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, td6Var) == null) && td6Var != null && td6Var.c() != null) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("live_publish_live_has_showed"), true);
            G(this.g, null, false);
            B();
            TiebaStatic.log("c13618");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, td6 td6Var, CardViewHolder<qe6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), view2, viewGroup, td6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            u(td6Var, cardViewHolder.a());
            cardViewHolder.a().i().setOnClickListener(new a(this, td6Var));
            return cardViewHolder.a().i();
        }
        return (View) invokeCommon.objValue;
    }
}
