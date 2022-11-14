package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (bn3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            qn3 m = hn3.l().m();
            if (m == null) {
                if (bn3.a) {
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
                if (bn3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                ib3 ib3Var = new ib3();
                ib3Var.b = str;
                ib3Var.a("dh_group_id", Integer.valueOf(i));
                ib3Var.a("dh_secret", Integer.valueOf(i2));
                ib3Var.a("dh_pub_c", Integer.valueOf(i3));
                ib3Var.a("dh_pub_s", Integer.valueOf(i4));
                if (bn3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                ya3.d(ib3Var);
            } catch (Exception e) {
                if (bn3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(qn3 qn3Var, Bdtls$Alert bdtls$Alert) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qn3Var, bdtls$Alert) == null) {
            if (bn3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (qn3Var != null && bdtls$Alert != null) {
                try {
                    if (bdtls$Alert.getLevel() == 1) {
                        str = "warning";
                    } else {
                        str = "fatal_error";
                    }
                    int i4 = -1;
                    if (qn3Var.d() != null) {
                        i = qn3Var.d().intValue();
                    } else {
                        i = -1;
                    }
                    if (qn3Var.f() != null) {
                        i2 = qn3Var.f().intValue();
                    } else {
                        i2 = -1;
                    }
                    if (qn3Var.e() != null) {
                        i3 = qn3Var.e().intValue();
                    } else {
                        i3 = -1;
                    }
                    if (qn3Var.g() != null) {
                        i4 = qn3Var.g().intValue();
                    }
                    if (bdtls$Alert.getDescription() != null) {
                        str2 = new String(bdtls$Alert.getDescription().toByteArray());
                    } else {
                        str2 = "";
                    }
                    if (bn3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    ib3 ib3Var = new ib3();
                    ib3Var.b = "alert";
                    ib3Var.e = str;
                    ib3Var.a("dh_group_id", Integer.valueOf(i));
                    ib3Var.a("dh_secret", Integer.valueOf(i2));
                    ib3Var.a("dh_pub_c", Integer.valueOf(i3));
                    ib3Var.a("dh_pub_s", Integer.valueOf(i4));
                    ib3Var.a("alert_msg", str2);
                    if (bn3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    ya3.d(ib3Var);
                } catch (Exception e) {
                    if (bn3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (bn3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
