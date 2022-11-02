package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k85 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.d g;
    public dx7 h;
    public View.OnClickListener i;

    public a08(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = relativeLayout;
        this.d = pbFakeFloorModel;
    }

    public final void a() {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null && (k85Var = this.a) != null && k85Var.b() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.c.addView(this.a.b(), layoutParams);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public k85 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (k85) invokeV.objValue;
    }

    public void c() {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k85Var = this.a) != null) {
            k85Var.z();
            if (StringUtils.isNull(this.e)) {
                this.a.E();
            }
            this.a.b().y();
        }
    }

    public void d() {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (k85Var = this.a) != null && k85Var.b() != null) {
            this.a.b().q();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            k85 k85Var = this.a;
            if (k85Var != null && k85Var.b() != null) {
                return this.a.b().u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (k85Var = this.a) != null) {
            k85Var.F();
        }
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            l85 l85Var = new l85(z);
            l85Var.i(str);
            k85 k85Var = (k85) l85Var.a(this.b.getPageActivity());
            this.a = k85Var;
            k85Var.O(this.b);
            this.a.b0(this.d);
            this.a.P(1);
            dx7 dx7Var = this.h;
            if (dx7Var != null) {
                this.a.d0(dx7Var.Q());
            }
            this.a.b().C(true);
            this.a.b().setOnCancelClickListener(this.i);
            this.a.A(this.b);
            a();
            this.a.R(this.g);
        }
    }

    public void g(int i, int i2, Intent intent) {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && (k85Var = this.a) != null) {
            k85Var.D(i, i2, intent);
        }
    }

    public void h(int i) {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (k85Var = this.a) != null && k85Var.b() != null) {
            this.a.b().w(i);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void l(int i) {
        k85 k85Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (k85Var = this.a) != null) {
            k85Var.Q(i);
        }
    }

    public void m(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dx7Var) == null) {
            this.h = dx7Var;
        }
    }

    public void n(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.g = dVar;
            k85 k85Var = this.a;
            if (k85Var != null) {
                k85Var.R(dVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            k85 k85Var = this.a;
            if (k85Var == null) {
                e(str3, z);
            } else {
                k85Var.b0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.A(this.b);
                }
            }
            this.a.X(str);
            this.a.W(str2, "");
            this.a.q(this.f);
            if (this.a.y()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.w(null);
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
