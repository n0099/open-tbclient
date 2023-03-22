package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface dp1 {
    SwanCoreVersion m();

    sk2 n(SwanAppActivity swanAppActivity, String str);

    bb2 o(mm3<Exception> mm3Var);

    void p(Intent intent);

    View q(z62 z62Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    fi2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
