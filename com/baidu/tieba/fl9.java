package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hk5 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.d g;
    public yh9 h;
    public View.OnClickListener i;
    public int j;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl9 a;

        public a(fl9 fl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fl9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !(TbadkCoreApplication.getInst().getCurrentActivity() instanceof PbCommentFloatActivity) || ((PbCommentFloatActivity) TbadkCoreApplication.getInst().getCurrentActivity()).l2() || this.a.a == null) {
                return;
            }
            for (li5 li5Var : this.a.a.a().getAllTools()) {
                if (li5Var != null) {
                    mi5 mi5Var = li5Var.m;
                    if ((mi5Var instanceof PbNewInputContainer) && ((View) mi5Var).getVisibility() == 0 && !li5Var.o) {
                        li5Var.m.display();
                    }
                }
            }
            if (this.a.j < 5) {
                fl9.c(this.a);
                SafeHandler.getInst().postDelayed(this.a.k, 200L);
            }
        }
    }

    public fl9(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
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
        this.j = 0;
        this.k = new a(this);
        this.b = tbPageContext;
        this.c = relativeLayout;
        this.d = pbFakeFloorModel;
    }

    public static /* synthetic */ int c(fl9 fl9Var) {
        int i = fl9Var.j;
        fl9Var.j = i + 1;
        return i;
    }

    public void l(int i) {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (hk5Var = this.a) != null && hk5Var.a() != null) {
            this.a.a().z(i);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f = str;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void q(int i) {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (hk5Var = this.a) != null) {
            hk5Var.S(i);
        }
    }

    public void r(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, yh9Var) == null) {
            this.h = yh9Var;
        }
    }

    public void s(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.g = dVar;
            hk5 hk5Var = this.a;
            if (hk5Var != null) {
                hk5Var.T(dVar);
            }
        }
    }

    public final void e() {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null && (hk5Var = this.a) != null && hk5Var.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.c.addView(this.a.a(), layoutParams);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public hk5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (hk5) invokeV.objValue;
    }

    public void g() {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hk5Var = this.a) != null) {
            hk5Var.A();
            if (StringUtils.isNull(this.e)) {
                this.a.G();
            }
            this.a.a().B();
        }
    }

    public void h() {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hk5Var = this.a) != null && hk5Var.a() != null) {
            this.a.a().t();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hk5 hk5Var = this.a;
            if (hk5Var != null && hk5Var.a() != null) {
                return this.a.a().x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.k);
            hk5 hk5Var = this.a;
            if (hk5Var != null) {
                hk5Var.F();
            }
        }
    }

    public void n() {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (hk5Var = this.a) != null) {
            hk5Var.H();
        }
    }

    public final void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            ik5 ik5Var = new ik5(z);
            ik5Var.i(str);
            hk5 hk5Var = (hk5) ik5Var.a(this.b.getPageActivity());
            this.a = hk5Var;
            hk5Var.Q(this.b);
            this.a.d0(this.d);
            this.a.R(1);
            yh9 yh9Var = this.h;
            if (yh9Var != null) {
                this.a.f0(yh9Var.O());
            }
            this.a.a().F(true);
            this.a.a().setOnCancelClickListener(this.i);
            this.a.B(this.b);
            e();
            this.a.T(this.g);
        }
    }

    public void k(int i, int i2, Intent intent) {
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && (hk5Var = this.a) != null) {
            hk5Var.E(i, i2, intent);
        }
    }

    public void t(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            hk5 hk5Var = this.a;
            if (hk5Var == null) {
                i(str3, z);
            } else {
                hk5Var.d0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.B(this.b);
                }
            }
            this.a.Z(str);
            this.a.Y(str2, "");
            SafeHandler.getInst().postDelayed(this.k, 200L);
            this.a.q(this.f);
            if (this.a.z()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.w(null);
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
