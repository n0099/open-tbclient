package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
final class m {
    public final boolean a;
    public final List<Object> b;
    public final List<Object> c;

    public static m a(List<Object> list, List<Object> list2) {
        return new m(true, list, list2);
    }

    public static m a() {
        return new m(false, null, null);
    }

    private m(boolean z, List<Object> list, List<Object> list2) {
        this.a = z;
        this.b = list;
        this.c = list2;
    }
}
