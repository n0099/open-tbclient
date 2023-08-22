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
import com.baidu.tieba.aw2;
import com.baidu.tieba.t74;
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
public class c94 extends mw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public s74 l;
    public Runnable m;
    public h94 n;

    /* loaded from: classes5.dex */
    public class a implements xt2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt2 a;
        public final /* synthetic */ aw2 b;
        public final /* synthetic */ c94 c;

        /* renamed from: com.baidu.tieba.c94$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0261a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wt2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0261a(a aVar, wt2 wt2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, wt2Var, Integer.valueOf(i)};
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
                this.a = wt2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                t74.c cVar = (t74.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.m0()) {
                            if (!u54.m().n()) {
                                b82.c(false);
                                this.c.b.z0(false);
                            } else {
                                c94 c94Var = this.c.c;
                                c94Var.n(c94Var.d).setVisibility(0);
                                this.c.c.q().F(this.c.c.f);
                                a82.b(true);
                                d82.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.d0(cVar.c);
                        qc4.b().e(cVar.c);
                    }
                }
            }
        }

        public a(c94 c94Var, xt2 xt2Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c94Var, xt2Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c94Var;
            this.a = xt2Var;
            this.b = aw2Var;
        }

        @Override // com.baidu.tieba.xt2
        public void a(int i, wt2 wt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, wt2Var) == null) {
                xo3.d0(this.c.m);
                this.c.m = new RunnableC0261a(this, wt2Var, i);
                xo3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629579, "Lcom/baidu/tieba/c94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629579, "Lcom/baidu/tieba/c94;");
                return;
            }
        }
        o = nr1.a;
    }

    public c94() {
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
        this.l = new s74();
        this.n = new h94();
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public rs1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (rs1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public us1 L() {
        InterceptResult invokeV;
        a74 a74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ma2 S = S();
            if (S == null || (a74Var = (a74) S.n(a74.class)) == null) {
                return null;
            }
            return a74Var.A3();
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public us1 O() {
        InterceptResult invokeV;
        a74 a74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ma2 S = S();
            if (S == null || (a74Var = (a74) S.n(a74.class)) == null) {
                return null;
            }
            return a74Var.y3();
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2
    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return r();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return d74.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return x();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            cy2.h(false);
            ta4.a.a().f();
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
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

    public final void d0(xa4 xa4Var) {
        db3 D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, xa4Var) == null) && (D = D()) != null) {
            D.H0(xa4Var);
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
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

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void E(aw2 aw2Var, xt2 xt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aw2Var, xt2Var) == null) {
            super.E(aw2Var, xt2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + aw2Var.j0());
            }
            t74.c(aw2Var, new a(this, xt2Var, aw2Var));
            d74.m().I(aw2Var);
            d74.m().G(aw2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            d74.m().z(null);
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090183)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.N();
            d74.C();
            ta4.a.a().d(new JsObject());
            hr4.k(nn2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public ix1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new y54(AppRuntime.getAppContext());
                z54.h(true);
            }
            this.a.E((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (ix1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                aw2.a S = this.d.S();
                gi3 gi3Var = new gi3();
                gi3Var.a = wh3.n(1);
                gi3Var.f = S.H();
                gi3Var.c = S.T();
                gi3Var.b = "show";
                gi3Var.d(S.s0().getString("ubc"));
                gi3Var.b(wh3.k(S.W()));
                wh3.onEvent(gi3Var);
            }
            cy2.h(true);
            ta4.a.a().j();
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
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
