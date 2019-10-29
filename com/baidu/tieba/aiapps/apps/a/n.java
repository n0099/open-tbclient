package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.u.b.c;
/* loaded from: classes4.dex */
public class n implements com.baidu.swan.apps.u.b.c {
    @Override // com.baidu.swan.apps.u.b.c
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        c.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public boolean bd(Context context) {
        return ProcessUtils.isMainProcess() ? c.isLogin(context) : c.da(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public String be(Context context) {
        return ProcessUtils.isMainProcess() ? c.getUid(context) : c.cY(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public String bf(@NonNull Context context) {
        return ProcessUtils.isMainProcess() ? c.getCuid(context) : c.cZ(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public String bg(@NonNull Context context) {
        return c.getBduss(context);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public void a(String str, c.a aVar) {
        c.a(str, aVar);
    }

    @Override // com.baidu.swan.apps.u.b.c
    public void a(com.baidu.swan.apps.a.c cVar) {
        c.a(cVar);
    }
}
