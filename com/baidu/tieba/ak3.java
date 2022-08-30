package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ak3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (vj3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            kk3 m = bk3.l().m();
            if (m == null) {
                if (vj3.a) {
                    Log.d("BDTLS", "bdtls ubc data is null");
                    return;
                }
                return;
            }
            try {
                int intValue = m.d() != null ? m.d().intValue() : -1;
                int intValue2 = m.f() != null ? m.f().intValue() : -1;
                int intValue3 = m.e() != null ? m.e().intValue() : -1;
                int intValue4 = m.g() != null ? m.g().intValue() : -1;
                if (vj3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                d83 d83Var = new d83();
                d83Var.b = str;
                d83Var.a("dh_group_id", Integer.valueOf(intValue));
                d83Var.a("dh_secret", Integer.valueOf(intValue2));
                d83Var.a("dh_pub_c", Integer.valueOf(intValue3));
                d83Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (vj3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                t73.d(d83Var);
            } catch (Exception e) {
                if (vj3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(kk3 kk3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, kk3Var, bdtls$Alert) == null) {
            if (vj3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (kk3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = kk3Var.d() != null ? kk3Var.d().intValue() : -1;
                    int intValue2 = kk3Var.f() != null ? kk3Var.f().intValue() : -1;
                    int intValue3 = kk3Var.e() != null ? kk3Var.e().intValue() : -1;
                    int intValue4 = kk3Var.g() != null ? kk3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (vj3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    d83 d83Var = new d83();
                    d83Var.b = "alert";
                    d83Var.e = str;
                    d83Var.a("dh_group_id", Integer.valueOf(intValue));
                    d83Var.a("dh_secret", Integer.valueOf(intValue2));
                    d83Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    d83Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    d83Var.a("alert_msg", str2);
                    if (vj3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    t73.d(d83Var);
                } catch (Exception e) {
                    if (vj3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (vj3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
