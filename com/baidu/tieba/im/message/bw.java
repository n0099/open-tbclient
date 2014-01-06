package com.baidu.tieba.im.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class bw extends cc {
    private String a;
    private List<String> b;

    public bw() {
        this.a = "";
        this.b = new ArrayList();
    }

    public bw(int i) {
        super(i);
        this.a = "";
        this.b = new ArrayList();
    }

    public void a(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    public String a() {
        return this.a;
    }

    public void b(String str) {
        if (str != null && !str.equals("") && !this.b.contains(str)) {
            this.b.add(str);
        }
    }

    public Iterator<String> b() {
        return this.b.iterator();
    }
}
