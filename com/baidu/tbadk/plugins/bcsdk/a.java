package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service aDA;

    public static Service GH() {
        return aDA;
    }

    public static void a(Service service) {
        aDA = service;
    }
}
