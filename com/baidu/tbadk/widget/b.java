package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f599a;
    public final List b;
    public final List c;

    public static b a(List list, List list2) {
        return new b(true, list, list2);
    }

    public static b a() {
        return new b(false, null, null);
    }

    private b(boolean z, List list, List list2) {
        this.f599a = z;
        this.b = list;
        this.c = list2;
    }
}
