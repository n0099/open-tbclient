package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.j43;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public interface i43 {
    public static final Set<String> o0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(j43.a aVar);

    p63 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(yi3<j43.a> yi3Var);

    void p(String str);

    f43 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(yi3<j43.a> yi3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    il1 x();

    a13 y();
}
