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
public class gt5 extends ft5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public ht5 d;
    public int e;

    public gt5(TbPageContext tbPageContext, xs5 xs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xs5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = xs5Var;
        this.c = tbPageContext;
        xs5Var.a(this);
    }

    @Override // com.baidu.tieba.et5
    public boolean a(String str) {
        InterceptResult invokeL;
        xs5 xs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            xs5 xs5Var2 = this.b;
            if (xs5Var2 != null) {
                xs5Var2.i(str);
            }
            it5 it5Var = this.a;
            if (it5Var != null && (xs5Var = this.b) != null) {
                it5Var.d(xs5Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.et5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.et5
    public boolean c(at5 at5Var) {
        InterceptResult invokeL;
        xs5 xs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, at5Var)) == null) {
            xs5 xs5Var2 = this.b;
            if (xs5Var2 != null && xs5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            xs5 xs5Var3 = this.b;
            if (xs5Var3 != null) {
                xs5Var3.f(at5Var);
            }
            it5 it5Var = this.a;
            if (it5Var != null && (xs5Var = this.b) != null) {
                it5Var.d(xs5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ft5, com.baidu.tieba.et5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            it5 it5Var = this.a;
            if (it5Var != null) {
                it5Var.a();
            }
            xs5 xs5Var = this.b;
            if (xs5Var != null && xs5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.ft5
    public void f() {
        xs5 xs5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xs5Var = this.b) != null && xs5Var.c() != 0) {
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

    @Override // com.baidu.tieba.ft5
    public void g() {
        xs5 xs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (xs5Var = this.b) != null && xs5Var.c() != 0) {
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

    @Override // com.baidu.tieba.ft5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ht5 ht5Var = new ht5(this.c, this.b);
            this.d = ht5Var;
            ht5Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.et5
    public void show() {
        it5 it5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (it5Var = this.a) != null) {
            it5Var.e();
        }
    }

    @Override // com.baidu.tieba.ft5
    public void h(ct5 ct5Var) {
        String str;
        boolean z;
        dt5 dt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ct5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (ct5Var != null) {
                if (ct5Var.a && (dt5Var = ct5Var.c) != null) {
                    list = dt5Var.a;
                    i = dt5Var.c;
                    str = dt5Var.d;
                } else {
                    str = ct5Var.b;
                }
            } else {
                str = "";
            }
            ht5 ht5Var = this.d;
            if (ht5Var != null) {
                ht5Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            xs5 xs5Var = this.b;
            if (xs5Var != null && xs5Var.b() != null && this.b.b().g() != null) {
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
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById);
        }
    }
}
