package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t53;
import com.baidu.tieba.ye4;
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
/* loaded from: classes5.dex */
public final class a92 extends z82 implements ye4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ik3<a23> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(a92 a92Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a92Var, bVar};
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(a23 a23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a23Var) == null) {
                this.a.onFail(a23Var.Q());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ye4.a, ik3<t53.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ye4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ a92 d;

        public b(a92 a92Var, ye4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a92Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a92Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (a92.b) {
                a92Var.O("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (a92.b) {
                        a92 a92Var = this.d;
                        a92Var.O("IpcHttpCallbackWrapper#onSuccess", "valid=" + e + " statusCode=" + i + " response=" + str);
                    }
                    if (e) {
                        c();
                        this.a.onSuccess(str, i);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (a92.b) {
                        a92 a92Var = this.d;
                        a92Var.O("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e + " url=" + str + " statRecord=" + jSONObject);
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: d */
        public void a(t53.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (a92.b) {
                        a92 a92Var = this.d;
                        a92Var.O("IpcHttpCallbackWrapper#onCallback", "valid=" + e + " msg=" + aVar);
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
                                onSuccess(aVar.n("pms_http_with_ipc_key_response"), aVar.h("pms_http_with_ipc_key_status_code"));
                            }
                        } else {
                            b(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), pi3.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (a92.b) {
                        a92 a92Var = this.d;
                        a92Var.O("IpcHttpCallbackWrapper#onFail", "valid=" + e + " exception=" + exc);
                    }
                    if (e) {
                        c();
                        ye4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (a92.b) {
                        a92 a92Var = this.d;
                        a92Var.O("IpcHttpCallbackWrapper#onStart", "valid=" + e);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947569935, "Lcom/baidu/tieba/a92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947569935, "Lcom/baidu/tieba/a92;");
                return;
            }
        }
        b = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a92(u53 u53Var) {
        super(u53Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u53Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o53) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void M(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar) {
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
            a23 z = b23.Q("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            a23 z2 = z.z("pms_http_with_ipc_key_url", str2);
            if (!TextUtils.isEmpty(jSONObject2)) {
                str3 = jSONObject2;
            }
            a23 u = z2.z("pms_http_with_ipc_keyjson_body", str3).u("pms_http_with_ipc_key_url_param_map", z82.J(map)).u("pms_http_with_ipc_key_header_param_map", z82.J(map2));
            u.L(true);
            u.H(bVar);
            u.G(new a(this, bVar));
            if (b) {
                O("ipcHttp", "session=" + u);
            }
            u.N(d92.m0);
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

    @Override // com.baidu.tieba.z82, com.baidu.tieba.ye4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                N("buildJsonPostRequest");
            }
            M("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.z82, com.baidu.tieba.ye4
    public void z(String str, Map<String, String> map, Map<String, String> map2, ye4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                N("buildGetRequest");
            }
            String b2 = pz2.b();
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
