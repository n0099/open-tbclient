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
public class ey5 extends dy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public fy5 d;
    public int e;

    public ey5(TbPageContext tbPageContext, vx5 vx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vx5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = vx5Var;
        this.c = tbPageContext;
        vx5Var.a(this);
    }

    @Override // com.baidu.tieba.cy5
    public boolean a(String str) {
        InterceptResult invokeL;
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            vx5 vx5Var2 = this.b;
            if (vx5Var2 != null) {
                vx5Var2.i(str);
            }
            gy5 gy5Var = this.a;
            if (gy5Var != null && (vx5Var = this.b) != null) {
                gy5Var.d(vx5Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cy5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.cy5
    public boolean c(yx5 yx5Var) {
        InterceptResult invokeL;
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yx5Var)) == null) {
            vx5 vx5Var2 = this.b;
            if (vx5Var2 != null && vx5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            vx5 vx5Var3 = this.b;
            if (vx5Var3 != null) {
                vx5Var3.f(yx5Var);
            }
            gy5 gy5Var = this.a;
            if (gy5Var != null && (vx5Var = this.b) != null) {
                gy5Var.d(vx5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.dy5, com.baidu.tieba.cy5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gy5 gy5Var = this.a;
            if (gy5Var != null) {
                gy5Var.a();
            }
            vx5 vx5Var = this.b;
            if (vx5Var != null && vx5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.dy5
    public void f() {
        vx5 vx5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (vx5Var = this.b) != null && vx5Var.c() != 0) {
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

    @Override // com.baidu.tieba.dy5
    public void g() {
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (vx5Var = this.b) != null && vx5Var.c() != 0) {
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

    @Override // com.baidu.tieba.dy5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            fy5 fy5Var = new fy5(this.c, this.b);
            this.d = fy5Var;
            fy5Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.cy5
    public void show() {
        gy5 gy5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (gy5Var = this.a) != null) {
            gy5Var.e();
        }
    }

    @Override // com.baidu.tieba.dy5
    public void h(ay5 ay5Var) {
        String str;
        boolean z;
        by5 by5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ay5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (ay5Var != null) {
                if (ay5Var.a && (by5Var = ay5Var.c) != null) {
                    list = by5Var.a;
                    i = by5Var.c;
                    str = by5Var.d;
                } else {
                    str = ay5Var.b;
                }
            } else {
                str = "";
            }
            fy5 fy5Var = this.d;
            if (fy5Var != null) {
                fy5Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            vx5 vx5Var = this.b;
            if (vx5Var != null && vx5Var.b() != null && this.b.b().g() != null) {
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
