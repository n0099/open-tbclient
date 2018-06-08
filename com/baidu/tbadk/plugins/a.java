package com.baidu.tbadk.plugins;

import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider aUx;

    public static ContentProvider KE() {
        return aUx;
    }

    public static void a(ContentProvider contentProvider) {
        aUx = contentProvider;
    }
}
