package com.baidu.tieba.d;

import android.content.Context;
import com.baidu.tieba.d.c.c;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private static a bHh;

    public static final a abj() {
        if (bHh != null) {
            return bHh;
        }
        synchronized (a.class) {
            if (bHh == null) {
                bHh = new a();
            }
        }
        return bHh;
    }

    public com.baidu.tieba.d.c.a ag(Context context) {
        if (context == null) {
            return null;
        }
        return new com.baidu.tieba.d.c.b(com.baidu.adp.lib.g.b.ek().inflate(context, w.pb_item_app_new, null));
    }

    public com.baidu.tieba.d.c.a ah(Context context) {
        if (context == null) {
            return null;
        }
        return new c(com.baidu.adp.lib.g.b.ek().inflate(context, w.pb_item_app, null));
    }
}
