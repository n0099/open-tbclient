package com.baidu.tieba.aiapps.apps;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.swancore.remote.SwanCoreDynamicCallback;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static void start() {
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SwanCoreDynamicCallback(false));
        com.baidu.b.a.e.a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        com.baidu.b.a.e.a.c(arrayList, true);
    }
}
