package com.baidu.tieba.im.data;

import com.baidu.tieba.util.au;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends au {
    private int a;
    private String b;
    private String c;

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(c());
        return linkedList;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }
}
