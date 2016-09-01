package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service aEc;

    public static Service GI() {
        return aEc;
    }

    public static void a(Service service) {
        aEc = service;
    }
}
