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
import com.baidu.tieba.s84;
import com.baidu.tieba.zw2;
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
public class ba4 extends lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public r84 l;
    public Runnable m;
    public ga4 n;

    /* loaded from: classes5.dex */
    public class a implements wu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu2 a;
        public final /* synthetic */ zw2 b;
        public final /* synthetic */ ba4 c;

        /* renamed from: com.baidu.tieba.ba4$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0257a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vu2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0257a(a aVar, vu2 vu2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, vu2Var, Integer.valueOf(i)};
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
                this.a = vu2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                s84.c cVar = (s84.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.m0()) {
                            if (!t64.m().n()) {
                                a92.c(false);
                                this.c.b.z0(false);
                            } else {
                                ba4 ba4Var = this.c.c;
                                ba4Var.n(ba4Var.d).setVisibility(0);
                                this.c.c.q().F(this.c.c.f);
                                z82.b(true);
                                c92.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.d0(cVar.c);
                        pd4.b().e(cVar.c);
                    }
                }
            }
        }

        public a(ba4 ba4Var, wu2 wu2Var, zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba4Var, wu2Var, zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba4Var;
            this.a = wu2Var;
            this.b = zw2Var;
        }

        @Override // com.baidu.tieba.wu2
        public void a(int i, vu2 vu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, vu2Var) == null) {
                wp3.d0(this.c.m);
                this.c.m = new RunnableC0257a(this, vu2Var, i);
                wp3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638228, "Lcom/baidu/tieba/ba4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638228, "Lcom/baidu/tieba/ba4;");
                return;
            }
        }
        o = ms1.a;
    }

    public ba4() {
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
        this.l = new r84();
        this.n = new ga4();
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public qt1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (qt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public tt1 L() {
        InterceptResult invokeV;
        z74 z74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            lb2 S = S();
            if (S == null || (z74Var = (z74) S.n(z74.class)) == null) {
                return null;
            }
            return z74Var.A3();
        }
        return (tt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public tt1 O() {
        InterceptResult invokeV;
        z74 z74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lb2 S = S();
            if (S == null || (z74Var = (z74) S.n(z74.class)) == null) {
                return null;
            }
            return z74Var.y3();
        }
        return (tt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2
    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return r();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return c84.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return x();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            bz2.h(false);
            sb4.a.a().f();
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.k)) {
                return "";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final void d0(wb4 wb4Var) {
        cc3 D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, wb4Var) == null) && (D = D()) != null) {
            D.H0(wb4Var);
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.n(activity);
            this.f.setAutoAttachEnable(false);
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void E(zw2 zw2Var, wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, zw2Var, wu2Var) == null) {
            super.E(zw2Var, wu2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + zw2Var.j0());
            }
            s84.c(zw2Var, new a(this, wu2Var, zw2Var));
            c84.m().I(zw2Var);
            c84.m().G(zw2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            c84.m().z(null);
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090180)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.N();
            c84.C();
            sb4.a.a().d(new JsObject());
            gs4.k(mo2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public hy1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new x64(AppRuntime.getAppContext());
                y64.h(true);
            }
            this.a.E((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (hy1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                zw2.a T2 = this.d.T();
                fj3 fj3Var = new fj3();
                fj3Var.a = vi3.n(1);
                fj3Var.f = T2.H();
                fj3Var.c = T2.T();
                fj3Var.b = "show";
                fj3Var.d(T2.s0().getString("ubc"));
                fj3Var.b(vi3.k(T2.W()));
                vi3.onEvent(fj3Var);
            }
            bz2.h(true);
            sb4.a.a().j();
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return super.x();
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
