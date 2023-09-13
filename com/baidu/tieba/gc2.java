package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.pb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final pb2 a;
    public final yb2 b;
    public final mb2 c;
    public String d;

    /* loaded from: classes6.dex */
    public class a implements pb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;
        public final /* synthetic */ ac2 b;
        public final /* synthetic */ ob2 c;
        public final /* synthetic */ gc2 d;

        public a(gc2 gc2Var, SceneType sceneType, ac2 ac2Var, ob2 ob2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, sceneType, ac2Var, ob2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gc2Var;
            this.a = sceneType;
            this.b = ac2Var;
            this.c = ob2Var;
        }

        @Override // com.baidu.tieba.pb2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                gb2.b(this.d.d);
                jb2.i(1);
                ib2.e(this.a.getType(), networkStatus.getStatus(), this.b.e().getStatus(), this.b.g(), this.b.b(), this.b.f(), this.b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.c.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                jb2.g(sb.toString());
                if (gc2.e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.d.h(networkStatus, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pb2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                yb2.d().j();
                mb2.d().j();
                gb2.c();
                jb2.i(0);
                ib2.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947789043, "Lcom/baidu/tieba/gc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947789043, "Lcom/baidu/tieba/gc2;");
                return;
            }
        }
        e = rr1.a;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SceneSkeletonTips", ">> trigger skeleton error event.");
            }
            this.a.a(new b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f(SceneType.SCENE_SKELETON_TIMEOUT);
        }
    }

    public gc2() {
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
        this.c = mb2.d();
        this.a = new pb2();
        this.b = yb2.d();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public void f(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sceneType) == null) {
            if (bp3.I(this.d) && bp3.H()) {
                if (e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                yb2.d().j();
                mb2.d().j();
                ob2 f = this.c.f();
                this.a.a(new a(this, sceneType, this.b.f(), f));
            } else if (e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.d);
            }
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull ob2 ob2Var, @NonNull ac2 ac2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, ob2Var, ac2Var) == null) {
            boolean b2 = ob2Var.b();
            int i = R.string.obfuscated_res_0x7f0f159b;
            if (b2) {
                i = R.string.obfuscated_res_0x7f0f15a0;
            } else if (ac2Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f159e;
            } else if (ac2Var.e() != RequestStatus.STATUS_FAILED) {
                if (ac2Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f159f : R.string.obfuscated_res_0x7f0f159c;
                } else if (ac2Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f159d;
                }
            }
            hb2.f(i);
        }
    }
}
