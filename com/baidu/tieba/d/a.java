package com.baidu.tieba.d;

import android.content.Context;
import com.baidu.tieba.d.c.c;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class a {
    private static a a;

    public static final a a() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    public com.baidu.tieba.d.c.a a(Context context) {
        if (context == null) {
            return null;
        }
        return new com.baidu.tieba.d.c.b(com.baidu.adp.lib.e.b.a().a(context, v.pb_item_app_new, null));
    }

    public com.baidu.tieba.d.c.a b(Context context) {
        if (context == null) {
            return null;
        }
        return new c(com.baidu.adp.lib.e.b.a().a(context, v.pb_item_app, null));
    }
}
