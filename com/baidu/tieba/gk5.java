package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class gk5 extends fk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public hk5 d;
    public int e;

    public gk5(TbPageContext tbPageContext, xj5 xj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xj5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xj5Var;
        this.c = tbPageContext;
        xj5Var.a(this);
    }

    @Override // com.baidu.tieba.ek5
    public boolean a(String str) {
        InterceptResult invokeL;
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            xj5 xj5Var2 = this.b;
            if (xj5Var2 != null) {
                xj5Var2.i(str);
            }
            ik5 ik5Var = this.a;
            if (ik5Var == null || (xj5Var = this.b) == null) {
                return true;
            }
            ik5Var.d(xj5Var.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ek5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.ek5
    public boolean c(ak5 ak5Var) {
        InterceptResult invokeL;
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ak5Var)) == null) {
            xj5 xj5Var2 = this.b;
            if (xj5Var2 != null && xj5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0301), 30));
                return false;
            }
            xj5 xj5Var3 = this.b;
            if (xj5Var3 != null) {
                xj5Var3.f(ak5Var);
            }
            ik5 ik5Var = this.a;
            if (ik5Var != null && (xj5Var = this.b) != null) {
                ik5Var.d(xj5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fk5, com.baidu.tieba.ek5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ik5 ik5Var = this.a;
            if (ik5Var != null) {
                ik5Var.a();
            }
            xj5 xj5Var = this.b;
            if (xj5Var == null || xj5Var.b() == null || this.b.b().g() == null) {
                return;
            }
            this.b.b().g().a();
        }
    }

    @Override // com.baidu.tieba.fk5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    @Override // com.baidu.tieba.fk5
    public void f() {
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xj5Var = this.b) == null || xj5Var.c() == 0) {
            return;
        }
        this.b.h("1");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.fk5
    public void g() {
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (xj5Var = this.b) == null || xj5Var.c() == 0) {
            return;
        }
        this.b.h("2");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.fk5
    public void h(ck5 ck5Var) {
        String str;
        dk5 dk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ck5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (ck5Var == null) {
                str = "";
            } else if (ck5Var.a && (dk5Var = ck5Var.c) != null) {
                list = dk5Var.a;
                i = dk5Var.c;
                str = dk5Var.d;
            } else {
                str = ck5Var.b;
            }
            hk5 hk5Var = this.d;
            if (hk5Var != null) {
                hk5Var.b();
            }
            j(this.c.getPageActivity(), i == 0, str);
            xj5 xj5Var = this.b;
            if (xj5Var != null && xj5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().b(list);
            }
            if (i == 0) {
                dismiss();
            } else if (!ListUtils.isEmpty(list)) {
                for (String str2 : list) {
                    a(str2);
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hk5 hk5Var = new hk5(this.c, this.b);
            this.d = hk5Var;
            hk5Var.c(this.e);
        }
    }

    public final void j(Activity activity, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Boolean.valueOf(z), str}) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById);
        }
    }

    @Override // com.baidu.tieba.ek5
    public void show() {
        ik5 ik5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ik5Var = this.a) == null) {
            return;
        }
        ik5Var.e();
    }
}
