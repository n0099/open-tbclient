package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class cx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static volatile cx1 h;
    public static vo2 i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public HashMap<String, vo2> b;
    public int c;
    public dl3<Integer> d;
    public zr2 e;
    public hj2 f;

    /* loaded from: classes5.dex */
    public class a extends hj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cx1 a;

        public a(cx1 cx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cx1Var;
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, keyEvent)) == null) {
                if (i == 4 && this.a.d != null && this.a.g()) {
                    this.a.d.a(1);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947690029, "Lcom/baidu/tieba/cx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947690029, "Lcom/baidu/tieba/cx1;");
                return;
            }
        }
        g = vm1.a;
    }

    public static cx1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (h == null) {
                synchronized (cx1.class) {
                    if (h == null) {
                        h = new cx1();
                    }
                }
            }
            return h;
        }
        return (cx1) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k32.i("SwanInlinePlayerManager", "clearCacheVideo: ");
            i = null;
            j = false;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.c;
            if (i2 != 90 && i2 != -90) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        dl3<Integer> dl3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && g() && (dl3Var = this.d) != null) {
            dl3Var.a(0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            xr2.V().getActivity().u0(this.f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                x();
                w();
                this.a = null;
                this.b.clear();
                this.d = null;
            }
            h = null;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k32.i("SwanInlinePlayerManager", "setCacheInUsed: true");
            j = true;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SwanAppActivity activity = xr2.V().getActivity();
            hj2 hj2Var = this.f;
            if (hj2Var != null && activity != null) {
                activity.G0(hj2Var);
            }
        }
    }

    public void x() {
        zr2 zr2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (zr2Var = this.e) != null) {
            as2.f(zr2Var);
            this.e = null;
        }
    }

    public cx1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = -1;
        this.d = null;
        this.e = null;
        this.f = new a(this);
    }

    public vo2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (g && i != null) {
                Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + i.c());
            }
            return i;
        }
        return (vo2) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z2 = true;
            if (d() != null && d().e0() == null) {
                z = true;
            } else {
                z = false;
            }
            z2 = (!z || j) ? false : false;
            k32.i("SwanInlinePlayerManager", "hasCacheVideo: " + z2);
            return z2;
        }
        return invokeV.booleanValue;
    }

    public void b(vo2 vo2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vo2Var) == null) && vo2Var != null && !TextUtils.isEmpty(vo2Var.c())) {
            this.b.put(vo2Var.c(), vo2Var);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b.remove(str);
        }
    }

    public void t(vo2 vo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, vo2Var) == null) {
            if (g) {
                Log.i("SwanInlinePlayerManager", "setCacheVideo: " + vo2Var.toString());
            }
            i = vo2Var;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.c = i2;
        }
    }

    public void v(dl3<Integer> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dl3Var) == null) {
            this.d = dl3Var;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            s52 J = xr2.V().J();
            if (g()) {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
                }
                if (J != null) {
                    J.Y3(false);
                }
                g53.g();
                g53.m(true);
            } else if (h()) {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: Setting portrait fullscreen immersion.");
                }
                if (J != null) {
                    J.Y3(true);
                }
            } else {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
                }
                if (J != null) {
                    J.Y3(false);
                }
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                    return;
                }
                return;
            }
            HashMap<String, vo2> hashMap = this.b;
            if (hashMap != null && hashMap.size() > 0) {
                int i2 = 0;
                for (String str2 : this.b.keySet()) {
                    if (str2.equals(str)) {
                        if (g) {
                            Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                        }
                    } else {
                        vo2 vo2Var = this.b.get(str2);
                        if (vo2Var != null) {
                            if (i2 < 3) {
                                if (!vo2Var.i0()) {
                                    vo2Var.pause();
                                    vo2Var.Q().c(vo2Var.c());
                                } else {
                                    i2++;
                                }
                            } else {
                                vo2Var.pause();
                                vo2Var.Q().c(vo2Var.c());
                            }
                        }
                    }
                }
            }
        }
    }

    public void l(String str, boolean z) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) && (hashMap = this.a) != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void o(vo2 vo2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, vo2Var) != null) || vo2Var == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), vo2Var.c())) {
            k32.i("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + vo2Var.c());
            i = null;
            j = false;
        }
    }

    public void q(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && (hashMap = this.a) != null) {
            hashMap.remove(str);
            int size = this.a.keySet().size();
            if (g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }
}
