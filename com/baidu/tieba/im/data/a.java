package com.baidu.tieba.im.data;

import java.util.LinkedList;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.util.a {
    private int a;
    private String b;
    private String c;

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public final LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.c);
        return linkedList;
    }

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }
}
