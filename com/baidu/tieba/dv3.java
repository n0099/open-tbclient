package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (yu3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            nv3 m = ev3.l().m();
            if (m == null) {
                if (yu3.a) {
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
                if (yu3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                fj3 fj3Var = new fj3();
                fj3Var.b = str;
                fj3Var.a("dh_group_id", Integer.valueOf(i));
                fj3Var.a("dh_secret", Integer.valueOf(i2));
                fj3Var.a("dh_pub_c", Integer.valueOf(i3));
                fj3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (yu3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                vi3.d(fj3Var);
            } catch (Exception e) {
                if (yu3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(nv3 nv3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, nv3Var, bdtls$Alert) == null) {
            if (yu3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (nv3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (nv3Var.d() != null) {
                        i = nv3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (nv3Var.f() != null) {
                        i2 = nv3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (nv3Var.e() != null) {
                        i3 = nv3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (nv3Var.g() != null) {
                        i4 = nv3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (yu3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    fj3 fj3Var = new fj3();
                    fj3Var.b = "alert";
                    fj3Var.e = str;
                    fj3Var.a("dh_group_id", Integer.valueOf(i));
                    fj3Var.a("dh_secret", Integer.valueOf(i2));
                    fj3Var.a("dh_pub_c", Integer.valueOf(i3));
                    fj3Var.a("dh_pub_s", Integer.valueOf(i4));
                    fj3Var.a("alert_msg", str2);
                    if (yu3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    vi3.d(fj3Var);
                } catch (Exception e) {
                    if (yu3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (yu3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
