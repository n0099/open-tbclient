package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface ft1 {
    SwanCoreVersion m();

    uo2 n(SwanAppActivity swanAppActivity, String str);

    df2 o(oq3<Exception> oq3Var);

    void p(Intent intent);

    View q(bb2 bb2Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    hm2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
