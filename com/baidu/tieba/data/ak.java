package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public final class ak {
    final int a;
    final String b;
    final AntiData c;

    public ak(int i, String str, AntiData antiData) {
        this.a = i;
        this.b = str;
        this.c = antiData;
    }

    public final boolean a() {
        return this.a != 0;
    }

    public final boolean b() {
        return this.a == 5 || this.a == 6;
    }

    public final String c() {
        return this.b;
    }

    public final AntiData d() {
        return this.c;
    }
}
