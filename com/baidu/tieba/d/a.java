package com.baidu.tieba.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
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

    public com.baidu.tieba.d.c.a a(LayoutInflater layoutInflater) {
        if (layoutInflater == null) {
            return null;
        }
        return new com.baidu.tieba.d.c.b(layoutInflater.inflate(v.pb_item_app_new, (ViewGroup) null));
    }

    public com.baidu.tieba.d.c.a b(LayoutInflater layoutInflater) {
        if (layoutInflater == null) {
            return null;
        }
        return new c(layoutInflater.inflate(v.pb_item_app, (ViewGroup) null));
    }
}
