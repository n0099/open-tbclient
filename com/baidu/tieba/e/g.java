package com.baidu.tieba.e;

import android.view.View;
/* loaded from: classes.dex */
public final class g {
    public static void a(com.baidu.tieba.k kVar, View view, int i) {
        h hVar = (h) view.getTag();
        kVar.a().a(i == 1);
        kVar.a().a(view);
        if (hVar != null) {
            hVar.b.a(i);
            hVar.c.a(i);
        }
    }
}
