package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dh4;
import com.baidu.tieba.y73;
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
/* loaded from: classes4.dex */
public final class fb2 extends eb2 implements dh4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements nm3<f43> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(fb2 fb2Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, bVar};
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
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(f43 f43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f43Var) == null) {
                this.a.onFail(f43Var.N());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dh4.a, nm3<y73.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final dh4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ fb2 d;

        public b(fb2 fb2Var, dh4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fb2Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (fb2.b) {
                fb2Var.O("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.baidu.tieba.dh4.a
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (fb2.b) {
                        fb2 fb2Var = this.d;
                        fb2Var.O("IpcHttpCallbackWrapper#onSuccess", "valid=" + f + " statusCode=" + i + " response=" + str);
                    }
                    if (f) {
                        d();
                        this.a.c(str, i);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.dh4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (fb2.b) {
                        fb2 fb2Var = this.d;
                        fb2Var.O("IpcHttpCallbackWrapper#onStatRecord", "valid=" + f + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (f) {
                        this.a.b(str, str2, jSONObject);
                    }
                }
            }
        }

        public synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.c = true;
                }
            }
        }

        public synchronized boolean f() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        @Override // com.baidu.tieba.nm3
        /* renamed from: e */
        public void a(y73.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (fb2.b) {
                        fb2 fb2Var = this.d;
                        fb2Var.O("IpcHttpCallbackWrapper#onCallback", "valid=" + f + " msg=" + aVar);
                    }
                    if (f) {
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
                                c(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                            }
                        } else {
                            b(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), uk3.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.dh4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (fb2.b) {
                        fb2 fb2Var = this.d;
                        fb2Var.O("IpcHttpCallbackWrapper#onFail", "valid=" + f + " exception=" + exc);
                    }
                    if (f) {
                        d();
                        dh4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.dh4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean f = f();
                    if (fb2.b) {
                        fb2 fb2Var = this.d;
                        fb2Var.O("IpcHttpCallbackWrapper#onStart", "valid=" + f);
                    }
                    if (f) {
                        this.a.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758291, "Lcom/baidu/tieba/fb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758291, "Lcom/baidu/tieba/fb2;");
                return;
            }
        }
        b = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb2(z73 z73Var) {
        super(z73Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z73Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t73) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void M(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, dh4.a aVar) {
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
            f43 z = g43.Q("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            f43 z2 = z.z("pms_http_with_ipc_key_url", str2);
            if (!TextUtils.isEmpty(jSONObject2)) {
                str3 = jSONObject2;
            }
            f43 u = z2.z("pms_http_with_ipc_keyjson_body", str3).u("pms_http_with_ipc_key_url_param_map", eb2.J(map)).u("pms_http_with_ipc_key_header_param_map", eb2.J(map2));
            u.K(true);
            u.G(bVar);
            u.F(new a(this, bVar));
            if (b) {
                O("ipcHttp", "session=" + u);
            }
            u.call(ib2.m0);
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

    @Override // com.baidu.tieba.eb2, com.baidu.tieba.dh4
    public void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, dh4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                N("buildJsonPostRequest");
            }
            M("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.baidu.tieba.eb2, com.baidu.tieba.dh4
    public void z(String str, Map<String, String> map, Map<String, String> map2, dh4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                N("buildGetRequest");
            }
            String b2 = u13.b();
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
