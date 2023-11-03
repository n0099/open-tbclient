package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static c g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Application a;
    @Nullable
    public or2 b;
    public boolean c;
    public boolean d;
    public int e;

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z, int i);
    }

    /* loaded from: classes6.dex */
    public class a extends or2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk3 a;

        /* renamed from: com.baidu.tieba.gk3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0314a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ a b;

            public RunnableC0314a(a aVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.a.getIntent();
                    rq1 o = np2.o();
                    ComponentName component = intent.getComponent();
                    if (this.b.a.c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.b.a.d) {
                            if (gk3.f) {
                                Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                return;
                            }
                            return;
                        }
                        mi3 m = mi3.m();
                        if (ni3.a() && mi3.k()) {
                            u = m.w(this.a, this.b.a.e, false);
                        } else {
                            u = m.u(this.b.a.e, false, false);
                        }
                        if (gk3.f) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + this.b.a.e);
                        }
                        m.i();
                    }
                    if (gk3.f) {
                        Log.d("SwanHomeScreenLaunch", "class=" + this.a + ", swanAppForeground=" + this.b.a.c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                    }
                }
            }
        }

        public a(gk3 gk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gk3Var;
        }

        @Override // com.baidu.tieba.or2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                gk3 gk3Var = this.a;
                if (gk3Var.c && activity != null && activity.getTaskId() == this.a.e) {
                    z = true;
                } else {
                    z = false;
                }
                gk3Var.c = z;
            }
        }

        @Override // com.baidu.tieba.or2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, activity, bundle) != null) || !mi3.j()) {
                return;
            }
            super.onActivityCreated(activity, bundle);
            if (activity != null && activity.getIntent() != null) {
                RunnableC0314a runnableC0314a = new RunnableC0314a(this, activity);
                if (ni3.a()) {
                    runnableC0314a.run();
                } else {
                    aj3.j(runnableC0314a, "moveTaskToFront");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk3 a;

        public b(gk3 gk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gk3Var;
        }

        @Override // com.baidu.tieba.gk3.c
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (!z) {
                    if (this.a.c && i == 1) {
                        this.a.c = false;
                    }
                } else {
                    this.a.c = true;
                    this.a.e = i;
                }
                this.a.d = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947796762, "Lcom/baidu/tieba/gk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947796762, "Lcom/baidu/tieba/gk3;");
                return;
            }
        }
        f = rm1.a;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g = null;
            this.a.unregisterActivityLifecycleCallbacks(this.b);
        }
    }

    public gk3(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = application;
        this.b = new a(this);
        g = new b(this);
        application.registerActivityLifecycleCallbacks(this.b);
    }

    public static void h(boolean z, int i) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (cVar = g) != null) {
            cVar.a(z, i);
        }
    }
}
