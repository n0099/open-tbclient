package com.baidu.tieba.d;

import android.content.Context;
import com.baidu.tieba.d.c.c;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private static a bHv;

    public static final a abm() {
        if (bHv != null) {
            return bHv;
        }
        synchronized (a.class) {
            if (bHv == null) {
                bHv = new a();
            }
        }
        return bHv;
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
