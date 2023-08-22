package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ou3 m = fu3.l().m();
            if (m == null) {
                if (zt3.a) {
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
                if (zt3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                gi3 gi3Var = new gi3();
                gi3Var.b = str;
                gi3Var.a("dh_group_id", Integer.valueOf(i));
                gi3Var.a("dh_secret", Integer.valueOf(i2));
                gi3Var.a("dh_pub_c", Integer.valueOf(i3));
                gi3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (zt3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                wh3.d(gi3Var);
            } catch (Exception e) {
                if (zt3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ou3 ou3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ou3Var, bdtls$Alert) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ou3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (ou3Var.d() != null) {
                        i = ou3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (ou3Var.f() != null) {
                        i2 = ou3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (ou3Var.e() != null) {
                        i3 = ou3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (ou3Var.g() != null) {
                        i4 = ou3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (zt3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    gi3 gi3Var = new gi3();
                    gi3Var.b = "alert";
                    gi3Var.e = str;
                    gi3Var.a("dh_group_id", Integer.valueOf(i));
                    gi3Var.a("dh_secret", Integer.valueOf(i2));
                    gi3Var.a("dh_pub_c", Integer.valueOf(i3));
                    gi3Var.a("dh_pub_s", Integer.valueOf(i4));
                    gi3Var.a("alert_msg", str2);
                    if (zt3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    wh3.d(gi3Var);
                } catch (Exception e) {
                    if (zt3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (zt3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
