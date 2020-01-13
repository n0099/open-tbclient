package com.baidu.tieba.frs.e;

import android.content.Intent;
/* loaded from: classes7.dex */
public class c {
    public static b a(g gVar, Intent intent) {
        int intExtra = intent.getIntExtra("transition_type", 0);
        if (intExtra == 1) {
            return new h(gVar, intent);
        }
        if (intExtra == 2) {
            return new a(gVar, intent);
        }
        return null;
    }
}
