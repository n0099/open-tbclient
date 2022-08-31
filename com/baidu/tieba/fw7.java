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
/* loaded from: classes4.dex */
public class fw7 {
    public static /* synthetic */ Interceptable $ic;
    public static fw7 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public boolean c;
    public int d;
    public int e;

    /* loaded from: classes4.dex */
    public class a extends aa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.aa5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.aa5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947778627, "Lcom/baidu/tieba/fw7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947778627, "Lcom/baidu/tieba/fw7;");
        }
    }

    public fw7() {
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
        this.d = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.e = ri.i(TbadkCoreApplication.getInst());
    }

    public static fw7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (fw7.class) {
                    if (f == null) {
                        f = new fw7();
                    }
                }
            }
            return f;
        }
        return (fw7) invokeV.objValue;
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
            if (listView != null && listView.getChildCount() > 2) {
                View childAt = listView.getChildAt(listView.getChildCount() - 3);
                if ((childAt instanceof ViewGroup) && (((ViewGroup) childAt).getChildAt(0) instanceof ThreadCardView)) {
                    return true;
                }
            }
            return false;
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
            if (view3.getVisibility() != 0) {
                return i > 0 && i < this.e - this.d;
            }
            return true;
        }
        return invokeLL.booleanValue;
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

    public final void e(Context context, ca5 ca5Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, ca5Var, str) == null) || ca5Var == null || StringUtils.isNull(ca5Var.c()) || !new a(this).a(ca5Var)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", ba5.a(ca5Var.h()));
        statisticItem.param("obj_type", ca5Var.c());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ca5Var.i()));
        if (ca5Var.d() > 0) {
            statisticItem.param("fid", String.valueOf(ca5Var.d()));
        }
        if (ca5Var.m() > 0) {
            statisticItem.param("tid", String.valueOf(ca5Var.m()));
        }
        if (!StringUtils.isNull(ca5Var.e())) {
            statisticItem.param("nid", ca5Var.e());
        }
        if (ca5Var.g() > 0) {
            statisticItem.param("pid", String.valueOf(ca5Var.g()));
        }
        if (!StringUtils.isNull(ca5Var.k)) {
            statisticItem.param("obj_param1", ca5Var.k);
        }
        if (!StringUtils.isNull(ca5Var.l)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, ca5Var.l);
        }
        if (!StringUtils.isNull(ca5Var.r)) {
            statisticItem.param("is_dynamic", ca5Var.r);
        }
        if (!StringUtils.isNull(ca5Var.s)) {
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, ca5Var.s);
        }
        if (!qi.isEmpty(ca5Var.j())) {
            statisticItem.param("task_id", String.valueOf(ca5Var.j()));
        }
        if (!qi.isEmpty(ca5Var.a())) {
            statisticItem.param("ab_tag", ca5Var.a());
        }
        if (!StringUtils.isNull(ca5Var.f())) {
            statisticItem.param("obj_location", ca5Var.f());
        }
        v95.b(context, statisticItem, ca5Var);
        TiebaStatic.log(statisticItem);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
        }
    }

    public void g(boolean z, View view2, View view3, ca5 ca5Var, boolean z2, View view4, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), view2, view3, ca5Var, Boolean.valueOf(z2), view4, listView}) == null) {
            if (this.c) {
                z = false;
            } else {
                this.c = z;
            }
            if (c(view2, view3) || (z && !z2)) {
                h();
            } else if (z2) {
                k(ca5Var);
            }
            if (b(view4, listView)) {
                i();
            } else {
                l(ca5Var);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a == 0) {
            this.a = System.currentTimeMillis();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b == 0) {
            this.b = System.currentTimeMillis();
        }
    }

    public void j(AbsPbActivity absPbActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, absPbActivity) == null) || absPbActivity == null) {
            return;
        }
        k(absPbActivity.getPageStayDurationItem());
        l(absPbActivity.getPageStayDurationItem());
    }

    public final void k(ca5 ca5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ca5Var) == null) || this.a <= 0) {
            return;
        }
        this.a = 0L;
        ca5Var.y(System.currentTimeMillis() - this.a);
        e(TbadkCoreApplication.getInst(), ca5Var, "c14085");
    }

    public final void l(ca5 ca5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ca5Var) == null) || this.b <= 0) {
            return;
        }
        this.b = 0L;
        ca5Var.y(System.currentTimeMillis() - this.b);
        e(TbadkCoreApplication.getInst(), ca5Var, "rec_stime");
    }
}
