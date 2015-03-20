package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class p {
    public final boolean arW;
    public final List<Object> arX;
    public final List<Object> arY;

    public static p a(List<Object> list, List<Object> list2) {
        return new p(true, list, list2);
    }

    public static p Du() {
        return new p(false, null, null);
    }

    private p(boolean z, List<Object> list, List<Object> list2) {
        this.arW = z;
        this.arX = list;
        this.arY = list2;
    }
}
