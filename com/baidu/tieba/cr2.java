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
import com.baidu.tieba.br2;
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
/* loaded from: classes5.dex */
public final class cr2 implements br2.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static AtomicLong c;
    public static final Lock d;
    public static volatile cr2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ar2 a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends yq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(cr2 cr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(cr2 cr2Var, a aVar) {
            this(cr2Var);
        }

        @Override // com.baidu.tieba.yq2
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.R();
            }
        }

        @Override // com.baidu.tieba.ar2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684294, "Lcom/baidu/tieba/cr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684294, "Lcom/baidu/tieba/cr2;");
                return;
            }
        }
        b = am1.a;
        c = new AtomicLong(0L);
        d = new ReentrantLock();
    }

    public static cr2 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.lock();
            try {
                if (e == null) {
                    e = new cr2();
                }
                return e;
            } finally {
                d.unlock();
            }
        }
        return (cr2) invokeV.objValue;
    }

    public static void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            d.lock();
            try {
                if (e == null) {
                    return;
                }
                if (e.a != null) {
                    e.a.P();
                }
                e = null;
            } finally {
                d.unlock();
            }
        }
    }

    public cr2() {
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

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.A();
        }
        return (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.D();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public p53 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.F();
        }
        return (p53) invokeV.objValue;
    }

    public en1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.H();
        }
        return (en1) invokeV.objValue;
    }

    public sd3 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.I();
        }
        return (sd3) invokeV.objValue;
    }

    public x42 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.J();
        }
        return (x42) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.O();
        }
        return invokeV.booleanValue;
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return c.get();
        }
        return invokeV.longValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return jj3.n().e();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public y42 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppActivity activity = V().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.Y();
        }
        return (y42) invokeV.objValue;
    }

    public hn1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a.Q();
        }
        return (hn1) invokeV.objValue;
    }

    public hn1 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.a.N();
        }
        return (hn1) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (a0() && this.a.getActivity() != null) {
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

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ar2 ar2Var = this.a;
            if (ar2Var != null && !(ar2Var instanceof b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.b();
        }
        return (String) invokeV.objValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            long incrementAndGet = c.incrementAndGet();
            if (b) {
                Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.c();
        }
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.a.exit();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a.g();
        }
        return (String) invokeV.objValue;
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.a.getActivity();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a.getCoreVersion();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public xr1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.a.i();
        }
        return (xr1) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.a.p();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.a.q();
        }
    }

    @DebugTrace
    public vr1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.a.r();
        }
        return (vr1) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.a.s();
        }
        return (Pair) invokeV.objValue;
    }

    public SwanAppConfigData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a.t();
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.a.w();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.a.x();
        }
    }

    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.a.y();
        }
        return (Pair) invokeV.objValue;
    }

    public yr1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.a.B(str);
        }
        return (yr1) invokeL.objValue;
    }

    public View C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.a.C(str);
        }
        return (View) invokeL.objValue;
    }

    public void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a.E(context);
        }
    }

    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            return this.a.L(activity);
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.a.M(str);
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || a0()) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                this.a = xo2.a();
                return;
            }
            return;
        }
        this.a = new zq2();
    }

    @NonNull
    public e63 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return this.a.f(str);
        }
        return (e63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.br2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.a.h(i);
        }
    }

    public e63 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            return this.a.j(str);
        }
        return (e63) invokeL.objValue;
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, context) == null) {
            this.a.l(context);
        }
    }

    public void m(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !a0()) {
                R(swanAppActivity.R());
            }
            if (a0()) {
                this.a.m(swanAppActivity);
            }
        }
    }

    public FullScreenFloatView o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, activity)) == null) {
            return this.a.o(activity);
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    public void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, intent) == null) {
            this.a.u(intent);
        }
    }

    public void v(pf2 pf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, pf2Var) == null) {
            this.a.v(pf2Var);
        }
    }

    public void G(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, mq2Var, jo2Var) == null) {
            this.a.G(mq2Var, jo2Var);
        }
    }

    public void d(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, mq2Var, jo2Var) == null) {
            this.a.d(mq2Var, jo2Var);
        }
    }

    public void n(String str, pf2 pf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, pf2Var) == null) {
            this.a.n(str, pf2Var);
        }
    }

    public void z(sf2 sf2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sf2Var, z) == null) {
            this.a.z(sf2Var, z);
        }
    }

    public void S() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long decrementAndGet = c.decrementAndGet();
            SwanAppActivity w = o53.K().w();
            if (decrementAndGet <= 0 && w != null && w.f0()) {
                this.a.K();
            }
            if (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                if (w != null && w.f0()) {
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
    public e63 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, str, swanAppConfigData, str2)) == null) {
            return this.a.e(str, swanAppConfigData, str2);
        }
        return (e63) invokeLLL.objValue;
    }
}
