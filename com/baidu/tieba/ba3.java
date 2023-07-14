package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ba3 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static boolean b;
    public static final ba3 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638197, "Lcom/baidu/tieba/ba3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638197, "Lcom/baidu/tieba/ba3;");
                return;
            }
        }
        c = new ba3();
    }

    public ba3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return a;
        }
        return (a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static final class b<MsgType> implements oq3<yg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-925452745, "Lcom/baidu/tieba/ba3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-925452745, "Lcom/baidu/tieba/ba3$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public final void a(yg3<JSONObject> it) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject2 = it.a;
                    if (jSONObject2 != null) {
                        jSONObject = jSONObject2.optJSONObject("data");
                    } else {
                        jSONObject = null;
                    }
                    a b = ba3.c.b();
                    if (jSONObject != null) {
                        String openId = jSONObject.optString("openid");
                        if (b == null || !ProcessUtils.isMainProcess()) {
                            ba3.c.d(null, openId);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(openId, "openId");
                        ub3 K = ub3.K();
                        Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
                        String appId = K.getAppId();
                        hx1 n = cv2.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b.a(openId, appId, n.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<MsgType> implements oq3<yg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-925452714, "Lcom/baidu/tieba/ba3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-925452714, "Lcom/baidu/tieba/ba3$c;");
                    return;
                }
            }
            a = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public final void a(yg3<JSONObject> it) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject2 = it.a;
                    if (jSONObject2 != null) {
                        jSONObject = jSONObject2.optJSONObject("data");
                    } else {
                        jSONObject = null;
                    }
                    a b = ba3.c.b();
                    if (jSONObject != null) {
                        String swanId = jSONObject.optString("swanid");
                        if (b == null || !ProcessUtils.isMainProcess()) {
                            ba3.c.d(swanId, null);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(swanId, "swanId");
                        ub3 K = ub3.K();
                        Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
                        String appId = K.getAppId();
                        hx1 n = cv2.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b.b(swanId, appId, n.a());
                    }
                }
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ub3 K = ub3.K();
            Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
            q83 y = K.y();
            if (y != null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanId", str);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                ub3 K2 = ub3.K();
                Intrinsics.checkNotNullExpressionValue(K2, "Swan.get()");
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, K2.getAppId());
                hx1 n = cv2.n();
                Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                bundle.putString("hostName", n.a());
                y.W(bundle, aa3.class);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ub3 K = ub3.K();
            Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
            ys1 x = K.x();
            Intrinsics.checkNotNullExpressionValue(x, "Swan.get().adaptationProducer");
            ch3 f = x.a().b().f(ub3.K());
            f.o(b.a);
            f.call();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ub3 K = ub3.K();
            Intrinsics.checkNotNullExpressionValue(K, "Swan.get()");
            ys1 x = K.x();
            Intrinsics.checkNotNullExpressionValue(x, "Swan.get().adaptationProducer");
            dh3 e = x.a().b().e(ub3.K());
            e.o(c.a);
            e.call();
        }
    }
}
