package com.baidu.tieba.aiapps.apps.launch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes4.dex */
public class a {
    private static void tG(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    public static void tH(String str) {
        if (!c.aEX()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").LU();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").LU();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            tG(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").LU();
        }
    }
}
