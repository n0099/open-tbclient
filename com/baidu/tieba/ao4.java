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
public class ao4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ao4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ao4() {
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

    public static ao4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ao4.class) {
                    if (a == null) {
                        a = new ao4();
                    }
                }
            }
            return a;
        }
        return (ao4) invokeV.objValue;
    }

    public static void b(fk4 fk4Var, po4 po4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, fk4Var, po4Var) != null) || fk4Var == null) {
            return;
        }
        po4Var.a(fk4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, cj4 cj4Var, cj4 cj4Var2, cj4 cj4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, cj4Var, cj4Var2, cj4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            zn4 zn4Var = new zn4();
            zn4 zn4Var2 = new zn4();
            zn4 zn4Var3 = new zn4();
            po4 po4Var = new po4();
            po4 po4Var2 = new po4();
            po4 po4Var3 = new po4();
            bo4 bo4Var = null;
            if (cj4Var3 != null) {
                bo4Var = cj4Var3.w("so");
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
                                                    if (zn4Var3.e == null) {
                                                        zn4Var3.e = new ArrayList();
                                                    }
                                                    ik4 ik4Var = (ik4) oo4.j(jSONObject2, new ik4());
                                                    b(ik4Var, po4Var3);
                                                    zn4Var3.e.add(ik4Var);
                                                }
                                            } else if (bo4Var != null) {
                                                bo4Var.l(jSONObject2);
                                            }
                                        } else {
                                            ck4 ck4Var = (ck4) oo4.j(jSONObject2, new ck4());
                                            if (ck4Var != null) {
                                                b(ck4Var, po4Var2);
                                                zn4Var2.c = ck4Var;
                                            }
                                        }
                                    } else {
                                        ck4 ck4Var2 = (ck4) oo4.j(jSONObject2, new ck4());
                                        if (ck4Var2 != null) {
                                            b(ck4Var2, po4Var);
                                            zn4Var.c = ck4Var2;
                                        }
                                    }
                                } else {
                                    ek4 ek4Var = (ek4) oo4.j(jSONObject2, new ek4());
                                    if (ek4Var != null) {
                                        b(ek4Var, po4Var2);
                                        zn4Var2.a = ek4Var;
                                    }
                                }
                            } else {
                                ek4 ek4Var2 = (ek4) oo4.j(jSONObject2, new ek4());
                                if (ek4Var2 != null) {
                                    b(ek4Var2, po4Var);
                                    zn4Var.b = ek4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (cj4Var != null) {
                if (po4Var.n() == 0) {
                    cj4Var.F();
                } else {
                    cj4Var.G(po4Var);
                    sk4.e(zn4Var, cj4Var);
                }
            }
            if (cj4Var2 != null) {
                if (po4Var2.n() == 0) {
                    cj4Var2.F();
                } else {
                    cj4Var2.G(po4Var2);
                    sk4.e(zn4Var2, cj4Var2);
                }
            }
            if (bo4Var != null) {
                bo4Var.o();
            }
            if (po4Var3.n() > 0 && si4.b() != null) {
                si4.b().t(zn4Var3, po4Var3);
            }
        }
    }
}
