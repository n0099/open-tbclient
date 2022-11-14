package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class h62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public b62 a;
    public final List<q62> b;
    public volatile PMSAppInfo c;
    public volatile PrefetchEvent.c d;
    public volatile p62 e;
    public final boolean f;
    public volatile boolean g;
    public long h;
    public long i;
    public final boolean j;

    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, pMSAppInfo)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends t22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h62 a;

        public a(h62 h62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h62Var;
        }

        @Override // com.baidu.tieba.t22
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (h62.k) {
                    Log.d("BasePreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                this.a.g = true;
                this.a.i = System.currentTimeMillis();
                this.a.o();
                if (h62.k) {
                    Log.d("BasePreloadMasterManager", "createBlankOne cost - " + this.a.f() + "ms");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ PrefetchEvent.c c;
        public final /* synthetic */ h62 d;

        public b(h62 h62Var, String str, PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h62Var, str, pMSAppInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h62Var;
            this.a = str;
            this.b = pMSAppInfo;
            this.c = cVar;
        }

        @Override // com.baidu.tieba.q62
        public void onReady() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b62 i = this.d.i();
                if (i != null && i.f() != null && !i.f().isDestroyed()) {
                    this.d.q(this.a, this.b);
                    be2.a(i.f(), this.c);
                    f12.i(PrefetchEvent.MODULE, "prefetch master finish");
                    z = true;
                } else {
                    z = false;
                }
                i92 d = i92.d();
                d.b(this.a, new UbcFlowEvent("prefetch_end"));
                d.e(this.a, z, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775589, "Lcom/baidu/tieba/h62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775589, "Lcom/baidu/tieba/h62;");
                return;
            }
        }
        k = pk1.a;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i - this.h;
        }
        return invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c != null) {
                return this.c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public b62 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (b62) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public h62(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.j = z2;
        this.f = z;
        if (!z) {
            o62.b().c(this);
        }
        e();
    }

    public boolean m(PrefetchEvent.c cVar, PrefetchEvent.c cVar2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cVar, cVar2)) == null) {
            if (cVar2 == null) {
                return false;
            }
            String str2 = null;
            if (cVar == null) {
                f43 b0 = f43.b0();
                if (b0 != null) {
                    str = b0.U().e("dynamicLibPath", null);
                } else {
                    str = null;
                }
            } else {
                str = cVar.t().get("dynamicLibPath");
            }
            String str3 = cVar2.t().get("dynamicLibPath");
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
            return !TextUtils.equals(str2, str);
        }
        return invokeLL.booleanValue;
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.c = pMSAppInfo;
            o62.b().c(this);
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.e = null;
            this.d = null;
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.d = cVar;
            if (k) {
                Log.d("BasePreloadMasterManager", "fire prefetch event name - " + cVar.a);
            }
        }
    }

    public synchronized void c(q62 q62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q62Var) == null) {
            synchronized (this) {
                if (q62Var == null) {
                    return;
                }
                if (this.g) {
                    if (k) {
                        Log.d("BasePreloadMasterManager", "is Ready , call back immediately");
                    }
                    q62Var.onReady();
                    return;
                }
                if (!this.b.contains(q62Var)) {
                    this.b.add(q62Var);
                }
            }
        }
    }

    public final void e() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                Log.d("BasePreloadMasterManager", "start create a blank preload master manager, is default - " + this.f + ",is v8 - " + this.j);
            }
            this.h = System.currentTimeMillis();
            if (k) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            this.a = za2.U().D0(this.j, new a(this));
            if (k) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("BasePreloadMasterManager", "create a new master cost - " + (currentTimeMillis - j) + "ms");
            }
        }
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.d("BasePreloadMasterManager", "notifyAllReady, callback size " + this.b.size());
                }
                for (q62 q62Var : this.b) {
                    if (q62Var != null) {
                        q62Var.onReady();
                    }
                }
                this.b.clear();
            }
        }
    }

    public void q(String str, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, pMSAppInfo) == null) {
            v(pMSAppInfo);
            o92.c(str, pMSAppInfo.appId);
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.u()) {
            this.e = new p62();
            this.e.a = pMSAppInfo.appId;
            this.e.b = pMSAppInfo;
            this.e.c = cVar;
        }
    }

    public void r(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                if (k) {
                    Log.e("BasePreloadMasterManager", "prefetch event is null");
                }
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.a == null) {
                    f12.k("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                } else if (l() && this.c == null) {
                    f12.k("BasePreloadMasterManager", "default blank master can not use to prefetch");
                } else if (k(cVar, pMSAppInfo)) {
                    f12.k("BasePreloadMasterManager", "intercept before preload/prefetch");
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(str, cVar, pMSAppInfo);
                }
            } else {
                f12.k("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
            }
        }
    }

    public void u(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, cVar, pMSAppInfo) == null) {
            c(new b(this, str, pMSAppInfo, cVar));
            if (k) {
                Log.i("BasePreloadMasterManager", "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode);
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            b62 b62Var = this.a;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId) && b62Var != null) {
                if (k) {
                    Log.d("BasePreloadMasterManager", "set code cache setting before preload/prefetch");
                }
                d32 f = b62Var.f();
                String str = bn2.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
                if (f instanceof nb2) {
                    ((nb2) f).B0(x22.a("appjs", str));
                } else if (f instanceof NgWebView) {
                    ((NgWebView) f).getSettings().setCodeCacheSetting(y22.a("appjs", str));
                }
            }
        }
    }
}
