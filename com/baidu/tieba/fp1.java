package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface fp1 {
    SwanCoreVersion m();

    uk2 n(SwanAppActivity swanAppActivity, String str);

    db2 o(om3<Exception> om3Var);

    void p(Intent intent);

    View q(b72 b72Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    hi2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
