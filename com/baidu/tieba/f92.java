package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f92 implements g92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<i92> a;
    public boolean b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-847906803, "Lcom/baidu/tieba/f92$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-847906803, "Lcom/baidu/tieba/f92$a;");
                    return;
                }
            }
            int[] iArr = new int[RecordType.values().length];
            a = iArr;
            try {
                iArr[RecordType.APP_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RecordType.APP_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RecordType.PREFETCH_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RecordType.PREFETCH_EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RecordType.PREFETCH_OTHER_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RecordType.PREFETCH_PRELINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f92() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = false;
    }

    public void a(String str, UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, ubcFlowEvent) != null) || !b(str)) {
            return;
        }
        jx2.q(PrefetchEvent.MODULE, str).F(ubcFlowEvent);
    }

    public void d(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, str, z) != null) || !b(str)) {
            return;
        }
        HybridUbcFlow q = jx2.q(PrefetchEvent.MODULE, str);
        if (z) {
            str2 = "success";
        } else {
            str2 = com.baidu.pass.biometrics.face.liveness.b.a.g0;
        }
        q.E("value", str2);
    }

    public void e(String str, i92 i92Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, i92Var) != null) || !b(str)) {
            return;
        }
        c(jx2.q(PrefetchEvent.MODULE, str), i92Var);
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return !TextUtils.isEmpty(str);
        }
        return invokeL.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || !b(str)) {
            return;
        }
        jx2.s(PrefetchEvent.MODULE, str);
        jx2.q(PrefetchEvent.MODULE, str);
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && b(str) && !this.b) {
            this.b = true;
            HybridUbcFlow q = jx2.q(PrefetchEvent.MODULE, str);
            g(q);
            q.A();
            jx2.s(PrefetchEvent.MODULE, str);
        }
    }

    public final void c(HybridUbcFlow hybridUbcFlow, i92 i92Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow, i92Var) == null) && hybridUbcFlow != null && i92Var != null) {
            switch (a.a[i92Var.a.ordinal()]) {
                case 1:
                    hybridUbcFlow.D("app_id", i92Var.b);
                    return;
                case 2:
                    hybridUbcFlow.D("app_version", i92Var.b);
                    return;
                case 3:
                    if (i92Var.c) {
                        str = "hot";
                    } else {
                        str = "cold";
                    }
                    hybridUbcFlow.E("type", str);
                    return;
                case 4:
                    hybridUbcFlow.E("source", i92Var.b);
                    return;
                case 5:
                    hybridUbcFlow.D("msg", i92Var.b);
                    return;
                case 6:
                    synchronized (this.a) {
                        this.a.add(i92Var);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void g(HybridUbcFlow hybridUbcFlow) {
        List<i92> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, hybridUbcFlow) == null) && hybridUbcFlow != null && (list = this.a) != null && list.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                try {
                    for (i92 i92Var : this.a) {
                        String str2 = i92Var.b;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", str2);
                        if (i92Var.c) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        jSONObject2.put("link", str);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("links", jSONArray);
                } catch (JSONException unused) {
                }
                this.a.clear();
            }
            if (jSONObject.length() > 0) {
                hybridUbcFlow.D("prelink", jSONObject.toString());
            }
        }
    }
}
