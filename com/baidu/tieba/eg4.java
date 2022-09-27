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
/* loaded from: classes3.dex */
public class eg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public eg4() {
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

    public static eg4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (eg4.class) {
                    if (a == null) {
                        a = new eg4();
                    }
                }
            }
            return a;
        }
        return (eg4) invokeV.objValue;
    }

    public static void b(jc4 jc4Var, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jc4Var, tg4Var) == null) || jc4Var == null) {
            return;
        }
        tg4Var.a(jc4Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, gb4 gb4Var, gb4 gb4Var2, gb4 gb4Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, gb4Var, gb4Var2, gb4Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        dg4 dg4Var = new dg4();
        dg4 dg4Var2 = new dg4();
        dg4 dg4Var3 = new dg4();
        tg4 tg4Var = new tg4();
        tg4 tg4Var2 = new tg4();
        tg4 tg4Var3 = new tg4();
        fg4 w = gb4Var3 != null ? gb4Var3.w("so") : null;
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
                        if (c == 0) {
                            ic4 ic4Var = (ic4) sg4.j(jSONObject2, new ic4());
                            if (ic4Var != null) {
                                b(ic4Var, tg4Var);
                                dg4Var.b = ic4Var;
                            }
                        } else if (c == 1) {
                            ic4 ic4Var2 = (ic4) sg4.j(jSONObject2, new ic4());
                            if (ic4Var2 != null) {
                                b(ic4Var2, tg4Var2);
                                dg4Var2.a = ic4Var2;
                            }
                        } else if (c == 2) {
                            gc4 gc4Var = (gc4) sg4.j(jSONObject2, new gc4());
                            if (gc4Var != null) {
                                b(gc4Var, tg4Var);
                                dg4Var.c = gc4Var;
                            }
                        } else if (c == 3) {
                            gc4 gc4Var2 = (gc4) sg4.j(jSONObject2, new gc4());
                            if (gc4Var2 != null) {
                                b(gc4Var2, tg4Var2);
                                dg4Var2.c = gc4Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (dg4Var3.e == null) {
                                    dg4Var3.e = new ArrayList();
                                }
                                mc4 mc4Var = (mc4) sg4.j(jSONObject2, new mc4());
                                b(mc4Var, tg4Var3);
                                dg4Var3.e.add(mc4Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (gb4Var != null) {
            if (tg4Var.n() == 0) {
                gb4Var.F();
            } else {
                gb4Var.G(tg4Var);
                wc4.e(dg4Var, gb4Var);
            }
        }
        if (gb4Var2 != null) {
            if (tg4Var2.n() == 0) {
                gb4Var2.F();
            } else {
                gb4Var2.G(tg4Var2);
                wc4.e(dg4Var2, gb4Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (tg4Var3.n() <= 0 || wa4.b() == null) {
            return;
        }
        wa4.b().t(dg4Var3, tg4Var3);
    }
}
