package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
/* loaded from: classes.dex */
public class a {
    private static Service aCo;

    public static Service Gl() {
        return aCo;
    }

    public static void a(Service service) {
        aCo = service;
    }
}
