package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f79 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f79 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public boolean c;
    public int d;
    public int e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947717185, "Lcom/baidu/tieba/f79;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947717185, "Lcom/baidu/tieba/f79;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends yr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.yr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.yr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(f79 f79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public f79() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.c = false;
        this.d = 0;
        this.d = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.e = wi.j(TbadkCoreApplication.getInst());
    }

    public static f79 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (f79.class) {
                    if (f == null) {
                        f = new f79();
                    }
                }
            }
            return f;
        }
        return (f79) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f = null;
            this.a = 0L;
            this.c = false;
            this.b = 0L;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a == 0) {
            this.a = System.currentTimeMillis();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.b == 0) {
            this.b = System.currentTimeMillis();
        }
    }

    public final boolean b(View view2, ListView listView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, listView)) == null) {
            if (view2 != null) {
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                if (iArr[1] > 0 && iArr[1] < this.e - this.d) {
                    return true;
                }
            }
            if (listView == null || listView.getChildCount() <= 2) {
                return false;
            }
            View childAt = listView.getChildAt(listView.getChildCount() - 3);
            if (!(childAt instanceof ViewGroup)) {
                return false;
            }
            return ((ViewGroup) childAt).getChildAt(0) instanceof ThreadCardView;
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3)) == null) {
            if (view2 == null || view3 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (view3.getVisibility() == 0) {
                return true;
            }
            if (i <= 0 || i >= this.e - this.d) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void e(Context context, as5 as5Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, context, as5Var, str) != null) || as5Var == null || StringUtils.isNull(as5Var.c()) || !new a(this).a(as5Var)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", zr5.a(as5Var.h()));
        statisticItem.param("obj_type", as5Var.c());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(as5Var.i()));
        if (as5Var.d() > 0) {
            statisticItem.param("fid", String.valueOf(as5Var.d()));
        }
        if (as5Var.m() > 0) {
            statisticItem.param("tid", String.valueOf(as5Var.m()));
        }
        if (!StringUtils.isNull(as5Var.e())) {
            statisticItem.param("nid", as5Var.e());
        }
        if (as5Var.g() > 0) {
            statisticItem.param("pid", String.valueOf(as5Var.g()));
        }
        if (!StringUtils.isNull(as5Var.k)) {
            statisticItem.param("obj_param1", as5Var.k);
        }
        if (!StringUtils.isNull(as5Var.l)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, as5Var.l);
        }
        if (!StringUtils.isNull(as5Var.r)) {
            statisticItem.param("is_dynamic", as5Var.r);
        }
        if (!StringUtils.isNull(as5Var.s)) {
            statisticItem.param("resource_id", as5Var.s);
        }
        if (!vi.isEmpty(as5Var.j())) {
            statisticItem.param("task_id", String.valueOf(as5Var.j()));
        }
        if (!vi.isEmpty(as5Var.a())) {
            statisticItem.param("ab_tag", as5Var.a());
        }
        if (!StringUtils.isNull(as5Var.f())) {
            statisticItem.param("obj_location", as5Var.f());
        }
        tr5.b(context, statisticItem, as5Var);
        TiebaStatic.log(statisticItem);
    }

    public void f(boolean z, View view2, View view3, as5 as5Var, boolean z2, View view4, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), view2, view3, as5Var, Boolean.valueOf(z2), view4, listView}) == null) {
            if (this.c) {
                z = false;
            } else {
                this.c = z;
            }
            if (!c(view2, view3) && (!z || z2)) {
                if (z2) {
                    j(as5Var);
                }
            } else {
                g();
            }
            if (b(view4, listView)) {
                h();
            } else {
                k(as5Var);
            }
        }
    }

    public void i(AbsPbActivity absPbActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, absPbActivity) == null) && absPbActivity != null) {
            j(absPbActivity.getPageStayDurationItem());
            k(absPbActivity.getPageStayDurationItem());
        }
    }

    public final void j(as5 as5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, as5Var) == null) && this.a > 0) {
            this.a = 0L;
            as5Var.y(System.currentTimeMillis() - this.a);
            e(TbadkCoreApplication.getInst(), as5Var, "c14085");
        }
    }

    public final void k(as5 as5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, as5Var) == null) && this.b > 0) {
            this.b = 0L;
            as5Var.y(System.currentTimeMillis() - this.b);
            e(TbadkCoreApplication.getInst(), as5Var, "rec_stime");
        }
    }
}
