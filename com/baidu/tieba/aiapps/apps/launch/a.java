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
    private static void sp(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    public static void sq(String str) {
        if (!c.aFg()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").QO();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").QO();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            sp(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").QO();
        }
    }
}
