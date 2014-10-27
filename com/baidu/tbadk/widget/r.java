package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class r {
    public final boolean abg;
    public final List<Object> abh;
    public final List<Object> abi;

    public static r a(List<Object> list, List<Object> list2) {
        return new r(true, list, list2);
    }

    public static r vx() {
        return new r(false, null, null);
    }

    private r(boolean z, List<Object> list, List<Object> list2) {
        this.abg = z;
        this.abh = list;
        this.abi = list2;
    }
}
