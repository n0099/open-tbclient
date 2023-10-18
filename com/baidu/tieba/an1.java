package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface an1 {
    SwanCoreVersion m();

    oi2 n(SwanAppActivity swanAppActivity, String str);

    x82 o(ik3<Exception> ik3Var);

    void p(Intent intent);

    View q(v42 v42Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    bg2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
