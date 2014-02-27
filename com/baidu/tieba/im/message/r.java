package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public final class r extends da {
    private String a;
    private List<b> c;
    private boolean d;
    private long b = 0;
    private int e = 0;

    public r() {
        e(SapiErrorCode.GET_CERT_FAIL);
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final List<b> b() {
        return this.c;
    }

    public final void a(List<b> list) {
        this.c = list;
    }

    public final boolean c() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final long d() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final int e() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }
}
