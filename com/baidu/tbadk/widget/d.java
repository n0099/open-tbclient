package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class d {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static d a(List<Object> list, List<Object> list2) {
        return new d(true, list, list2);
    }

    public static d a() {
        return new d(false, null, null);
    }

    private d(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
