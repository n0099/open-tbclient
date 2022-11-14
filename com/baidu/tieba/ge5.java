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
/* loaded from: classes4.dex */
public class ge5 {
    public static /* synthetic */ Interceptable $ic;
    public static ge5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947791058, "Lcom/baidu/tieba/ge5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947791058, "Lcom/baidu/tieba/ge5;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends de5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.de5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.de5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(ge5 ge5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge5Var};
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

    /* loaded from: classes4.dex */
    public class b extends de5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge5 b;

        @Override // com.baidu.tieba.de5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(ge5 ge5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ge5Var;
        }

        @Override // com.baidu.tieba.de5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public ge5() {
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

    public static ge5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ge5.class) {
                    if (d == null) {
                        d = new ge5();
                    }
                }
            }
            return d;
        }
        return (ge5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return py4.k().l("page_stay_max_cost", 0);
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
            py4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, fe5 fe5Var, de5 de5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, fe5Var, de5Var) == null) && fe5Var != null && !StringUtils.isNull(fe5Var.c())) {
            if (fe5Var.a) {
                if (de5Var == null) {
                    de5Var = new a(this);
                }
                if (!de5Var.a(fe5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", ee5.a(fe5Var.h()));
                statisticItem.param("obj_locate", fe5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(fe5Var.i)) {
                    statisticItem.param("obj_id", fe5Var.i);
                }
                if (fe5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, fe5Var.b());
                }
                yd5.b(context, statisticItem, fe5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (de5Var == null) {
                de5Var = new b(this);
            }
            if (!de5Var.d() || !de5Var.a(fe5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", ee5.a(fe5Var.h()));
            statisticItem2.param("obj_type", fe5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(fe5Var.i()));
            if (!StringUtils.isNull(fe5Var.n())) {
                statisticItem2.param("topic_id", fe5Var.n());
            }
            if (!StringUtils.isNull(fe5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, fe5Var.o());
            }
            if (fe5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(fe5Var.d()));
            }
            if (fe5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(fe5Var.m()));
            }
            if (fe5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(fe5Var.l()));
            }
            if (!StringUtils.isNull(fe5Var.e())) {
                statisticItem2.param("nid", fe5Var.e());
            }
            if (fe5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(fe5Var.g()));
            }
            if (!StringUtils.isNull(fe5Var.k)) {
                statisticItem2.param("obj_param1", fe5Var.k);
            }
            if (!StringUtils.isNull(fe5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, fe5Var.l);
            }
            if (!StringUtils.isNull(fe5Var.r)) {
                statisticItem2.param("is_dynamic", fe5Var.r);
            }
            if (!StringUtils.isNull(fe5Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, fe5Var.s);
            }
            if (!StringUtils.isNull(fe5Var.t)) {
                statisticItem2.param("resource_type", fe5Var.t);
            }
            if (!xi.isEmpty(fe5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(fe5Var.j()));
            }
            if (!xi.isEmpty(fe5Var.a())) {
                statisticItem2.param("ab_tag", fe5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(fe5Var.i)) {
                    statisticItem2.param("obj_id", fe5Var.i);
                }
                if (!StringUtils.isNull(fe5Var.j)) {
                    statisticItem2.param("obj_name", fe5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(fe5Var.f())) {
                statisticItem2.param("obj_location", fe5Var.f());
            }
            if (fe5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, fe5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && fe5Var.h() != null && d(fe5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(fe5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            yd5.b(context, statisticItem2, fe5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(fe5Var.i())).param("obj_source", ee5.a(fe5Var.h())).param("obj_locate", fe5Var.c()).param("obj_param1", ix4.a().b()));
        }
    }
}
