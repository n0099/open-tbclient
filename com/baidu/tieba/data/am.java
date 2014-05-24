package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class am {
    final int a;
    final String b;
    final AntiData c;

    public am(int i, String str, AntiData antiData) {
        this.a = i;
        this.b = str;
        this.c = antiData;
    }

    public boolean a() {
        return this.a != 0;
    }

    public boolean b() {
        return this.a == 5 || this.a == 6;
    }

    public String c() {
        return this.b;
    }

    public AntiData d() {
        return this.c;
    }
}
