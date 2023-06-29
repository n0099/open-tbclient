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
/* loaded from: classes6.dex */
public class gs5 {
    public static /* synthetic */ Interceptable $ic;
    public static gs5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947804512, "Lcom/baidu/tieba/gs5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947804512, "Lcom/baidu/tieba/gs5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ds5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ds5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ds5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(gs5 gs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs5Var};
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

    /* loaded from: classes6.dex */
    public class b extends ds5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs5 b;

        @Override // com.baidu.tieba.ds5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(gs5 gs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gs5Var;
        }

        @Override // com.baidu.tieba.ds5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public gs5() {
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

    public static gs5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (gs5.class) {
                    if (d == null) {
                        d = new gs5();
                    }
                }
            }
            return d;
        }
        return (gs5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return r95.p().q("page_stay_max_cost", 0);
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
            r95.p().F("page_stay_max_cost", this.b);
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

    public void k(Context context, fs5 fs5Var, ds5 ds5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, fs5Var, ds5Var) == null) && fs5Var != null && !StringUtils.isNull(fs5Var.c())) {
            if (fs5Var.a) {
                if (ds5Var == null) {
                    ds5Var = new a(this);
                }
                if (!ds5Var.a(fs5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", es5.a(fs5Var.h()));
                statisticItem.param("obj_locate", fs5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(fs5Var.i)) {
                    statisticItem.param("obj_id", fs5Var.i);
                }
                if (fs5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, fs5Var.b());
                }
                yr5.b(context, statisticItem, fs5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (ds5Var == null) {
                ds5Var = new b(this);
            }
            if (!ds5Var.d() || !ds5Var.a(fs5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", es5.a(fs5Var.h()));
            statisticItem2.param("obj_type", fs5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(fs5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(fs5Var.n())) {
                statisticItem2.param("topic_id", fs5Var.n());
            }
            if (!StringUtils.isNull(fs5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, fs5Var.o());
            }
            if (fs5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(fs5Var.d()));
            }
            if (fs5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(fs5Var.m()));
            }
            if (fs5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(fs5Var.l()));
            }
            if (!StringUtils.isNull(fs5Var.e())) {
                statisticItem2.param("nid", fs5Var.e());
            }
            if (fs5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(fs5Var.g()));
            }
            if (!StringUtils.isNull(fs5Var.k)) {
                statisticItem2.param("obj_param1", fs5Var.k);
            }
            if (!StringUtils.isNull(fs5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, fs5Var.l);
            }
            if (!StringUtils.isNull(fs5Var.r)) {
                statisticItem2.param("is_dynamic", fs5Var.r);
            }
            if (!StringUtils.isNull(fs5Var.s)) {
                statisticItem2.param("resource_id", fs5Var.s);
            }
            if (!StringUtils.isNull(fs5Var.t)) {
                statisticItem2.param("resource_type", fs5Var.t);
            }
            if (!wi.isEmpty(fs5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(fs5Var.j()));
            }
            if (!wi.isEmpty(fs5Var.a())) {
                statisticItem2.param("ab_tag", fs5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(fs5Var.i)) {
                    statisticItem2.param("obj_id", fs5Var.i);
                }
                if (!StringUtils.isNull(fs5Var.j)) {
                    statisticItem2.param("obj_name", fs5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(fs5Var.f())) {
                statisticItem2.param("obj_location", fs5Var.f());
            }
            if (fs5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, fs5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && fs5Var.h() != null && d(fs5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(fs5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            yr5.b(context, statisticItem2, fs5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(fs5Var.i())).param("obj_source", es5.a(fs5Var.h())).param("obj_locate", fs5Var.c()).param("obj_param1", k85.a().b()));
        }
    }
}
