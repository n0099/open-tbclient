package com.baidu.tieba;

import android.content.Context;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
public class ai {
    public static void a(Context context, String str) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(context, str, "click", 1);
        }
    }
}
