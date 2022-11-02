package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (an3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            pn3 m = gn3.l().m();
            if (m == null) {
                if (an3.a) {
                    Log.d("BDTLS", "bdtls ubc data is null");
                    return;
                }
                return;
            }
            try {
                int i4 = -1;
                if (m.d() != null) {
                    i = m.d().intValue();
                } else {
                    i = -1;
                }
                if (m.f() != null) {
                    i2 = m.f().intValue();
                } else {
                    i2 = -1;
                }
                if (m.e() != null) {
                    i3 = m.e().intValue();
                } else {
                    i3 = -1;
                }
                if (m.g() != null) {
                    i4 = m.g().intValue();
                }
                if (an3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                hb3 hb3Var = new hb3();
                hb3Var.b = str;
                hb3Var.a("dh_group_id", Integer.valueOf(i));
                hb3Var.a("dh_secret", Integer.valueOf(i2));
                hb3Var.a("dh_pub_c", Integer.valueOf(i3));
                hb3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (an3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                xa3.d(hb3Var);
            } catch (Exception e) {
                if (an3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(pn3 pn3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, pn3Var, bdtls$Alert) == null) {
            if (an3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (pn3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (pn3Var.d() != null) {
                        i = pn3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (pn3Var.f() != null) {
                        i2 = pn3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (pn3Var.e() != null) {
                        i3 = pn3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (pn3Var.g() != null) {
                        i4 = pn3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (an3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    hb3 hb3Var = new hb3();
                    hb3Var.b = "alert";
                    hb3Var.e = str;
                    hb3Var.a("dh_group_id", Integer.valueOf(i));
                    hb3Var.a("dh_secret", Integer.valueOf(i2));
                    hb3Var.a("dh_pub_c", Integer.valueOf(i3));
                    hb3Var.a("dh_pub_s", Integer.valueOf(i4));
                    hb3Var.a("alert_msg", str2);
                    if (an3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    xa3.d(hb3Var);
                } catch (Exception e) {
                    if (an3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (an3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
