package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service azp;

    public static Service Fe() {
        return azp;
    }

    public static void a(Service service) {
        azp = service;
    }
}
