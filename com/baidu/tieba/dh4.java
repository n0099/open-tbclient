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
/* loaded from: classes5.dex */
public abstract class dh4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dh4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(fi4 fi4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(fi4 fi4Var, List<gi4> list, di4 di4Var, bi4 bi4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends ei4> boolean e(Class<T> cls, String str);

    public abstract boolean f(hi4 hi4Var);

    public abstract boolean g(List<hi4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<gi4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends ei4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends ei4> T o(Class<T> cls, String str);

    public abstract Map<String, fi4> p();

    public abstract hi4 q(String str, long j, long j2);

    public abstract List<hi4> r(String str, String[] strArr);

    public abstract List<hi4> s(String str, long j, long j2);

    @Nullable
    public abstract ii4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<hi4> w(String str);

    public abstract boolean x(hi4 hi4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public dh4() {
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

    public static dh4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (dh4.class) {
                    if (a == null) {
                        a = new eh4();
                    }
                }
            }
            return a;
        }
        return (dh4) invokeV.objValue;
    }
}
