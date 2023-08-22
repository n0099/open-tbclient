package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.lb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final lb2 a;
    public final ub2 b;
    public final ib2 c;
    public String d;

    /* loaded from: classes5.dex */
    public class a implements lb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;
        public final /* synthetic */ wb2 b;
        public final /* synthetic */ kb2 c;
        public final /* synthetic */ cc2 d;

        public a(cc2 cc2Var, SceneType sceneType, wb2 wb2Var, kb2 kb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc2Var, sceneType, wb2Var, kb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cc2Var;
            this.a = sceneType;
            this.b = wb2Var;
            this.c = kb2Var;
        }

        @Override // com.baidu.tieba.lb2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                cb2.b(this.d.d);
                fb2.i(1);
                eb2.e(this.a.getType(), networkStatus.getStatus(), this.b.e().getStatus(), this.b.g(), this.b.b(), this.b.f(), this.b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.c.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                fb2.g(sb.toString());
                if (cc2.e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.d.h(networkStatus, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(cc2 cc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lb2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                ub2.d().j();
                ib2.d().j();
                cb2.c();
                fb2.i(0);
                eb2.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947669879, "Lcom/baidu/tieba/cc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947669879, "Lcom/baidu/tieba/cc2;");
                return;
            }
        }
        e = nr1.a;
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

    public cc2() {
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
        this.c = ib2.d();
        this.a = new lb2();
        this.b = ub2.d();
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
            if (xo3.I(this.d) && xo3.H()) {
                if (e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                ub2.d().j();
                ib2.d().j();
                kb2 f = this.c.f();
                this.a.a(new a(this, sceneType, this.b.f(), f));
            } else if (e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.d);
            }
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull kb2 kb2Var, @NonNull wb2 wb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, kb2Var, wb2Var) == null) {
            boolean b2 = kb2Var.b();
            int i = R.string.obfuscated_res_0x7f0f1582;
            if (b2) {
                i = R.string.obfuscated_res_0x7f0f1587;
            } else if (wb2Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f1585;
            } else if (wb2Var.e() != RequestStatus.STATUS_FAILED) {
                if (wb2Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f1586 : R.string.obfuscated_res_0x7f0f1583;
                } else if (wb2Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f1584;
                }
            }
            db2.f(i);
        }
    }
}
