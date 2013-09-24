package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f836a;
    public final List<Object> b;
    public final List<Object> c;

    public static b a(List<Object> list, List<Object> list2) {
        return new b(true, list, list2);
    }

    public static b a() {
        return new b(false, null, null);
    }

    private b(boolean z, List<Object> list, List<Object> list2) {
        this.f836a = z;
        this.b = list;
        this.c = list2;
    }
}
