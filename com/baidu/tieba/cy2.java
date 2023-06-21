package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ey2;
import com.baidu.tieba.fy2;
import com.baidu.tieba.gy2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class cy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ey2> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947691021, "Lcom/baidu/tieba/cy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947691021, "Lcom/baidu/tieba/cy2;");
                return;
            }
        }
        b = js1.a;
    }

    public cy2() {
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
        this.a = new ArrayList();
        e();
    }

    @NonNull
    public List<ey2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Collections.unmodifiableList(this.a);
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && d()) {
            z82.c("SwanLocalABTestAutoRegister", "test 'first install updateCore delay' register failed'");
        }
    }

    @Nullable
    public final fy2 a(@NonNull String str, int i, int i2, @NonNull String str2, @NonNull Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, obj})) == null) {
            fy2.a aVar = new fy2.a();
            aVar.e(str);
            aVar.g(i);
            aVar.c(i2);
            aVar.b(str2);
            aVar.f(obj);
            fy2 a = aVar.a();
            if (a == null) {
                if (b) {
                    Log.e("SwanLocalABTestAutoRegister", "build branch(" + str + ") fail: " + aVar.d().getMessage());
                    return null;
                }
                return null;
            }
            return a;
        }
        return (fy2) invokeCommon.objValue;
    }

    @Nullable
    public final gy2 b(int i, @NonNull String str, @NonNull Object obj) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj)) == null) {
            gy2.a aVar = new gy2.a();
            aVar.e(i);
            aVar.d(str);
            aVar.b(obj);
            gy2 a = aVar.a();
            if (a == null) {
                if (b) {
                    Log.e("SwanLocalABTestAutoRegister", "build switch(" + str + ") fail: " + aVar.c().getMessage());
                }
                return null;
            }
            return a;
        }
        return (gy2) invokeILL.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            gy2 b2 = b(3, "swan_local_first_installation_update_core_delay", 0L);
            if (b2 == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("local_1000", 0, 20, "control group", 0L));
            arrayList.add(a("local_1001", 1, 20, "test group 1", 100L));
            arrayList.add(a("local_1002", 1, 20, "test group 2", 500L));
            arrayList.add(a("local_1003", 1, 20, "test group 3", 1000L));
            arrayList.add(a("local_1004", 1, 20, "test group 4", 2000L));
            ey2.a aVar = new ey2.a();
            aVar.c(b2);
            aVar.a(arrayList);
            ey2 b3 = aVar.b();
            if (b3 == null) {
                return false;
            }
            return this.a.add(b3);
        }
        return invokeV.booleanValue;
    }
}
