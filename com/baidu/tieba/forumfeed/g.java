package com.baidu.tieba.forumfeed;

import android.view.View;
/* loaded from: classes.dex */
public final class g {
    public static void a(com.baidu.tbadk.core.e eVar, View view, int i) {
        h hVar = (h) view.getTag();
        eVar.b().a(i == 1);
        eVar.b().a(view);
        if (hVar != null) {
            hVar.b.a(i);
            hVar.c.a(i);
        }
    }
}
