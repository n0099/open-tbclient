package com.baidu.tbadk.plugins;

import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider aVt;

    public static ContentProvider KW() {
        return aVt;
    }

    public static void a(ContentProvider contentProvider) {
        aVt = contentProvider;
    }
}
