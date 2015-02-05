package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class r {
    public final boolean ajx;
    public final List<Object> ajy;
    public final List<Object> ajz;

    public static r a(List<Object> list, List<Object> list2) {
        return new r(true, list, list2);
    }

    public static r zY() {
        return new r(false, null, null);
    }

    private r(boolean z, List<Object> list, List<Object> list2) {
        this.ajx = z;
        this.ajy = list;
        this.ajz = list2;
    }
}
