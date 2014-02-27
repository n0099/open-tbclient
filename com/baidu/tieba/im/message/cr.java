package com.baidu.tieba.im.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class cr extends da {
    private String a;
    private List<String> b;

    public cr() {
        this.a = "";
        this.b = new ArrayList();
    }

    public cr(int i) {
        super(103010);
        this.a = "";
        this.b = new ArrayList();
    }

    public final void a(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    public final String a() {
        return this.a;
    }

    public final void b(String str) {
        if (str != null && !str.equals("") && !this.b.contains(str)) {
            this.b.add(str);
        }
    }

    public final Iterator<String> b() {
        return this.b.iterator();
    }
}
