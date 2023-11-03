package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g2 implements u1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AndroidLiveWallpaperService a;
    public e2 b;
    public f2 c;
    public x1 d;
    public a2 e;
    public j2 f;
    public l1 g;
    public boolean h;
    public final h3<Runnable> i;
    public final h3<Runnable> j;
    public final w3<q1> k;
    public int l;
    public m1 m;
    public volatile t2[] n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303714, "Lcom/baidu/tieba/g2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303714, "Lcom/baidu/tieba/g2;");
                return;
            }
        }
        m3.a();
    }

    public a2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new o2(e().getAssets(), e(), true);
        }
        return (a2) invokeV.objValue;
    }

    public m1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (m1) invokeV.objValue;
    }

    public AndroidLiveWallpaperService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (AndroidLiveWallpaperService) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.Application
    public l1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (l1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public h3<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (h3) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    /* renamed from: getInput */
    public f2 mo7getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (f2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public w3<q1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.k;
        }
        return (w3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public h3<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (h3) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u1
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            e2 e2Var = this.b;
            if (e2Var != null) {
                e2Var.y();
            }
            x1 x1Var = this.d;
            if (x1Var != null) {
                x1Var.dispose();
            }
        }
    }

    public g2(AndroidLiveWallpaperService androidLiveWallpaperService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {androidLiveWallpaperService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = new h3<>();
        this.j = new h3<>();
        this.k = new w3<>(q1.class);
        this.l = 2;
        this.n = null;
        this.a = androidLiveWallpaperService;
    }

    public x1 a(Context context, v1 v1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, v1Var)) == null) {
            return new n2(context, v1Var);
        }
        return (x1) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.l >= 1) {
            d().error(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && this.l >= 2) {
            d().log(str, str2);
        }
    }

    public f2 c(Application application, Context context, Object obj, v1 v1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, v1Var)) == null) {
            return new p2(this, e(), this.b.a, v1Var);
        }
        return (f2) invokeLLLL.objValue;
    }

    public void g(l1 l1Var, v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, l1Var, v1Var) == null) {
            if (f() >= 14) {
                k(new w1());
                s2 s2Var = v1Var.r;
                if (s2Var == null) {
                    s2Var = new q2();
                }
                this.b = new e2(this, v1Var, s2Var);
                this.c = c(this, e(), this.b.a, v1Var);
                this.d = a(e(), v1Var);
                this.e = b();
                this.f = new j2(this, v1Var);
                this.g = l1Var;
                new y1(e());
                o1.a = this;
                o1.b = this.b;
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause()");
            }
            this.d.pause();
            this.c.onPause();
            e2 e2Var = this.b;
            if (e2Var != null) {
                e2Var.o();
            }
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause() done!");
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            o1.a = this;
            f2 f2Var = this.c;
            o1.b = this.b;
            f2Var.onResume();
            e2 e2Var = this.b;
            if (e2Var != null) {
                e2Var.p();
            }
            if (!this.h) {
                this.d.resume();
                this.b.s();
                return;
            }
            this.h = false;
        }
    }

    public void k(m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, m1Var) == null) {
            this.m = m1Var;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, runnable) == null) {
            synchronized (this.i) {
                this.i.a(runnable);
            }
        }
    }
}
