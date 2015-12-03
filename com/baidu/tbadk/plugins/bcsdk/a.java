package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service azS;

    public static Service Fg() {
        return azS;
    }

    public static void a(Service service) {
        azS = service;
    }
}
