package com.baidu.tbadk.plugins;

import android.content.ContentProvider;
/* loaded from: classes.dex */
public class a {
    private static ContentProvider aMy;

    public static ContentProvider Hm() {
        return aMy;
    }

    public static void a(ContentProvider contentProvider) {
        aMy = contentProvider;
    }
}
