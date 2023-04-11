package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class an3 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int[] e;
    public c f;
    public long g;
    public b h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MotionEvent a;
        public ai2 b;
        public final /* synthetic */ an3 c;

        public b(an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = an3Var;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.a = motionEvent;
                this.b = this.c.d(motionEvent, "longtap");
            }
        }

        public /* synthetic */ b(an3 an3Var, a aVar) {
            this(an3Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.g(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public double b;

        public c(an3 an3Var, double d, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an3Var, Double.valueOf(d), Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d;
            this.b = d2;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.a - this.a, 2.0d) + Math.pow(cVar.b - this.b, 2.0d);
                if (pow <= 0.0d) {
                    return 0.0d;
                }
                return Math.sqrt(pow);
            }
            return invokeL.doubleValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620899, "Lcom/baidu/tieba/an3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620899, "Lcom/baidu/tieba/an3;");
                return;
            }
        }
        i = eo1.a;
    }

    public final void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (jl3.f("1.12.0") && TextUtils.equals("canvas", this.c)) {
                z = true;
            } else {
                z = false;
            }
            this.d = z;
        }
    }

    public final void i() {
        View m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (m = ol3.m(this.a)) == null) {
            return;
        }
        m.getLocationOnScreen(this.e);
    }

    public an3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = new int[2];
        this.h = new b(this, null);
        this.a = str;
        this.b = str2;
        this.c = str3;
        h();
        i();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view2, motionEvent)) == null) {
            e(view2, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final ai2 c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            zm3 zm3Var = new zm3(motionEvent);
            zm3Var.i(this.e);
            ai2 ai2Var = new ai2();
            ai2Var.c = bn3.b(this.a, this.b, this.c, zm3Var.e(), zm3Var.c());
            return ai2Var;
        }
        return (ai2) invokeL.objValue;
    }

    public final void g(ai2 ai2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ai2Var) == null) {
            if (i) {
                Log.d("SwanAppTouchListener", "sendEventToWebView = " + ai2Var.c);
            }
            if (!this.d) {
                ht2.U().m(this.a, ai2Var);
            } else {
                ht2.U().u(ai2Var);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final ai2 d(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            zm3 zm3Var = new zm3(motionEvent, str);
            zm3Var.i(this.e);
            ai2 ai2Var = new ai2();
            ai2Var.c = bn3.b(this.a, this.b, this.c, zm3Var.e(), zm3Var.c());
            return ai2Var;
        }
        return (ai2) invokeLL.objValue;
    }

    public final void e(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent) == null) {
            if (view2 != null && motionEvent != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                    this.f = new c(this, motionEvent.getX(), motionEvent.getY());
                    this.g = motionEvent.getEventTime();
                    this.h.b(motionEvent);
                    view2.postDelayed(this.h, 350L);
                    i();
                } else if (actionMasked == 1 || actionMasked == 3 || !f(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                    view2.removeCallbacks(this.h);
                }
                g(c(motionEvent));
                if (actionMasked == 1 && f(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.g < 350) {
                    g(d(motionEvent, "tap"));
                    return;
                }
                return;
            }
            u42.c("SwanAppTouchListener", "params is null, slaveId = " + this.a + " ; viewId = " + this.b);
        }
    }

    public final boolean f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c cVar2 = this.f;
            if (cVar2 != null && cVar2.a(cVar) <= ll3.g(10.0f)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
