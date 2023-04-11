package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.gt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class ht2 implements gt2.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static AtomicLong c;
    public static final Lock d;
    public static volatile ht2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ft2 a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends dt2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ht2 ht2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(ht2 ht2Var, a aVar) {
            this(ht2Var);
        }

        @Override // com.baidu.tieba.dt2
        public void Q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.Q();
            }
        }

        @Override // com.baidu.tieba.ft2
        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.h;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835171, "Lcom/baidu/tieba/ht2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835171, "Lcom/baidu/tieba/ht2;");
                return;
            }
        }
        b = eo1.a;
        c = new AtomicLong(0L);
        d = new ReentrantLock();
    }

    public static ht2 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.lock();
            try {
                if (e == null) {
                    e = new ht2();
                }
                return e;
            } finally {
                d.unlock();
            }
        }
        return (ht2) invokeV.objValue;
    }

    public static void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            d.lock();
            try {
                if (e == null) {
                    return;
                }
                if (e.a != null) {
                    e.a.O();
                }
                e = null;
            } finally {
                d.unlock();
            }
        }
    }

    public ht2() {
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
        this.a = new b(this, null);
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.C();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public u73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.D();
        }
        return (u73) invokeV.objValue;
    }

    public ip1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.F();
        }
        return (ip1) invokeV.objValue;
    }

    public xf3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.G();
        }
        return (xf3) invokeV.objValue;
    }

    public c72 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.H();
        }
        return (c72) invokeV.objValue;
    }

    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.M();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.N();
        }
        return invokeV.booleanValue;
    }

    public long S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return c.get();
        }
        return invokeV.longValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ol3.n().e();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public d72 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity activity = U().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.Z();
        }
        return (d72) invokeV.objValue;
    }

    public lp1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.P();
        }
        return (lp1) invokeV.objValue;
    }

    public lp1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a.L();
        }
        return (lp1) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Z() && this.a.getActivity() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ft2 ft2Var = this.a;
            if (ft2Var != null && !(ft2Var instanceof b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.a();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            long incrementAndGet = c.incrementAndGet();
            if (b) {
                Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.b();
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.a.c();
        }
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a.exit();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a.g();
        }
        return (String) invokeV.objValue;
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a.getActivity();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    public bu1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a.i();
        }
        return (bu1) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.a.p();
        }
    }

    @DebugTrace
    public zt1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.a.q();
        }
        return (zt1) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.a.r();
        }
        return (Pair) invokeV.objValue;
    }

    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.a.s();
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.v();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.a.w();
        }
    }

    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.a.x();
        }
        return (Pair) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.a.z();
        }
        return (String) invokeV.objValue;
    }

    public cu1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.a.A(str);
        }
        return (cu1) invokeL.objValue;
    }

    public View B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.a.B(str);
        }
        return (View) invokeL.objValue;
    }

    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) {
            return this.a.J(activity);
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a.K(str);
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || Z()) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                this.a = cr2.a();
                return;
            }
            return;
        }
        this.a = new et2();
    }

    @NonNull
    public j83 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return this.a.f(str);
        }
        return (j83) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gt2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.a.h(i);
        }
    }

    public j83 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            return this.a.j(str);
        }
        return (j83) invokeL.objValue;
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !Z()) {
                Q(swanAppActivity.T());
            }
            if (Z()) {
                this.a.l(swanAppActivity);
            }
        }
    }

    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, activity)) == null) {
            return this.a.n(activity);
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, context) == null) {
            this.a.registerReceiver(context);
        }
    }

    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            this.a.t(intent);
        }
    }

    public void u(uh2 uh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, uh2Var) == null) {
            this.a.u(uh2Var);
        }
    }

    public void unregisterReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, context) == null) {
            this.a.unregisterReceiver(context);
        }
    }

    public void E(rs2 rs2Var, oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, rs2Var, oq2Var) == null) {
            this.a.E(rs2Var, oq2Var);
        }
    }

    public void d(rs2 rs2Var, oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, rs2Var, oq2Var) == null) {
            this.a.d(rs2Var, oq2Var);
        }
    }

    public void m(String str, uh2 uh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, uh2Var) == null) {
            this.a.m(str, uh2Var);
        }
    }

    public void y(xh2 xh2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, xh2Var, z) == null) {
            this.a.y(xh2Var, z);
        }
    }

    public void R() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long decrementAndGet = c.decrementAndGet();
            SwanAppActivity w = t73.K().w();
            if (decrementAndGet <= 0 && w != null && w.g0()) {
                this.a.I();
            }
            if (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                if (w != null && w.g0()) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.i("SwanAppController", sb.toString());
            }
        }
    }

    @NonNull
    public j83 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, str, swanAppConfigData, str2)) == null) {
            return this.a.e(str, swanAppConfigData, str2);
        }
        return (j83) invokeLLL.objValue;
    }
}
