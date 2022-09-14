package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface ik1 {
    SwanCoreVersion m();

    xf2 n(SwanAppActivity swanAppActivity, String str);

    g62 o(rh3<Exception> rh3Var);

    void p(Intent intent);

    View q(e22 e22Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    kd2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
