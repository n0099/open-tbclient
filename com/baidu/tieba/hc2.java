package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
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
import java.util.Locale;
/* loaded from: classes6.dex */
public class hc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final pb2 a;
    public final yb2 b;
    public final mb2 c;
    public SceneType d;

    /* loaded from: classes6.dex */
    public class a implements pb2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ac2 a;
        public final /* synthetic */ ob2 b;
        public final /* synthetic */ hc2 c;

        public a(hc2 hc2Var, ac2 ac2Var, ob2 ob2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc2Var, ac2Var, ob2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hc2Var;
            this.a = ac2Var;
            this.b = ob2Var;
        }

        @Override // com.baidu.tieba.pb2.b
        public void a(NetworkStatus networkStatus) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                ib2.e(this.c.d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = bi2.U().m0();
                long n = ou2.g0().n();
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
                if (hc2.e) {
                    Log.d("SceneWhiteScreenTips", ">> " + sb.toString());
                }
                jb2.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947818834, "Lcom/baidu/tieba/hc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947818834, "Lcom/baidu/tieba/hc2;");
                return;
            }
        }
        e = rr1.a;
    }

    public hc2() {
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
        this.c = mb2.d();
        this.a = new pb2();
        this.b = yb2.d();
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
            if (wb2.b().c()) {
                if (e) {
                    Log.d("SceneWhiteScreenTips", ">> start to recheck white screen.");
                }
                wb2.b().h(ub2.b(str, 3000L));
                wb2.b().f();
                return;
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> no need to recheck white screen.");
            }
            if (e) {
                Log.d("SceneWhiteScreenTips", ">> start handle white screen tips.");
            }
            yb2.d().j();
            mb2.d().j();
            wb2.b().j(true);
            ob2 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull ob2 ob2Var, @NonNull ac2 ac2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, ob2Var, ac2Var) == null) {
            boolean b = ob2Var.b();
            int i = R.string.obfuscated_res_0x7f0f159b;
            if (b) {
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
