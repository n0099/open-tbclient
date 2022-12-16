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
/* loaded from: classes3.dex */
public abstract class bc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(dd4 dd4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(dd4 dd4Var, List<ed4> list, bd4 bd4Var, zc4 zc4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends cd4> boolean e(Class<T> cls, String str);

    public abstract boolean f(fd4 fd4Var);

    public abstract boolean g(List<fd4> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<ed4> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends cd4> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends cd4> T o(Class<T> cls, String str);

    public abstract Map<String, dd4> p();

    public abstract fd4 q(String str, long j, long j2);

    public abstract List<fd4> r(String str, String[] strArr);

    public abstract List<fd4> s(String str, long j, long j2);

    @Nullable
    public abstract gd4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<fd4> w(String str);

    public abstract boolean x(fd4 fd4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public bc4() {
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

    public static bc4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (bc4.class) {
                    if (a == null) {
                        a = new cc4();
                    }
                }
            }
            return a;
        }
        return (bc4) invokeV.objValue;
    }
}
