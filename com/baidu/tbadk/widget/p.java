package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class p {
    public final boolean atH;
    public final List<Object> atI;
    public final List<Object> atJ;

    public static p a(List<Object> list, List<Object> list2) {
        return new p(true, list, list2);
    }

    public static p El() {
        return new p(false, null, null);
    }

    private p(boolean z, List<Object> list, List<Object> list2) {
        this.atH = z;
        this.atI = list;
        this.atJ = list2;
    }
}
