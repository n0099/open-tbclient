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
public class ch4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ch4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ch4() {
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

    public static ch4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ch4.class) {
                    if (a == null) {
                        a = new ch4();
                    }
                }
            }
            return a;
        }
        return (ch4) invokeV.objValue;
    }

    public static void b(hd4 hd4Var, rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, hd4Var, rh4Var) != null) || hd4Var == null) {
            return;
        }
        rh4Var.a(hd4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, ec4 ec4Var, ec4 ec4Var2, ec4 ec4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, ec4Var, ec4Var2, ec4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            bh4 bh4Var = new bh4();
            bh4 bh4Var2 = new bh4();
            bh4 bh4Var3 = new bh4();
            rh4 rh4Var = new rh4();
            rh4 rh4Var2 = new rh4();
            rh4 rh4Var3 = new rh4();
            dh4 dh4Var = null;
            if (ec4Var3 != null) {
                dh4Var = ec4Var3.w("so");
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
                                                    if (bh4Var3.e == null) {
                                                        bh4Var3.e = new ArrayList();
                                                    }
                                                    kd4 kd4Var = (kd4) qh4.j(jSONObject2, new kd4());
                                                    b(kd4Var, rh4Var3);
                                                    bh4Var3.e.add(kd4Var);
                                                }
                                            } else if (dh4Var != null) {
                                                dh4Var.l(jSONObject2);
                                            }
                                        } else {
                                            ed4 ed4Var = (ed4) qh4.j(jSONObject2, new ed4());
                                            if (ed4Var != null) {
                                                b(ed4Var, rh4Var2);
                                                bh4Var2.c = ed4Var;
                                            }
                                        }
                                    } else {
                                        ed4 ed4Var2 = (ed4) qh4.j(jSONObject2, new ed4());
                                        if (ed4Var2 != null) {
                                            b(ed4Var2, rh4Var);
                                            bh4Var.c = ed4Var2;
                                        }
                                    }
                                } else {
                                    gd4 gd4Var = (gd4) qh4.j(jSONObject2, new gd4());
                                    if (gd4Var != null) {
                                        b(gd4Var, rh4Var2);
                                        bh4Var2.a = gd4Var;
                                    }
                                }
                            } else {
                                gd4 gd4Var2 = (gd4) qh4.j(jSONObject2, new gd4());
                                if (gd4Var2 != null) {
                                    b(gd4Var2, rh4Var);
                                    bh4Var.b = gd4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (ec4Var != null) {
                if (rh4Var.n() == 0) {
                    ec4Var.F();
                } else {
                    ec4Var.G(rh4Var);
                    ud4.e(bh4Var, ec4Var);
                }
            }
            if (ec4Var2 != null) {
                if (rh4Var2.n() == 0) {
                    ec4Var2.F();
                } else {
                    ec4Var2.G(rh4Var2);
                    ud4.e(bh4Var2, ec4Var2);
                }
            }
            if (dh4Var != null) {
                dh4Var.o();
            }
            if (rh4Var3.n() > 0 && ub4.b() != null) {
                ub4.b().t(bh4Var3, rh4Var3);
            }
        }
    }
}
