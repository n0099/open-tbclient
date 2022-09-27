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
/* loaded from: classes3.dex */
public class cu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static volatile cu1 h;
    public static wl2 i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public HashMap<String, wl2> b;
    public int c;
    public ei3<Integer> d;
    public ap2 e;
    public ig2 f;

    /* loaded from: classes3.dex */
    public class a extends ig2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu1 a;

        public a(cu1 cu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu1Var;
        }

        @Override // com.baidu.tieba.ig2, com.baidu.tieba.jg2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687146, "Lcom/baidu/tieba/cu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687146, "Lcom/baidu/tieba/cu1;");
                return;
            }
        }
        g = vj1.a;
    }

    public cu1() {
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

    public static cu1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (h == null) {
                synchronized (cu1.class) {
                    if (h == null) {
                        h = new cu1();
                    }
                }
            }
            return h;
        }
        return (cu1) invokeV.objValue;
    }

    public void b(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, wl2Var) == null) || wl2Var == null || TextUtils.isEmpty(wl2Var.c())) {
            return;
        }
        this.b.put(wl2Var.c(), wl2Var);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l02.i("SwanInlinePlayerManager", "clearCacheVideo: ");
            i = null;
            j = false;
        }
    }

    public wl2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (g && i != null) {
                Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + i.c());
            }
            return i;
        }
        return (wl2) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || j) ? false : false;
            l02.i("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c == 0 : invokeV.booleanValue;
    }

    public void i() {
        ei3<Integer> ei3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && g() && (ei3Var = this.d) != null) {
            ei3Var.a(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            t22 H = yo2.U().H();
            if (g()) {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
                }
                if (H != null) {
                    H.R3(false);
                }
                h23.g();
                h23.m(true);
            } else if (h()) {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: Setting portrait fullscreen immersion.");
                }
                if (H != null) {
                    H.R3(true);
                }
            } else {
                if (g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
                }
                if (H != null) {
                    H.R3(false);
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
            HashMap<String, wl2> hashMap = this.b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (String str2 : this.b.keySet()) {
                if (str2.equals(str)) {
                    if (g) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    wl2 wl2Var = this.b.get(str2);
                    if (wl2Var != null) {
                        if (i2 < 3) {
                            if (wl2Var.j0()) {
                                i2++;
                            } else {
                                wl2Var.pause();
                                wl2Var.Q().c(wl2Var.c());
                            }
                        } else {
                            wl2Var.pause();
                            wl2Var.Q().c(wl2Var.c());
                        }
                    }
                }
            }
        }
    }

    public void l(String str, boolean z) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || (hashMap = this.a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            yo2.U().getActivity().t0(this.f);
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

    public void o(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, wl2Var) == null) || wl2Var == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), wl2Var.c())) {
            l02.i("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + wl2Var.c());
            i = null;
            j = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d = null;
        }
    }

    public void q(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (hashMap = this.a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.a.keySet().size();
        if (g) {
            Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            l02.i("SwanInlinePlayerManager", "setCacheInUsed: true");
            j = true;
        }
    }

    public void t(wl2 wl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, wl2Var) == null) {
            if (g) {
                Log.i("SwanInlinePlayerManager", "setCacheVideo: " + wl2Var.toString());
            }
            i = wl2Var;
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.c = i2;
        }
    }

    public void v(ei3<Integer> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ei3Var) == null) {
            this.d = ei3Var;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SwanAppActivity activity = yo2.U().getActivity();
            ig2 ig2Var = this.f;
            if (ig2Var == null || activity == null) {
                return;
            }
            activity.F0(ig2Var);
        }
    }

    public void x() {
        ap2 ap2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (ap2Var = this.e) == null) {
            return;
        }
        bp2.f(ap2Var);
        this.e = null;
    }
}
