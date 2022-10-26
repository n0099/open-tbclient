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
public class dd5 {
    public static /* synthetic */ Interceptable $ic;
    public static dd5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947700724, "Lcom/baidu/tieba/dd5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947700724, "Lcom/baidu/tieba/dd5;");
        }
    }

    /* loaded from: classes3.dex */
    public class a extends ad5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ad5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ad5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(dd5 dd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd5Var};
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

    /* loaded from: classes3.dex */
    public class b extends ad5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd5 b;

        @Override // com.baidu.tieba.ad5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(dd5 dd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dd5Var;
        }

        @Override // com.baidu.tieba.ad5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public dd5() {
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

    public static dd5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (dd5.class) {
                    if (d == null) {
                        d = new dd5();
                    }
                }
            }
            return d;
        }
        return (dd5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ux4.k().l("page_stay_max_cost", 0);
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

    public final boolean e(List list) {
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
            ux4.k().w("page_stay_max_cost", this.b);
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

    public final boolean d(List list) {
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

    public void k(Context context, cd5 cd5Var, ad5 ad5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, cd5Var, ad5Var) == null) && cd5Var != null && !StringUtils.isNull(cd5Var.c())) {
            if (cd5Var.a) {
                if (ad5Var == null) {
                    ad5Var = new a(this);
                }
                if (!ad5Var.a(cd5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", bd5.a(cd5Var.h()));
                statisticItem.param("obj_locate", cd5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(cd5Var.i)) {
                    statisticItem.param("obj_id", cd5Var.i);
                }
                if (cd5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, cd5Var.b());
                }
                vc5.b(context, statisticItem, cd5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (ad5Var == null) {
                ad5Var = new b(this);
            }
            if (!ad5Var.d() || !ad5Var.a(cd5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", bd5.a(cd5Var.h()));
            statisticItem2.param("obj_type", cd5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(cd5Var.i()));
            if (!StringUtils.isNull(cd5Var.n())) {
                statisticItem2.param("topic_id", cd5Var.n());
            }
            if (!StringUtils.isNull(cd5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, cd5Var.o());
            }
            if (cd5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(cd5Var.d()));
            }
            if (cd5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(cd5Var.m()));
            }
            if (cd5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(cd5Var.l()));
            }
            if (!StringUtils.isNull(cd5Var.e())) {
                statisticItem2.param("nid", cd5Var.e());
            }
            if (cd5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(cd5Var.g()));
            }
            if (!StringUtils.isNull(cd5Var.k)) {
                statisticItem2.param("obj_param1", cd5Var.k);
            }
            if (!StringUtils.isNull(cd5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, cd5Var.l);
            }
            if (!StringUtils.isNull(cd5Var.r)) {
                statisticItem2.param("is_dynamic", cd5Var.r);
            }
            if (!StringUtils.isNull(cd5Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, cd5Var.s);
            }
            if (!StringUtils.isNull(cd5Var.t)) {
                statisticItem2.param("resource_type", cd5Var.t);
            }
            if (!ej.isEmpty(cd5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(cd5Var.j()));
            }
            if (!ej.isEmpty(cd5Var.a())) {
                statisticItem2.param("ab_tag", cd5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(cd5Var.i)) {
                    statisticItem2.param("obj_id", cd5Var.i);
                }
                if (!StringUtils.isNull(cd5Var.j)) {
                    statisticItem2.param("obj_name", cd5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(cd5Var.f())) {
                statisticItem2.param("obj_location", cd5Var.f());
            }
            if (cd5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, cd5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && cd5Var.h() != null && d(cd5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(cd5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            vc5.b(context, statisticItem2, cd5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(cd5Var.i())).param("obj_source", bd5.a(cd5Var.h())).param("obj_locate", cd5Var.c()).param("obj_param1", gw4.a().b()));
        }
    }
}
