package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ii4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ii4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ii4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ii4.class) {
                    if (a == null) {
                        a = new ii4();
                    }
                }
            }
            return a;
        }
        return (ii4) invokeV.objValue;
    }

    public static void b(ne4 ne4Var, xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ne4Var, xi4Var) != null) || ne4Var == null) {
            return;
        }
        xi4Var.a(ne4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, kd4 kd4Var, kd4 kd4Var2, kd4 kd4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, kd4Var, kd4Var2, kd4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            hi4 hi4Var = new hi4();
            hi4 hi4Var2 = new hi4();
            hi4 hi4Var3 = new hi4();
            xi4 xi4Var = new xi4();
            xi4 xi4Var2 = new xi4();
            xi4 xi4Var3 = new xi4();
            ji4 ji4Var = null;
            if (kd4Var3 != null) {
                ji4Var = kd4Var3.w("so");
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("type");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!TextUtils.isEmpty(jSONObject2.getString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME))) {
                            switch (string.hashCode()) {
                                case -612557761:
                                    if (string.equals(ETAG.KEY_EXTENSION)) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3676:
                                    if (string.equals("so")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 99308:
                                    if (string.equals("ddl")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 54573042:
                                    if (string.equals("extension_game")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 714512640:
                                    if (string.equals("bbasp_core")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 714618195:
                                    if (string.equals("bbasp_game")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c != 3) {
                                            if (c != 4) {
                                                if (c == 5) {
                                                    if (hi4Var3.e == null) {
                                                        hi4Var3.e = new ArrayList();
                                                    }
                                                    qe4 qe4Var = (qe4) wi4.j(jSONObject2, new qe4());
                                                    b(qe4Var, xi4Var3);
                                                    hi4Var3.e.add(qe4Var);
                                                }
                                            } else if (ji4Var != null) {
                                                ji4Var.l(jSONObject2);
                                            }
                                        } else {
                                            ke4 ke4Var = (ke4) wi4.j(jSONObject2, new ke4());
                                            if (ke4Var != null) {
                                                b(ke4Var, xi4Var2);
                                                hi4Var2.c = ke4Var;
                                            }
                                        }
                                    } else {
                                        ke4 ke4Var2 = (ke4) wi4.j(jSONObject2, new ke4());
                                        if (ke4Var2 != null) {
                                            b(ke4Var2, xi4Var);
                                            hi4Var.c = ke4Var2;
                                        }
                                    }
                                } else {
                                    me4 me4Var = (me4) wi4.j(jSONObject2, new me4());
                                    if (me4Var != null) {
                                        b(me4Var, xi4Var2);
                                        hi4Var2.a = me4Var;
                                    }
                                }
                            } else {
                                me4 me4Var2 = (me4) wi4.j(jSONObject2, new me4());
                                if (me4Var2 != null) {
                                    b(me4Var2, xi4Var);
                                    hi4Var.b = me4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (kd4Var != null) {
                if (xi4Var.n() == 0) {
                    kd4Var.F();
                } else {
                    kd4Var.G(xi4Var);
                    af4.e(hi4Var, kd4Var);
                }
            }
            if (kd4Var2 != null) {
                if (xi4Var2.n() == 0) {
                    kd4Var2.F();
                } else {
                    kd4Var2.G(xi4Var2);
                    af4.e(hi4Var2, kd4Var2);
                }
            }
            if (ji4Var != null) {
                ji4Var.o();
            }
            if (xi4Var3.n() > 0 && ad4.b() != null) {
                ad4.b().t(hi4Var3, xi4Var3);
            }
        }
    }
}
