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
/* loaded from: classes5.dex */
public class a06 extends zz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public b06 d;
    public int e;

    public a06(TbPageContext tbPageContext, rz5 rz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rz5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = rz5Var;
        this.c = tbPageContext;
        rz5Var.a(this);
    }

    @Override // com.baidu.tieba.yz5
    public boolean a(String str) {
        InterceptResult invokeL;
        rz5 rz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            rz5 rz5Var2 = this.b;
            if (rz5Var2 != null) {
                rz5Var2.i(str);
            }
            c06 c06Var = this.a;
            if (c06Var != null && (rz5Var = this.b) != null) {
                c06Var.d(rz5Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yz5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.yz5
    public boolean c(uz5 uz5Var) {
        InterceptResult invokeL;
        rz5 rz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uz5Var)) == null) {
            rz5 rz5Var2 = this.b;
            if (rz5Var2 != null && rz5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            rz5 rz5Var3 = this.b;
            if (rz5Var3 != null) {
                rz5Var3.f(uz5Var);
            }
            c06 c06Var = this.a;
            if (c06Var != null && (rz5Var = this.b) != null) {
                c06Var.d(rz5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zz5, com.baidu.tieba.yz5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c06 c06Var = this.a;
            if (c06Var != null) {
                c06Var.a();
            }
            rz5 rz5Var = this.b;
            if (rz5Var != null && rz5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.zz5
    public void f() {
        rz5 rz5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (rz5Var = this.b) != null && rz5Var.c() != 0) {
            this.b.h("1");
            i();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1");
            if (this.e == 3) {
                str = "3";
            } else {
                str = "2";
            }
            TiebaStatic.log(param.param("obj_source", str));
        }
    }

    @Override // com.baidu.tieba.zz5
    public void g() {
        rz5 rz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rz5Var = this.b) != null && rz5Var.c() != 0) {
            String str = "2";
            this.b.h("2");
            i();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2");
            if (this.e == 3) {
                str = "3";
            }
            TiebaStatic.log(param.param("obj_source", str));
        }
    }

    @Override // com.baidu.tieba.zz5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b06 b06Var = new b06(this.c, this.b);
            this.d = b06Var;
            b06Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.yz5
    public void show() {
        c06 c06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (c06Var = this.a) != null) {
            c06Var.e();
        }
    }

    @Override // com.baidu.tieba.zz5
    public void h(wz5 wz5Var) {
        String str;
        boolean z;
        xz5 xz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wz5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (wz5Var != null) {
                if (wz5Var.a && (xz5Var = wz5Var.c) != null) {
                    list = xz5Var.a;
                    i = xz5Var.c;
                    str = xz5Var.d;
                } else {
                    str = wz5Var.b;
                }
            } else {
                str = "";
            }
            b06 b06Var = this.d;
            if (b06Var != null) {
                b06Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            rz5 rz5Var = this.b;
            if (rz5Var != null && rz5Var.b() != null && this.b.b().g() != null) {
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

    public final void j(Activity activity, boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Boolean.valueOf(z), str}) == null) && activity != null && !TextUtils.isEmpty(str)) {
            View findViewById = activity.findViewById(16908290);
            if (!(findViewById instanceof ViewGroup)) {
                return;
            }
            new BdTopToast(activity, 3000).setIcon(z).setContent(str).show((ViewGroup) findViewById);
        }
    }
}
