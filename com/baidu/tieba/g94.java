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
import com.baidu.tieba.ew2;
import com.baidu.tieba.x74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes6.dex */
public class g94 extends qw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public w74 l;
    public Runnable m;
    public l94 n;

    /* loaded from: classes6.dex */
    public class a implements bu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu2 a;
        public final /* synthetic */ ew2 b;
        public final /* synthetic */ g94 c;

        /* renamed from: com.baidu.tieba.g94$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0305a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ au2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0305a(a aVar, au2 au2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, au2Var, Integer.valueOf(i)};
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
                this.a = au2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                x74.c cVar = (x74.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.m0()) {
                            if (!y54.m().n()) {
                                f82.c(false);
                                this.c.b.z0(false);
                            } else {
                                g94 g94Var = this.c.c;
                                g94Var.n(g94Var.d).setVisibility(0);
                                this.c.c.q().F(this.c.c.f);
                                e82.b(true);
                                h82.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.d0(cVar.c);
                        uc4.b().e(cVar.c);
                    }
                }
            }
        }

        public a(g94 g94Var, bu2 bu2Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g94Var, bu2Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g94Var;
            this.a = bu2Var;
            this.b = ew2Var;
        }

        @Override // com.baidu.tieba.bu2
        public void a(int i, au2 au2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, au2Var) == null) {
                bp3.d0(this.c.m);
                this.c.m = new RunnableC0305a(this, au2Var, i);
                bp3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748743, "Lcom/baidu/tieba/g94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748743, "Lcom/baidu/tieba/g94;");
                return;
            }
        }
        o = rr1.a;
    }

    public g94() {
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
        this.l = new w74();
        this.n = new l94();
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public vs1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (vs1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public ys1 L() {
        InterceptResult invokeV;
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            qa2 S = S();
            if (S == null || (e74Var = (e74) S.n(e74.class)) == null) {
                return null;
            }
            return e74Var.A3();
        }
        return (ys1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public ys1 O() {
        InterceptResult invokeV;
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            qa2 S = S();
            if (S == null || (e74Var = (e74) S.n(e74.class)) == null) {
                return null;
            }
            return e74Var.y3();
        }
        return (ys1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2
    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return r();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return h74.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return x();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            gy2.h(false);
            xa4.a.a().f();
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
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

    public final void d0(bb4 bb4Var) {
        hb3 D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bb4Var) == null) && (D = D()) != null) {
            D.H0(bb4Var);
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
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

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void E(ew2 ew2Var, bu2 bu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ew2Var, bu2Var) == null) {
            super.E(ew2Var, bu2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + ew2Var.j0());
            }
            x74.c(ew2Var, new a(this, bu2Var, ew2Var));
            h74.m().I(ew2Var);
            h74.m().G(ew2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            h74.m().z(null);
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09017f)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.N();
            h74.C();
            xa4.a.a().d(new JsObject());
            lr4.k(rn2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public mx1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new c64(AppRuntime.getAppContext());
                d64.h(true);
            }
            this.a.E((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (mx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                ew2.a S = this.d.S();
                ki3 ki3Var = new ki3();
                ki3Var.a = ai3.n(1);
                ki3Var.f = S.H();
                ki3Var.c = S.T();
                ki3Var.b = "show";
                ki3Var.d(S.s0().getString("ubc"));
                ki3Var.b(ai3.k(S.W()));
                ai3.onEvent(ki3Var);
            }
            gy2.h(true);
            xa4.a.a().j();
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
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
