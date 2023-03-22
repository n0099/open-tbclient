package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ha2 implements w92<v92> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;
    public volatile w92<v92> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947816912, "Lcom/baidu/tieba/ha2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947816912, "Lcom/baidu/tieba/ha2;");
                return;
            }
        }
        c = do1.a;
    }

    public ha2() {
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
        this.a = null;
    }

    @Override // com.baidu.tieba.x92
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return l().f();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x92
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return l().g();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x92
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return l().h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w92
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return l().i();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x92
    /* renamed from: k */
    public v92 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (v92) l().a();
        }
        return (v92) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x92
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l().reset();
            synchronized (this) {
                this.a = null;
                this.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.w92
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            l().b(str, cVar, pMSAppInfo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.y92<com.baidu.tieba.v92> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.x92
    public void c(y92<v92> y92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y92Var) == null) {
            l().c(y92Var);
        }
    }

    @Override // com.baidu.tieba.w92
    public void d(th2 th2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th2Var) == null) {
            l().d(th2Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x92
    /* renamed from: n */
    public v92 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) {
            return (v92) l().e(pMSAppInfo);
        }
        return (v92) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w92
    public void j(boolean z, ea2 ea2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, ea2Var) == null) {
            l().j(z, ea2Var);
        }
    }

    public final w92<v92> l() {
        InterceptResult invokeV;
        w92<v92> ga2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        if (m()) {
                            ga2Var = new la2();
                        } else {
                            ga2Var = new ga2();
                        }
                        this.b = ga2Var;
                        if (c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.b;
        }
        return (w92) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                if (tb2.l() > 0 && tb2.i()) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = Boolean.valueOf(z);
            }
            if (c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + ne2.U().d0());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.a);
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }
}
