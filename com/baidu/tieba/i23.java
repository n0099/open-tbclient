package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.p23;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class i23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile String b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: com.baidu.tieba.i23$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0329a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ Rect c;

            public RunnableC0329a(a aVar, int i, Bitmap bitmap, Rect rect) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), bitmap, rect};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = bitmap;
                this.c = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    p23 a = p23.a.a("simple_parser");
                    a.c(this.a);
                    if (!a.a(this.b, this.c)) {
                        i23.h();
                    }
                }
            }
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            eb2 Y;
            db2 o;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = ix2.T().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (Y = activity.Y()) == null || (o = Y.o()) == null) {
                return;
            }
            Bitmap p = mp3.p();
            po3.f().execute(new RunnableC0329a(this, e23.d(o), p, e23.b(p, o, ix2.T().B(this.a))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947801567, "Lcom/baidu/tieba/i23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947801567, "Lcom/baidu/tieba/i23;");
                return;
            }
        }
        a = fs1.a;
        b = "";
        c = true;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static void h() {
        sw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (vb3.M() != null) {
                aVar = vb3.M().Y();
            } else {
                aVar = null;
            }
            fi3.o(aVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            b = "";
            c = true;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            pp3.a0(new a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static void c() {
        eb2 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (fi3.f() || (U = ix2.T().U()) == null) {
                return;
            }
            db2 o = U.o();
            my1 my1Var = null;
            if (o != null) {
                by1 q3 = o.q3();
                if (q3 == null) {
                    return;
                }
                ey1 j = q3.j();
                if (j != null) {
                    my1Var = j.L();
                } else {
                    my1Var = q3.L();
                }
            }
            if (my1Var != null && my1Var.b > 0) {
                fi3.a(my1Var);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || fi3.h()) {
            return;
        }
        db2 H = ix2.T().H();
        if (H == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(H)) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(H.v3());
        }
    }

    public static boolean f(db2 db2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, db2Var)) == null) {
            if (db2Var == null) {
                return false;
            }
            boolean equals = TextUtils.equals(b, db2Var.v3());
            if (a) {
                Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
            }
            if (z && fi3.j()) {
                if (a) {
                    Log.d("SwanArrivalMonitor", "end handle swan page change");
                    return;
                }
                return;
            }
            if (z) {
                c = false;
            }
            if (!z) {
                d();
            }
            fi3.G();
            c();
            vb3 M = vb3.M();
            if (M != null && !z) {
                fi3.q(M.Y());
            }
        }
    }
}
