package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service aAf;

    public static Service Fn() {
        return aAf;
    }

    public static void a(Service service) {
        aAf = service;
    }
}
