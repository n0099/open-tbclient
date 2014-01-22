package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class p extends cr {
    private String a;
    private List<b> c;
    private boolean d;
    private long b = 0;
    private int e = 0;

    public p() {
        e(SapiErrorCode.GET_CERT_FAIL);
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public List<b> b() {
        return this.c;
    }

    public void a(List<b> list) {
        this.c = list;
    }

    public boolean c() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public long d() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }
}
