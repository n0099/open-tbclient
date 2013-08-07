package com.baidu.tieba.a;

import com.baidu.tieba.data.at;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f832a = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/f/pb/page";
    private u b = null;

    public String a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5, boolean z3, long j, boolean z4, at atVar) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.b = new u(f832a);
        this.b.a("kz", str);
        this.b.a("rn", String.valueOf(30));
        this.b.a("with_floor", "1");
        if (!z) {
            this.b.a("r", "1");
        }
        if (z2) {
            this.b.a("lz", "1");
        }
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        if (z3) {
            this.b.a("msg_click", "1");
            this.b.a("message_id", String.valueOf(j));
        }
        if (atVar != null) {
            atVar.a(this.b);
        }
        switch (i3) {
            case 1:
                this.b.a("back", "0");
                if (!z4) {
                    if (!z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                } else if (!z) {
                    this.b.a("last", "1");
                    break;
                }
                break;
            case 2:
                this.b.a("back", "1");
                if (!z4) {
                    if (z) {
                        if (i > 0) {
                            this.b.a("pn", String.valueOf(i - 1));
                        }
                    } else if (i2 < i5) {
                        this.b.a("pn", String.valueOf(i2 + 1));
                    }
                }
                if (str3 != null) {
                    this.b.a("pid", str3);
                    break;
                }
                break;
            case 3:
                this.b.a("back", "0");
                if (z) {
                    this.b.a("pn", "1");
                    break;
                } else {
                    this.b.a("last", "1");
                    break;
                }
            case 4:
                this.b.a("st_type", "store_thread");
                this.b.a("mark", "1");
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
            case 5:
                this.b.a("back", "0");
                this.b.a("pn", String.valueOf(i4));
                break;
            case 6:
                this.b.a("mark", "1");
                this.b.a("pid", str3);
                this.b.a("back", "0");
                break;
        }
        return this.b.k();
    }

    public void a() {
        if (this.b != null) {
            this.b.i();
        }
    }

    public boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.d();
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return this.b.e();
    }

    public int d() {
        if (this.b == null) {
            return 0;
        }
        return this.b.c();
    }

    public String e() {
        if (this.b == null) {
            return null;
        }
        return this.b.h();
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.f();
    }
}
