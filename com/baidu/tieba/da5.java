package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class da5 {
    public static /* synthetic */ Interceptable $ic;
    public static da5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes3.dex */
    public class a extends aa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(da5 da5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da5Var};
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
                return 6;
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

    /* loaded from: classes3.dex */
    public class b extends aa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da5 b;

        public b(da5 da5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = da5Var;
        }

        @Override // com.baidu.tieba.aa5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947697841, "Lcom/baidu/tieba/da5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947697841, "Lcom/baidu/tieba/da5;");
        }
    }

    public da5() {
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
        this.a = false;
        this.c = false;
    }

    public static da5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (da5.class) {
                    if (d == null) {
                        d = new da5();
                    }
                }
            }
            return d;
        }
        return (da5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return su4.k().l("page_stay_max_cost", 0);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            return "a026".equals(list.get(list.size() - 1)) || e(list);
        }
        return invokeL.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) ? !ListUtils.isEmpty(list) && (size = list.size()) >= 2 && "a026".equals(list.get(size - 2)) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            su4.k().w("page_stay_max_cost", this.b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public void k(Context context, ca5 ca5Var, aa5 aa5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, ca5Var, aa5Var) == null) || ca5Var == null || StringUtils.isNull(ca5Var.c())) {
            return;
        }
        if (ca5Var.a) {
            if (aa5Var == null) {
                aa5Var = new a(this);
            }
            if (aa5Var.a(ca5Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", ba5.a(ca5Var.h()));
                statisticItem.param("obj_locate", ca5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(ca5Var.i)) {
                    statisticItem.param("obj_id", ca5Var.i);
                }
                if (ca5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ca5Var.b());
                }
                v95.b(context, statisticItem, ca5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (aa5Var == null) {
            aa5Var = new b(this);
        }
        if (aa5Var.d() && aa5Var.a(ca5Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", ba5.a(ca5Var.h()));
            statisticItem2.param("obj_type", ca5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ca5Var.i()));
            if (!StringUtils.isNull(ca5Var.n())) {
                statisticItem2.param("topic_id", ca5Var.n());
            }
            if (!StringUtils.isNull(ca5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, ca5Var.o());
            }
            if (ca5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(ca5Var.d()));
            }
            if (ca5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(ca5Var.m()));
            }
            if (ca5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(ca5Var.l()));
            }
            if (!StringUtils.isNull(ca5Var.e())) {
                statisticItem2.param("nid", ca5Var.e());
            }
            if (ca5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(ca5Var.g()));
            }
            if (!StringUtils.isNull(ca5Var.k)) {
                statisticItem2.param("obj_param1", ca5Var.k);
            }
            if (!StringUtils.isNull(ca5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, ca5Var.l);
            }
            if (!StringUtils.isNull(ca5Var.r)) {
                statisticItem2.param("is_dynamic", ca5Var.r);
            }
            if (!StringUtils.isNull(ca5Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, ca5Var.s);
            }
            if (!StringUtils.isNull(ca5Var.t)) {
                statisticItem2.param("resource_type", ca5Var.t);
            }
            if (!qi.isEmpty(ca5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(ca5Var.j()));
            }
            if (!qi.isEmpty(ca5Var.a())) {
                statisticItem2.param("ab_tag", ca5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(ca5Var.i)) {
                    statisticItem2.param("obj_id", ca5Var.i);
                }
                if (!StringUtils.isNull(ca5Var.j)) {
                    statisticItem2.param("obj_name", ca5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(ca5Var.f())) {
                statisticItem2.param("obj_location", ca5Var.f());
            }
            if (ca5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ca5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && ca5Var.h() != null && d(ca5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(ca5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            v95.b(context, statisticItem2, ca5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ca5Var.i())).param("obj_source", ba5.a(ca5Var.h())).param("obj_locate", ca5Var.c()).param("obj_param1", ft4.a().b()));
        }
    }
}
