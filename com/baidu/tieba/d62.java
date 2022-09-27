package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.b62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d62 implements o52<n52>, w52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile c62 a;
    public volatile c62 b;
    public final LinkedList<ld2> c;
    public final List<q52<n52>> d;
    public c62 e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656425, "Lcom/baidu/tieba/d62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656425, "Lcom/baidu/tieba/d62;");
                return;
            }
        }
        k = vj1.a;
        l = l72.l() == 1;
    }

    public d62() {
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
        this.c = new LinkedList<>();
        this.d = new LinkedList();
        this.j = new Object();
        this.f = false;
        this.g = false;
        this.i = false;
        this.h = false;
    }

    @Override // com.baidu.tieba.o52
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
            }
            if (!this.f) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                    return;
                }
                return;
            }
            l02.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        b62.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.g) {
                        l33 b0 = l33.b0();
                        if (b0 != null && TextUtils.equals(str2, b0.getAppId())) {
                            l02.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.e.r(str, cVar, pMSAppInfo);
                            return;
                        } else if (k) {
                            Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                            return;
                        } else {
                            return;
                        }
                    }
                    synchronized (this.j) {
                        if (this.g) {
                            return;
                        }
                        if (this.b == null || this.b.w(pMSAppInfo, cVar)) {
                            m(this.b);
                            this.b = l(false, this.i);
                        }
                        this.b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
            }
        }
    }

    @Override // com.baidu.tieba.p52
    public void c(q52<n52> q52Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q52Var) == null) || q52Var == null) {
            return;
        }
        synchronized (this.j) {
            if (this.g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                q52Var.a(this.h, this.e);
                return;
            }
            if (!this.d.contains(q52Var)) {
                this.d.add(q52Var);
            }
        }
    }

    @Override // com.baidu.tieba.o52
    public void d(ld2 ld2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ld2Var) == null) || ld2Var == null || this.g) {
            return;
        }
        synchronized (this.j) {
            this.c.add(ld2Var);
        }
    }

    @Override // com.baidu.tieba.p52
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p52
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p52
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o52
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o52
    public void j(boolean z, w52 w52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, w52Var) == null) {
            if (this.a == null) {
                synchronized (this.j) {
                    if (this.a == null) {
                        this.i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(w52Var);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
            }
            if (this.a != null) {
                this.a.c(w52Var);
            }
        }
    }

    public final void k(c62 c62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c62Var) == null) {
            c62 c62Var2 = c62Var == this.b ? this.a : this.b;
            this.a = c62Var;
            m(c62Var2);
            this.b = null;
        }
    }

    public c62 l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            b62.c().b(!z);
            return new c62(z, z2);
        }
        return (c62) invokeCommon.objValue;
    }

    public final void m(c62 c62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, c62Var) == null) || c62Var == null || c62Var.i() == null) {
            return;
        }
        c62Var.i().destroy();
        if (k) {
            Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + c62Var.i().a() + ", isReady - " + c62Var.n() + ", is Default - " + c62Var.l());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.c.isEmpty() && this.g) {
            synchronized (this.j) {
                Iterator<ld2> it = this.c.iterator();
                while (it.hasNext()) {
                    ld2 next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.a);
                    }
                    fa2.U().U0(next);
                }
                this.c.clear();
            }
        }
    }

    public final void o(boolean z, c62 c62Var, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), c62Var, pMSAppInfo}) == null) {
            this.h = z;
            this.e = c62Var;
            c62Var.p(pMSAppInfo);
            this.g = true;
            n();
            k(c62Var);
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            q(z, c62Var);
            b62.c().a();
        }
    }

    @Override // com.baidu.tieba.w52
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p52
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public c62 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.g) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.e;
        }
        return (c62) invokeV.objValue;
    }

    public final void q(boolean z, c62 c62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, c62Var) == null) || this.d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (q52<n52> q52Var : this.d) {
                q52Var.a(z, c62Var);
            }
            this.d.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "is hit prefetch env - " + z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    @Override // com.baidu.tieba.p52
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c62 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        c62 c62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f) && k) {
                Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
                Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f);
            }
            if (this.g) {
                return this.e;
            }
            synchronized (this.j) {
                if (!this.g) {
                    if (k) {
                        b62.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.b != null && this.b.n() && pMSAppInfo != null) {
                        if (this.b.w(pMSAppInfo, null)) {
                            c62Var = this.a;
                            z = false;
                            o(z, c62Var, pMSAppInfo);
                        } else {
                            if (this.b.j()) {
                                c62Var = this.b;
                            } else {
                                b62.a aVar = new b62.a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f = b62.c().f(aVar);
                                boolean g = b62.c().g(aVar);
                                boolean e = b62.c().e();
                                if (k) {
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loaded - " + f);
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loading - " + g);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("has loading app now - ");
                                    sb.append(e);
                                    Log.d("SwanAppMasterProviderMulti", sb.toString());
                                }
                                if (e && !g) {
                                    if (f && l) {
                                        c62Var = z ? this.b : this.a;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                if (z) {
                                }
                            }
                            o(z, c62Var, pMSAppInfo);
                        }
                    }
                    c62Var = this.a;
                    z = false;
                    o(z, c62Var, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("final master id - ");
                sb2.append(this.e.i().a());
                Log.i("SwanAppMasterProviderMulti", sb2.toString());
            }
            return this.e;
        }
        return (c62) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p52
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                Log.d("SwanAppMasterProviderMulti", "release master provider");
            }
            this.f = false;
            this.g = false;
            this.i = false;
            this.h = false;
            m(this.a);
            m(this.b);
            this.a = null;
            this.b = null;
            this.e = null;
            synchronized (this.j) {
                this.c.clear();
                this.d.clear();
            }
            r52.c();
            u52.b().d();
            b62.c().a();
        }
    }
}
