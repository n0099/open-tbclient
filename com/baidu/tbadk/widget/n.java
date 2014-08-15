package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class n {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static n a(List<Object> list, List<Object> list2) {
        return new n(true, list, list2);
    }

    public static n a() {
        return new n(false, null, null);
    }

    private n(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
