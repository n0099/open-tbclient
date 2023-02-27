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
public class fm4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fm4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public fm4() {
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

    public static fm4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (fm4.class) {
                    if (a == null) {
                        a = new fm4();
                    }
                }
            }
            return a;
        }
        return (fm4) invokeV.objValue;
    }

    public static void b(ki4 ki4Var, um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, ki4Var, um4Var) != null) || ki4Var == null) {
            return;
        }
        um4Var.a(ki4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, hh4 hh4Var, hh4 hh4Var2, hh4 hh4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, hh4Var, hh4Var2, hh4Var3) == null) && jSONArray != null && jSONArray.length() != 0) {
            em4 em4Var = new em4();
            em4 em4Var2 = new em4();
            em4 em4Var3 = new em4();
            um4 um4Var = new um4();
            um4 um4Var2 = new um4();
            um4 um4Var3 = new um4();
            gm4 gm4Var = null;
            if (hh4Var3 != null) {
                gm4Var = hh4Var3.w("so");
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
                                                    if (em4Var3.e == null) {
                                                        em4Var3.e = new ArrayList();
                                                    }
                                                    ni4 ni4Var = (ni4) tm4.j(jSONObject2, new ni4());
                                                    b(ni4Var, um4Var3);
                                                    em4Var3.e.add(ni4Var);
                                                }
                                            } else if (gm4Var != null) {
                                                gm4Var.l(jSONObject2);
                                            }
                                        } else {
                                            hi4 hi4Var = (hi4) tm4.j(jSONObject2, new hi4());
                                            if (hi4Var != null) {
                                                b(hi4Var, um4Var2);
                                                em4Var2.c = hi4Var;
                                            }
                                        }
                                    } else {
                                        hi4 hi4Var2 = (hi4) tm4.j(jSONObject2, new hi4());
                                        if (hi4Var2 != null) {
                                            b(hi4Var2, um4Var);
                                            em4Var.c = hi4Var2;
                                        }
                                    }
                                } else {
                                    ji4 ji4Var = (ji4) tm4.j(jSONObject2, new ji4());
                                    if (ji4Var != null) {
                                        b(ji4Var, um4Var2);
                                        em4Var2.a = ji4Var;
                                    }
                                }
                            } else {
                                ji4 ji4Var2 = (ji4) tm4.j(jSONObject2, new ji4());
                                if (ji4Var2 != null) {
                                    b(ji4Var2, um4Var);
                                    em4Var.b = ji4Var2;
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (hh4Var != null) {
                if (um4Var.n() == 0) {
                    hh4Var.F();
                } else {
                    hh4Var.G(um4Var);
                    xi4.e(em4Var, hh4Var);
                }
            }
            if (hh4Var2 != null) {
                if (um4Var2.n() == 0) {
                    hh4Var2.F();
                } else {
                    hh4Var2.G(um4Var2);
                    xi4.e(em4Var2, hh4Var2);
                }
            }
            if (gm4Var != null) {
                gm4Var.o();
            }
            if (um4Var3.n() > 0 && xg4.b() != null) {
                xg4.b().t(em4Var3, um4Var3);
            }
        }
    }
}
