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
/* loaded from: classes5.dex */
public class bs5 {
    public static /* synthetic */ Interceptable $ic;
    public static bs5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947655557, "Lcom/baidu/tieba/bs5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947655557, "Lcom/baidu/tieba/bs5;");
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
                return 6;
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

        public a(bs5 bs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs5Var};
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

    /* loaded from: classes5.dex */
    public class b extends yr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bs5 b;

        @Override // com.baidu.tieba.yr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(bs5 bs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bs5Var;
        }

        @Override // com.baidu.tieba.yr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public bs5() {
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

    public static bs5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (bs5.class) {
                    if (d == null) {
                        d = new bs5();
                    }
                }
            }
            return d;
        }
        return (bs5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return o95.p().q("page_stay_max_cost", 0);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list) || (size = list.size()) < 2 || !"a026".equals(list.get(size - 2))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            o95.p().F("page_stay_max_cost", this.b);
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

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!"a026".equals(list.get(list.size() - 1)) && !e(list)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k(Context context, as5 as5Var, yr5 yr5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, as5Var, yr5Var) == null) && as5Var != null && !StringUtils.isNull(as5Var.c())) {
            if (as5Var.a) {
                if (yr5Var == null) {
                    yr5Var = new a(this);
                }
                if (!yr5Var.a(as5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", zr5.a(as5Var.h()));
                statisticItem.param("obj_locate", as5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(as5Var.i)) {
                    statisticItem.param("obj_id", as5Var.i);
                }
                if (as5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, as5Var.b());
                }
                tr5.b(context, statisticItem, as5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (yr5Var == null) {
                yr5Var = new b(this);
            }
            if (!yr5Var.d() || !yr5Var.a(as5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", zr5.a(as5Var.h()));
            statisticItem2.param("obj_type", as5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(as5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(as5Var.n())) {
                statisticItem2.param("topic_id", as5Var.n());
            }
            if (!StringUtils.isNull(as5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, as5Var.o());
            }
            if (as5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(as5Var.d()));
            }
            if (as5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(as5Var.m()));
            }
            if (as5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(as5Var.l()));
            }
            if (!StringUtils.isNull(as5Var.e())) {
                statisticItem2.param("nid", as5Var.e());
            }
            if (as5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(as5Var.g()));
            }
            if (!StringUtils.isNull(as5Var.k)) {
                statisticItem2.param("obj_param1", as5Var.k);
            }
            if (!StringUtils.isNull(as5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, as5Var.l);
            }
            if (!StringUtils.isNull(as5Var.r)) {
                statisticItem2.param("is_dynamic", as5Var.r);
            }
            if (!StringUtils.isNull(as5Var.s)) {
                statisticItem2.param("resource_id", as5Var.s);
            }
            if (!StringUtils.isNull(as5Var.t)) {
                statisticItem2.param("resource_type", as5Var.t);
            }
            if (!vi.isEmpty(as5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(as5Var.j()));
            }
            if (!vi.isEmpty(as5Var.a())) {
                statisticItem2.param("ab_tag", as5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(as5Var.i)) {
                    statisticItem2.param("obj_id", as5Var.i);
                }
                if (!StringUtils.isNull(as5Var.j)) {
                    statisticItem2.param("obj_name", as5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(as5Var.f())) {
                statisticItem2.param("obj_location", as5Var.f());
            }
            if (as5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, as5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && as5Var.h() != null && d(as5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(as5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            tr5.b(context, statisticItem2, as5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(as5Var.i())).param("obj_source", zr5.a(as5Var.h())).param("obj_locate", as5Var.c()).param("obj_param1", h85.a().b()));
        }
    }
}
