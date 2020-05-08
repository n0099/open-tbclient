package com.baidu.tieba.aiapps.apps.launch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.tbadk.BdToken.f;
/* loaded from: classes12.dex */
public class a {
    private static void oJ(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    public static void oL(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").showToast();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").showToast();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            sR(str);
            oJ(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").showToast();
        }
    }

    private static void sR(String str) {
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String queryParameter = parse.getQueryParameter(f.PARAM_FROM);
            if (!TextUtils.isEmpty(queryParameter) && UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter)) {
                com.baidu.tbadk.util.d.bad().setShow(true);
            } else {
                com.baidu.tbadk.util.d.bad().setShow(false);
            }
        }
    }
}
