package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class r {
    public final boolean abl;
    public final List<Object> abm;
    public final List<Object> abn;

    public static r a(List<Object> list, List<Object> list2) {
        return new r(true, list, list2);
    }

    public static r vz() {
        return new r(false, null, null);
    }

    private r(boolean z, List<Object> list, List<Object> list2) {
        this.abl = z;
        this.abm = list;
        this.abn = list2;
    }
}
