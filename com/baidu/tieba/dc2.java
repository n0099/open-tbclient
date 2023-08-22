package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
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
import java.util.Locale;
/* loaded from: classes5.dex */
public class dc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final lb2 a;
    public final ub2 b;
    public final ib2 c;
    public SceneType d;

    /* loaded from: classes5.dex */
    public class a implements lb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb2 a;
        public final /* synthetic */ kb2 b;
        public final /* synthetic */ dc2 c;

        public a(dc2 dc2Var, wb2 wb2Var, kb2 kb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc2Var, wb2Var, kb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dc2Var;
            this.a = wb2Var;
            this.b = kb2Var;
        }

        @Override // com.baidu.tieba.lb2.b
        public void a(NetworkStatus networkStatus) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                eb2.e(this.c.d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = xh2.U().m0();
                long n = ku2.g0().n();
                if (n >= LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION || m0) {
                    this.c.f(networkStatus, this.b, this.a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.c.d.getScene());
                sb.append(String.format(Locale.getDefault(), "%d秒截屏；", Long.valueOf(n / 1000)));
                if (m0) {
                    str = "框架预加载：已完成；";
                } else {
                    str = "框架预加载：未完成；";
                }
                sb.append(str);
                sb.append(this.b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (dc2.e) {
                    Log.d("SceneWhiteScreenTips", ">> " + sb.toString());
                }
                fb2.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699670, "Lcom/baidu/tieba/dc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699670, "Lcom/baidu/tieba/dc2;");
                return;
            }
        }
        e = nr1.a;
    }

    public dc2() {
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
        this.d = SceneType.SCENE_WHITE_SCREEN_L1;
        this.c = ib2.d();
        this.a = new lb2();
        this.b = ub2.d();
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.d = sceneType;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (sb2.b().c()) {
                if (e) {
                    Log.d("SceneWhiteScreenTips", ">> start to recheck white screen.");
                }
                sb2.b().h(qb2.b(str, 3000L));
                sb2.b().f();
                return;
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> no need to recheck white screen.");
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> start handle white screen tips.");
            }
            ub2.d().j();
            ib2.d().j();
            sb2.b().j(true);
            kb2 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull kb2 kb2Var, @NonNull wb2 wb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, kb2Var, wb2Var) == null) {
            boolean b = kb2Var.b();
            int i = R.string.obfuscated_res_0x7f0f1582;
            if (b) {
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
