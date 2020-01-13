package com.baidu.tieba.aiapps.apps.launch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.BdToken.f;
/* loaded from: classes10.dex */
public class a {
    private static void ng(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    public static void ni(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").showToast();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").showToast();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            rm(str);
            ng(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").showToast();
        }
    }

    private static void rm(String str) {
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String queryParameter = parse.getQueryParameter(f.PARAM_FROM);
            if (!TextUtils.isEmpty(queryParameter) && "shoubai".equals(queryParameter)) {
                com.baidu.tbadk.util.d.aPy().setShow(true);
            } else {
                com.baidu.tbadk.util.d.aPy().setShow(false);
            }
        }
    }
}
