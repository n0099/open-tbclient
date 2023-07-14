package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.el4;
import com.baidu.tieba.zb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gf2 extends ff2 implements el4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements oq3<g83> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(gf2 gf2Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(g83 g83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g83Var) == null) {
                this.a.onFail(g83Var.N());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements el4.a, oq3<zb3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final el4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ gf2 d;

        public b(gf2 gf2Var, el4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gf2Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (gf2.b) {
                gf2Var.O("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.baidu.tieba.el4.a
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (gf2.b) {
                        gf2 gf2Var = this.d;
                        gf2Var.O("IpcHttpCallbackWrapper#onSuccess", "valid=" + e + " statusCode=" + i + " response=" + str);
                    }
                    if (e) {
                        c();
                        this.a.onSuccess(str, i);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.el4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (gf2.b) {
                        gf2 gf2Var = this.d;
                        gf2Var.O("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e) {
                        this.a.b(str, str2, jSONObject);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.c = true;
                }
            }
        }

        public synchronized boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.b) {
                        if (!this.c) {
                            z = true;
                        }
                    }
                    z = false;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: d */
        public void a(zb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (gf2.b) {
                        gf2 gf2Var = this.d;
                        gf2Var.O("IpcHttpCallbackWrapper#onCallback", "valid=" + e + " msg=" + aVar);
                    }
                    if (e) {
                        String o = aVar.o("pms_http_with_ipc_key_action", "");
                        char c = 65535;
                        switch (o.hashCode()) {
                            case -2080875416:
                                if (o.equals("pms_http_with_ipc_action_success")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -898655015:
                                if (o.equals("pms_http_with_ipc_action_fail")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -480804291:
                                if (o.equals("pms_http_with_ipc_action_on_start")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1737801345:
                                if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c != 0) {
                            if (c != 1) {
                                if (c != 2) {
                                    if (c == 3) {
                                        onStart();
                                    }
                                } else {
                                    onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                                }
                            } else {
                                onSuccess(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                            }
                        } else {
                            b(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), vo3.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.el4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (gf2.b) {
                        gf2 gf2Var = this.d;
                        gf2Var.O("IpcHttpCallbackWrapper#onFail", "valid=" + e + " exception=" + exc);
                    }
                    if (e) {
                        c();
                        el4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.el4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (gf2.b) {
                        gf2 gf2Var = this.d;
                        gf2Var.O("IpcHttpCallbackWrapper#onStart", "valid=" + e);
                    }
                    if (e) {
                        this.a.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791926, "Lcom/baidu/tieba/gf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791926, "Lcom/baidu/tieba/gf2;");
                return;
            }
        }
        b = fs1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf2(ac3 ac3Var) {
        super(ac3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ub3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void M(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, el4.a aVar) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (b) {
                N("ipcHttp");
            }
            String str3 = "";
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            b bVar = new b(this, aVar);
            g83 z = h83.Q("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            g83 z2 = z.z("pms_http_with_ipc_key_url", str2);
            if (!TextUtils.isEmpty(jSONObject2)) {
                str3 = jSONObject2;
            }
            g83 u = z2.z("pms_http_with_ipc_keyjson_body", str3).u("pms_http_with_ipc_key_url_param_map", ff2.J(map)).u("pms_http_with_ipc_key_header_param_map", ff2.J(map2));
            u.K(true);
            u.G(bVar);
            u.F(new a(this, bVar));
            if (b) {
                O("ipcHttp", "session=" + u);
            }
            u.call(jf2.m0);
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b) {
            Log.i("PmsHttpForClient", str);
        }
    }

    public final void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            N(str + ": " + str2);
        }
    }

    @Override // com.baidu.tieba.ff2, com.baidu.tieba.el4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, el4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                N("buildJsonPostRequest");
            }
            M("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.ff2, com.baidu.tieba.el4
    public void z(String str, Map<String, String> map, Map<String, String> map2, el4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                N("buildGetRequest");
            }
            String b2 = v53.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            M("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        }
    }
}
