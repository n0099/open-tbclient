package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sq2;
import com.baidu.tieba.t53;
import com.baidu.tieba.ye4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c92 extends z82 implements ye4, ik3<t53.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar);
    }

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c92 a;

        public a(c92 c92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c92Var;
        }

        @Override // com.baidu.tieba.c92.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.z(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c92 a;

        public b(c92 c92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c92Var;
        }

        @Override // com.baidu.tieba.c92.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ye4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.b(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ye4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ c92 b;

        public c(c92 c92Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c92Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c92Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.ye4.a
        public void b(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, jSONObject) != null) {
                return;
            }
            this.b.P(this.a, "pms_http_with_ipc_action_stat_record", new sq2.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
        }

        @Override // com.baidu.tieba.ye4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c92 c92Var = this.b;
                String str = this.a;
                c92Var.Q(str, "http: " + exc);
                if (c92.b) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_on_start", null);
            }
        }

        @Override // com.baidu.tieba.ye4.a
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
                this.b.P(this.a, "pms_http_with_ipc_action_success", new sq2.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sq2.a c;
        public final /* synthetic */ c92 d;

        public d(c92 c92Var, String str, String str2, sq2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c92Var, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = c92Var;
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b23.K(this.a, "pms_http_with_ipc")) {
                    if (!c92.b) {
                        return;
                    }
                    this.d.T("callbackIpcSession", "return by topic pms_http_with_ipc");
                    return;
                }
                a23 z = b23.a0(this.a).z("pms_http_with_ipc_key_action", this.b);
                sq2.a aVar = this.c;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (c92.b) {
                    c92 c92Var = this.d;
                    c92Var.T("callbackIpcSession", "ipcSession= " + z);
                }
                z.M();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629517, "Lcom/baidu/tieba/c92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629517, "Lcom/baidu/tieba/c92;");
                return;
            }
        }
        b = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c92(w53 w53Var) {
        super(w53Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w53Var};
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
        m53 m53Var = new m53();
        m53Var.f(this, "event_messenger_call");
        u(m53Var);
    }

    public final void O(String str, @NonNull t53.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (b) {
                T("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (!b23.K(str, "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("pms_http_with_ipc_key_url");
            Map<String, String> I = z82.I(aVar.e("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> I2 = z82.I(aVar.e("pms_http_with_ipc_key_header_param_map"));
            String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(n2)) {
                    jSONObject = new JSONObject(n2);
                }
            } catch (JSONException e2) {
                if (b) {
                    e2.printStackTrace();
                }
            }
            try {
                eVar.a(n, I, I2, jSONObject, new c(this, str));
            } catch (Exception e3) {
                Q(str, "catch: " + e3);
                if (b) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void P(String str, String str2, sq2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (b) {
                T("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            jj3.e0(new d(this, str, str2, aVar));
        }
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            P(str, "pms_http_with_ipc_action_fail", new sq2.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    public final void R(t53.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (b) {
                T("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar != null && b23.J(aVar.D(), "pms_http_with_ipc")) {
                String n = aVar.n("ipc_session_id");
                if (b) {
                    T("handleIpcMsg", "session=" + n);
                }
                if (TextUtils.isEmpty(n)) {
                    return;
                }
                String n2 = aVar.n("pms_http_with_ipc_key_action");
                if (b) {
                    T("handleIpcMsg", "action=" + n2);
                }
                if (TextUtils.isEmpty(n2)) {
                    Q(n, "empty action");
                    return;
                }
                char c2 = 65535;
                int hashCode = n2.hashCode();
                if (hashCode != 646251642) {
                    if (hashCode == 1779116731 && n2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                        c2 = 1;
                    }
                } else if (n2.equals("pms_http_with_ipc_action_build_get_request")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        Q(n, "no such action:" + n2);
                        return;
                    }
                    O(n, aVar, new b(this));
                    return;
                }
                O(n, aVar, new a(this));
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && b) {
            Log.i("PmsHttpForService", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ik3
    /* renamed from: U */
    public void a(t53.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            R(aVar);
        }
    }
}
