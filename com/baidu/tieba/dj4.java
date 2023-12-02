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
/* loaded from: classes5.dex */
public class dj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dj4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public dj4() {
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

    public static dj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (dj4.class) {
                    if (a == null) {
                        a = new dj4();
                    }
                }
            }
            return a;
        }
        return (dj4) invokeV.objValue;
    }

    public static void b(if4 if4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, if4Var, sj4Var) != null) || if4Var == null) {
            return;
        }
        sj4Var.a(if4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, fe4 fe4Var, fe4 fe4Var2, fe4 fe4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, fe4Var, fe4Var2, fe4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            cj4 cj4Var = new cj4();
            cj4 cj4Var2 = new cj4();
            cj4 cj4Var3 = new cj4();
            sj4 sj4Var = new sj4();
            sj4 sj4Var2 = new sj4();
            sj4 sj4Var3 = new sj4();
            ej4 ej4Var = null;
            if (fe4Var3 != null) {
                ej4Var = fe4Var3.w("so");
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
                                                    if (cj4Var3.e == null) {
                                                        cj4Var3.e = new ArrayList();
                                                    }
                                                    lf4 lf4Var = (lf4) rj4.j(jSONObject2, new lf4());
                                                    b(lf4Var, sj4Var3);
                                                    cj4Var3.e.add(lf4Var);
                                                }
                                            } else if (ej4Var != null) {
                                                ej4Var.l(jSONObject2);
                                            }
                                        } else {
                                            ff4 ff4Var = (ff4) rj4.j(jSONObject2, new ff4());
                                            if (ff4Var != null) {
                                                b(ff4Var, sj4Var2);
                                                cj4Var2.c = ff4Var;
                                            }
                                        }
                                    } else {
                                        ff4 ff4Var2 = (ff4) rj4.j(jSONObject2, new ff4());
                                        if (ff4Var2 != null) {
                                            b(ff4Var2, sj4Var);
                                            cj4Var.c = ff4Var2;
                                        }
                                    }
                                } else {
                                    hf4 hf4Var = (hf4) rj4.j(jSONObject2, new hf4());
                                    if (hf4Var != null) {
                                        b(hf4Var, sj4Var2);
                                        cj4Var2.a = hf4Var;
                                    }
                                }
                            } else {
                                hf4 hf4Var2 = (hf4) rj4.j(jSONObject2, new hf4());
                                if (hf4Var2 != null) {
                                    b(hf4Var2, sj4Var);
                                    cj4Var.b = hf4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (fe4Var != null) {
                if (sj4Var.n() == 0) {
                    fe4Var.F();
                } else {
                    fe4Var.G(sj4Var);
                    vf4.e(cj4Var, fe4Var);
                }
            }
            if (fe4Var2 != null) {
                if (sj4Var2.n() == 0) {
                    fe4Var2.F();
                } else {
                    fe4Var2.G(sj4Var2);
                    vf4.e(cj4Var2, fe4Var2);
                }
            }
            if (ej4Var != null) {
                ej4Var.o();
            }
            if (sj4Var3.n() > 0 && vd4.b() != null) {
                vd4.b().t(cj4Var3, sj4Var3);
            }
        }
    }
}
