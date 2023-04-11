package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface ep1 {
    SwanCoreVersion m();

    tk2 n(SwanAppActivity swanAppActivity, String str);

    cb2 o(nm3<Exception> nm3Var);

    void p(Intent intent);

    View q(a72 a72Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    gi2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
