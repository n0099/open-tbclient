package com.baidu.tbadk.widget;

import java.util.List;
/* loaded from: classes.dex */
class p {
    public final boolean ase;
    public final List<Object> asf;
    public final List<Object> asg;

    public static p a(List<Object> list, List<Object> list2) {
        return new p(true, list, list2);
    }

    public static p DA() {
        return new p(false, null, null);
    }

    private p(boolean z, List<Object> list, List<Object> list2) {
        this.ase = z;
        this.asf = list;
        this.asg = list2;
    }
}
