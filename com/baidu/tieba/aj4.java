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
public class aj4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aj4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public aj4() {
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

    public static aj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (aj4.class) {
                    if (a == null) {
                        a = new aj4();
                    }
                }
            }
            return a;
        }
        return (aj4) invokeV.objValue;
    }

    public static void b(ff4 ff4Var, pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ff4Var, pj4Var) != null) || ff4Var == null) {
            return;
        }
        pj4Var.a(ff4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, ce4 ce4Var, ce4 ce4Var2, ce4 ce4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, ce4Var, ce4Var2, ce4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            zi4 zi4Var = new zi4();
            zi4 zi4Var2 = new zi4();
            zi4 zi4Var3 = new zi4();
            pj4 pj4Var = new pj4();
            pj4 pj4Var2 = new pj4();
            pj4 pj4Var3 = new pj4();
            bj4 bj4Var = null;
            if (ce4Var3 != null) {
                bj4Var = ce4Var3.w("so");
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
                                                    if (zi4Var3.e == null) {
                                                        zi4Var3.e = new ArrayList();
                                                    }
                                                    if4 if4Var = (if4) oj4.j(jSONObject2, new if4());
                                                    b(if4Var, pj4Var3);
                                                    zi4Var3.e.add(if4Var);
                                                }
                                            } else if (bj4Var != null) {
                                                bj4Var.l(jSONObject2);
                                            }
                                        } else {
                                            cf4 cf4Var = (cf4) oj4.j(jSONObject2, new cf4());
                                            if (cf4Var != null) {
                                                b(cf4Var, pj4Var2);
                                                zi4Var2.c = cf4Var;
                                            }
                                        }
                                    } else {
                                        cf4 cf4Var2 = (cf4) oj4.j(jSONObject2, new cf4());
                                        if (cf4Var2 != null) {
                                            b(cf4Var2, pj4Var);
                                            zi4Var.c = cf4Var2;
                                        }
                                    }
                                } else {
                                    ef4 ef4Var = (ef4) oj4.j(jSONObject2, new ef4());
                                    if (ef4Var != null) {
                                        b(ef4Var, pj4Var2);
                                        zi4Var2.a = ef4Var;
                                    }
                                }
                            } else {
                                ef4 ef4Var2 = (ef4) oj4.j(jSONObject2, new ef4());
                                if (ef4Var2 != null) {
                                    b(ef4Var2, pj4Var);
                                    zi4Var.b = ef4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (ce4Var != null) {
                if (pj4Var.n() == 0) {
                    ce4Var.F();
                } else {
                    ce4Var.G(pj4Var);
                    sf4.e(zi4Var, ce4Var);
                }
            }
            if (ce4Var2 != null) {
                if (pj4Var2.n() == 0) {
                    ce4Var2.F();
                } else {
                    ce4Var2.G(pj4Var2);
                    sf4.e(zi4Var2, ce4Var2);
                }
            }
            if (bj4Var != null) {
                bj4Var.o();
            }
            if (pj4Var3.n() > 0 && sd4.b() != null) {
                sd4.b().t(zi4Var3, pj4Var3);
            }
        }
    }
}
