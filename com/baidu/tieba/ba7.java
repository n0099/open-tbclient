package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ba7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638321, "Lcom/baidu/tieba/ba7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638321, "Lcom/baidu/tieba/ba7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(d77 d77Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, d77Var) == null) && d77Var != null) {
                d77Var.a().a(d77Var.b());
                String c = d77Var.c();
                if (c != null && c.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(d77Var.c());
                for (Map.Entry<String, String> entry : d77Var.b().entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
                for (Map.Entry<String, String> entry2 : d77Var.d().entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
                TiebaStatic.log(statisticItem);
            }
        }

        public final void b(d77 statData, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, statData, i) == null) {
                Intrinsics.checkNotNullParameter(statData, "statData");
                if (statData.e().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (statData.b() instanceof HashMap)) {
                    ((HashMap) statData.b()).put(statData.e(), String.valueOf(i));
                }
            }
        }
    }
}
