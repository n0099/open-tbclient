package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes4.dex */
public interface gq1 {
    SwanCoreVersion m();

    vl2 n(SwanAppActivity swanAppActivity, String str);

    ec2 o(pn3<Exception> pn3Var);

    void p(Intent intent);

    View q(c82 c82Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    ij2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
