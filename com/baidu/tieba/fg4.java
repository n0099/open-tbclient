package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public fg4() {
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

    public static fg4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (fg4.class) {
                    if (a == null) {
                        a = new fg4();
                    }
                }
            }
            return a;
        }
        return (fg4) invokeV.objValue;
    }

    public static void b(kc4 kc4Var, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, kc4Var, ug4Var) != null) || kc4Var == null) {
            return;
        }
        ug4Var.a(kc4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, hb4 hb4Var, hb4 hb4Var2, hb4 hb4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, hb4Var, hb4Var2, hb4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            eg4 eg4Var = new eg4();
            eg4 eg4Var2 = new eg4();
            eg4 eg4Var3 = new eg4();
            ug4 ug4Var = new ug4();
            ug4 ug4Var2 = new ug4();
            ug4 ug4Var3 = new ug4();
            gg4 gg4Var = null;
            if (hb4Var3 != null) {
                gg4Var = hb4Var3.w("so");
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("type");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
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
                                                    if (eg4Var3.e == null) {
                                                        eg4Var3.e = new ArrayList();
                                                    }
                                                    nc4 nc4Var = (nc4) tg4.j(jSONObject2, new nc4());
                                                    b(nc4Var, ug4Var3);
                                                    eg4Var3.e.add(nc4Var);
                                                }
                                            } else if (gg4Var != null) {
                                                gg4Var.l(jSONObject2);
                                            }
                                        } else {
                                            hc4 hc4Var = (hc4) tg4.j(jSONObject2, new hc4());
                                            if (hc4Var != null) {
                                                b(hc4Var, ug4Var2);
                                                eg4Var2.c = hc4Var;
                                            }
                                        }
                                    } else {
                                        hc4 hc4Var2 = (hc4) tg4.j(jSONObject2, new hc4());
                                        if (hc4Var2 != null) {
                                            b(hc4Var2, ug4Var);
                                            eg4Var.c = hc4Var2;
                                        }
                                    }
                                } else {
                                    jc4 jc4Var = (jc4) tg4.j(jSONObject2, new jc4());
                                    if (jc4Var != null) {
                                        b(jc4Var, ug4Var2);
                                        eg4Var2.a = jc4Var;
                                    }
                                }
                            } else {
                                jc4 jc4Var2 = (jc4) tg4.j(jSONObject2, new jc4());
                                if (jc4Var2 != null) {
                                    b(jc4Var2, ug4Var);
                                    eg4Var.b = jc4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (hb4Var != null) {
                if (ug4Var.n() == 0) {
                    hb4Var.F();
                } else {
                    hb4Var.G(ug4Var);
                    xc4.e(eg4Var, hb4Var);
                }
            }
            if (hb4Var2 != null) {
                if (ug4Var2.n() == 0) {
                    hb4Var2.F();
                } else {
                    hb4Var2.G(ug4Var2);
                    xc4.e(eg4Var2, hb4Var2);
                }
            }
            if (gg4Var != null) {
                gg4Var.o();
            }
            if (ug4Var3.n() > 0 && xa4.b() != null) {
                xa4.b().t(eg4Var3, ug4Var3);
            }
        }
    }
}
