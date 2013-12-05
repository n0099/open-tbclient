package com.baidu.tieba.im.b.a;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f1516a = new ArrayList();
    private Hashtable<String, a> b = new Hashtable<>();
    private int c = 0;

    public void a(String str, a aVar) {
        this.f1516a.add(str);
        this.b.put(str, aVar);
        this.c++;
    }

    public int a() {
        return this.c;
    }

    public String a(int i) {
        return this.f1516a.get(i);
    }

    public a b(int i) {
        return this.b.get(this.f1516a.get(i));
    }
}
