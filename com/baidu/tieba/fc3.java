package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.tieba.gc3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public interface fc3 {
    public static final Set<String> p0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(gc3.a aVar);

    me3 B();

    boolean E();

    void G();

    String getAppId();

    int k();

    void l(Bundle bundle, String str);

    SwanAppCores m();

    String n(String... strArr);

    void o(vq3<gc3.a> vq3Var);

    void p(String str);

    cc3 q();

    void r(SwanAppActivity swanAppActivity);

    void s();

    void t(SwanAppActivity swanAppActivity);

    void u(vq3<gc3.a> vq3Var);

    void v(String str, Bundle bundle);

    SwanAppActivity w();

    ft1 x();

    x83 y();
}
