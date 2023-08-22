package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.lb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public class bc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer a;
    public final lb2 b;

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc2 a;

        public a(bc2 bc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bc2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (bc2.c) {
                    Log.d("SceneQueryPkgTips", ">> start collecting network status.");
                }
                this.a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc2 a;

        public b(bc2 bc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bc2Var;
        }

        @Override // com.baidu.tieba.lb2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                fb2.g(SceneType.SCENE_PMS_TIMEOUT.getScene() + networkStatus.getDesc());
                eb2.c(SceneType.SCENE_PMS_TIMEOUT.getType(), networkStatus.getStatus());
                this.a.e(networkStatus);
                if (bc2.c) {
                    Log.d("SceneQueryPkgTips", ">> " + SceneType.SCENE_PMS_TIMEOUT.getScene() + networkStatus.getDesc());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-923635463, "Lcom/baidu/tieba/bc2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-923635463, "Lcom/baidu/tieba/bc2$c;");
                    return;
                }
            }
            int[] iArr = new int[NetworkStatus.values().length];
            a = iArr;
            try {
                iArr[NetworkStatus.NETWORK_BAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkStatus.NETWORK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947640088, "Lcom/baidu/tieba/bc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947640088, "Lcom/baidu/tieba/bc2;");
                return;
            }
        }
        c = nr1.a;
    }

    public bc2() {
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
        this.b = new lb2();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.a(new b(this));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (bc2.class) {
                if (this.a != null) {
                    if (c) {
                        Log.d("SceneQueryPkgTips", ">> stop collecting network status.");
                    }
                    this.a.cancel();
                    this.a = null;
                }
            }
        }
    }

    public final void e(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i = c.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                db2.f(R.string.obfuscated_res_0x7f0f1589);
            } else {
                db2.f(R.string.obfuscated_res_0x7f0f157f);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (bc2.class) {
                if (c) {
                    Log.d("SceneQueryPkgTips", ">> start to collect network status.");
                }
                Timer timer = new Timer();
                this.a = timer;
                timer.schedule(new a(this), 3000L);
            }
        }
    }
}
