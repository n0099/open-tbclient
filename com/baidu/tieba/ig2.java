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
/* loaded from: classes6.dex */
public class ig2 implements jg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<lg2> a;
    public boolean b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-719537384, "Lcom/baidu/tieba/ig2$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-719537384, "Lcom/baidu/tieba/ig2$a;");
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

    public ig2() {
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
        m43.q(PrefetchEvent.MODULE, str).F(ubcFlowEvent);
    }

    public void d(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, str, z) != null) || !b(str)) {
            return;
        }
        HybridUbcFlow q = m43.q(PrefetchEvent.MODULE, str);
        if (z) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        q.E("value", str2);
    }

    public void e(String str, lg2 lg2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, lg2Var) != null) || !b(str)) {
            return;
        }
        c(m43.q(PrefetchEvent.MODULE, str), lg2Var);
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
        m43.s(PrefetchEvent.MODULE, str);
        m43.q(PrefetchEvent.MODULE, str);
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && b(str) && !this.b) {
            this.b = true;
            HybridUbcFlow q = m43.q(PrefetchEvent.MODULE, str);
            g(q);
            q.A();
            m43.s(PrefetchEvent.MODULE, str);
        }
    }

    public final void c(HybridUbcFlow hybridUbcFlow, lg2 lg2Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow, lg2Var) == null) && hybridUbcFlow != null && lg2Var != null) {
            switch (a.a[lg2Var.a.ordinal()]) {
                case 1:
                    hybridUbcFlow.D("app_id", lg2Var.b);
                    return;
                case 2:
                    hybridUbcFlow.D("app_version", lg2Var.b);
                    return;
                case 3:
                    if (lg2Var.c) {
                        str = "hot";
                    } else {
                        str = "cold";
                    }
                    hybridUbcFlow.E("type", str);
                    return;
                case 4:
                    hybridUbcFlow.E("source", lg2Var.b);
                    return;
                case 5:
                    hybridUbcFlow.D("msg", lg2Var.b);
                    return;
                case 6:
                    synchronized (this.a) {
                        this.a.add(lg2Var);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void g(HybridUbcFlow hybridUbcFlow) {
        List<lg2> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, hybridUbcFlow) == null) && hybridUbcFlow != null && (list = this.a) != null && list.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                try {
                    for (lg2 lg2Var : this.a) {
                        String str2 = lg2Var.b;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", str2);
                        if (lg2Var.c) {
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
