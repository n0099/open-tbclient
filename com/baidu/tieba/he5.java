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
public class he5 {
    public static /* synthetic */ Interceptable $ic;
    public static he5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947820849, "Lcom/baidu/tieba/he5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947820849, "Lcom/baidu/tieba/he5;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends ee5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ee5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ee5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(he5 he5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he5Var};
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
    public class b extends ee5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he5 b;

        @Override // com.baidu.tieba.ee5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(he5 he5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = he5Var;
        }

        @Override // com.baidu.tieba.ee5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public he5() {
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

    public static he5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (he5.class) {
                    if (d == null) {
                        d = new he5();
                    }
                }
            }
            return d;
        }
        return (he5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return qy4.k().l("page_stay_max_cost", 0);
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
            qy4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, ge5 ge5Var, ee5 ee5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, ge5Var, ee5Var) == null) && ge5Var != null && !StringUtils.isNull(ge5Var.c())) {
            if (ge5Var.a) {
                if (ee5Var == null) {
                    ee5Var = new a(this);
                }
                if (!ee5Var.a(ge5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", fe5.a(ge5Var.h()));
                statisticItem.param("obj_locate", ge5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(ge5Var.i)) {
                    statisticItem.param("obj_id", ge5Var.i);
                }
                if (ge5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ge5Var.b());
                }
                zd5.b(context, statisticItem, ge5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (ee5Var == null) {
                ee5Var = new b(this);
            }
            if (!ee5Var.d() || !ee5Var.a(ge5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", fe5.a(ge5Var.h()));
            statisticItem2.param("obj_type", ge5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ge5Var.i()));
            if (!StringUtils.isNull(ge5Var.n())) {
                statisticItem2.param("topic_id", ge5Var.n());
            }
            if (!StringUtils.isNull(ge5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, ge5Var.o());
            }
            if (ge5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(ge5Var.d()));
            }
            if (ge5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(ge5Var.m()));
            }
            if (ge5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(ge5Var.l()));
            }
            if (!StringUtils.isNull(ge5Var.e())) {
                statisticItem2.param("nid", ge5Var.e());
            }
            if (ge5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(ge5Var.g()));
            }
            if (!StringUtils.isNull(ge5Var.k)) {
                statisticItem2.param("obj_param1", ge5Var.k);
            }
            if (!StringUtils.isNull(ge5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, ge5Var.l);
            }
            if (!StringUtils.isNull(ge5Var.r)) {
                statisticItem2.param("is_dynamic", ge5Var.r);
            }
            if (!StringUtils.isNull(ge5Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, ge5Var.s);
            }
            if (!StringUtils.isNull(ge5Var.t)) {
                statisticItem2.param("resource_type", ge5Var.t);
            }
            if (!xi.isEmpty(ge5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(ge5Var.j()));
            }
            if (!xi.isEmpty(ge5Var.a())) {
                statisticItem2.param("ab_tag", ge5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(ge5Var.i)) {
                    statisticItem2.param("obj_id", ge5Var.i);
                }
                if (!StringUtils.isNull(ge5Var.j)) {
                    statisticItem2.param("obj_name", ge5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(ge5Var.f())) {
                statisticItem2.param("obj_location", ge5Var.f());
            }
            if (ge5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ge5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && ge5Var.h() != null && d(ge5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(ge5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            zd5.b(context, statisticItem2, ge5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ge5Var.i())).param("obj_source", fe5.a(ge5Var.h())).param("obj_locate", ge5Var.c()).param("obj_param1", jx4.a().b()));
        }
    }
}
