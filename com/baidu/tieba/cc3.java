package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.dc3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public interface cc3 {
    public static final Set<String> p0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(dc3.a aVar);

    je3 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(sq3<dc3.a> sq3Var);

    void p(String str);

    zb3 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(sq3<dc3.a> sq3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    ct1 x();

    u83 y();
}
