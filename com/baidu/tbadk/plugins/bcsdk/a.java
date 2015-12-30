package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service aBz;

    public static Service EU() {
        return aBz;
    }

    public static void a(Service service) {
        aBz = service;
    }
}
