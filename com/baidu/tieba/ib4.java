package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class ib4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ib4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ib4() {
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

    public static ib4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ib4.class) {
                    if (a == null) {
                        a = new jb4();
                    }
                }
            }
            return a;
        }
        return (ib4) invokeV.objValue;
    }

    public abstract boolean a(kc4 kc4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(kc4 kc4Var, List<lc4> list, ic4 ic4Var, gc4 gc4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends jc4> boolean e(Class<T> cls, String str);

    public abstract boolean f(mc4 mc4Var);

    public abstract boolean g(List<mc4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<lc4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends jc4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends jc4> T o(Class<T> cls, String str);

    public abstract Map<String, kc4> p();

    public abstract mc4 q(String str, long j, long j2);

    public abstract List<mc4> r(String str, String[] strArr);

    public abstract List<mc4> s(String str, long j, long j2);

    @Nullable
    public abstract nc4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<mc4> w(String str);

    public abstract boolean x(mc4 mc4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
