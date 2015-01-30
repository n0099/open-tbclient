package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class r {
    public final boolean ajA;
    public final List<Object> ajB;
    public final List<Object> ajC;

    public static r a(List<Object> list, List<Object> list2) {
        return new r(true, list, list2);
    }

    public static r Ae() {
        return new r(false, null, null);
    }

    private r(boolean z, List<Object> list, List<Object> list2) {
        this.ajA = z;
        this.ajB = list;
        this.ajC = list2;
    }
}
