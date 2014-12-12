package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class r {
    public final boolean aiX;
    public final List<Object> aiY;
    public final List<Object> aiZ;

    public static r a(List<Object> list, List<Object> list2) {
        return new r(true, list, list2);
    }

    public static r zK() {
        return new r(false, null, null);
    }

    private r(boolean z, List<Object> list, List<Object> list2) {
        this.aiX = z;
        this.aiY = list;
        this.aiZ = list2;
    }
}
