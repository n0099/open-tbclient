package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class av3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (vu3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            kv3 m = bv3.l().m();
            if (m == null) {
                if (vu3.a) {
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
                if (vu3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                cj3 cj3Var = new cj3();
                cj3Var.b = str;
                cj3Var.a("dh_group_id", Integer.valueOf(i));
                cj3Var.a("dh_secret", Integer.valueOf(i2));
                cj3Var.a("dh_pub_c", Integer.valueOf(i3));
                cj3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (vu3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                si3.d(cj3Var);
            } catch (Exception e) {
                if (vu3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(kv3 kv3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, kv3Var, bdtls$Alert) == null) {
            if (vu3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (kv3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (kv3Var.d() != null) {
                        i = kv3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (kv3Var.f() != null) {
                        i2 = kv3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (kv3Var.e() != null) {
                        i3 = kv3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (kv3Var.g() != null) {
                        i4 = kv3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (vu3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    cj3 cj3Var = new cj3();
                    cj3Var.b = "alert";
                    cj3Var.e = str;
                    cj3Var.a("dh_group_id", Integer.valueOf(i));
                    cj3Var.a("dh_secret", Integer.valueOf(i2));
                    cj3Var.a("dh_pub_c", Integer.valueOf(i3));
                    cj3Var.a("dh_pub_s", Integer.valueOf(i4));
                    cj3Var.a("alert_msg", str2);
                    if (vu3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    si3.d(cj3Var);
                } catch (Exception e) {
                    if (vu3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (vu3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
