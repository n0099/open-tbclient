package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.dr2;
import com.baidu.tieba.w24;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes5.dex */
public class f44 extends pr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public v24 l;
    public Runnable m;
    public k44 n;

    /* loaded from: classes5.dex */
    public class a implements ap2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap2 a;
        public final /* synthetic */ dr2 b;
        public final /* synthetic */ f44 c;

        /* renamed from: com.baidu.tieba.f44$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0276a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zo2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0276a(a aVar, zo2 zo2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zo2Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = zo2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                w24.c cVar = (w24.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.n0()) {
                            if (!x04.m().n()) {
                                e32.c(false);
                                this.c.b.A0(false);
                            } else {
                                f44 f44Var = this.c.c;
                                f44Var.o(f44Var.d).setVisibility(0);
                                this.c.c.r().E(this.c.c.f);
                                d32.b(true);
                                g32.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.f0(cVar.c);
                        t74.b().e(cVar.c);
                    }
                }
            }
        }

        public a(f44 f44Var, ap2 ap2Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f44Var, ap2Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f44Var;
            this.a = ap2Var;
            this.b = dr2Var;
        }

        @Override // com.baidu.tieba.ap2
        public void a(int i, zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, zo2Var) == null) {
                ak3.d0(this.c.m);
                this.c.m = new RunnableC0276a(this, zo2Var, i);
                ak3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947714147, "Lcom/baidu/tieba/f44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947714147, "Lcom/baidu/tieba/f44;");
                return;
            }
        }
        o = rm1.a;
    }

    public f44() {
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
        this.l = new v24();
        this.n = new k44();
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.k)) {
                return "";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public vn1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (vn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public yn1 N() {
        InterceptResult invokeV;
        d24 d24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p52 U = U();
            if (U == null || (d24Var = (d24) U.n(d24.class)) == null) {
                return null;
            }
            return d24Var.F3();
        }
        return (yn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public yn1 Q() {
        InterceptResult invokeV;
        d24 d24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            p52 U = U();
            if (U == null || (d24Var = (d24) U.n(d24.class)) == null) {
                return null;
            }
            return d24Var.D3();
        }
        return (yn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2
    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return s();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return g24.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return y();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.x();
            ft2.h(false);
            w54.a.a().f();
        }
    }

    public final void f0(a64 a64Var) {
        g63 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a64Var) == null) && (F = F()) != null) {
            F.I0(a64Var);
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public FullScreenFloatView o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            super.o(activity);
            this.f.setAutoAttachEnable(false);
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void G(dr2 dr2Var, ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr2Var, ap2Var) == null) {
            super.G(dr2Var, ap2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + dr2Var.k0());
            }
            w24.c(dr2Var, new a(this, ap2Var, dr2Var));
            g24.m().I(dr2Var);
            g24.m().G(dr2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            g24.m().z(null);
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090193)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.P();
            g24.C();
            w54.a.a().d(new JsObject());
            jm4.k(qi2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public ms1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = new b14(AppRuntime.getAppContext());
                c14.h(true);
            }
            this.a.D((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (ms1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                dr2.a T2 = this.d.T();
                jd3 jd3Var = new jd3();
                jd3Var.a = zc3.n(1);
                jd3Var.f = T2.I();
                jd3Var.c = T2.U();
                jd3Var.b = "show";
                jd3Var.d(T2.t0().getString("ubc"));
                jd3Var.b(zc3.k(T2.X()));
                zc3.onEvent(jd3Var);
            }
            ft2.h(true);
            w54.a.a().j();
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return super.y();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window != null && (decorView = window.getDecorView()) != null) {
                i2 = decorView.getWidth();
                i = decorView.getHeight();
            } else {
                i = 0;
                i2 = 0;
            }
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            if (i2 == 0 || i == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            if (this.d.j0() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            if (o) {
                Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (Pair) invokeV.objValue;
    }
}
