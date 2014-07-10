package com.baidu.tieba.data;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int a = 0;
    private int b = 0;
    private String c = null;
    private String d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private long k = 0;
    private long l = 0;
    private boolean m = false;
    private long n = 0;
    private String o = null;
    private au p = new au();

    public int a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public long g() {
        return this.k;
    }

    public void b(int i) {
        this.e = i;
    }

    public int h() {
        return this.e;
    }

    public void c(int i) {
        this.f = i;
    }

    public int i() {
        return this.f;
    }

    public boolean j() {
        return this.m;
    }

    public long k() {
        return this.n;
    }

    public String l() {
        return this.o;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.a = starInfo.has_frs_star.intValue();
            if (this.a == 1) {
                this.c = starInfo.top;
                this.d = starInfo.head;
                Fans fans = starInfo.fans;
                this.e = fans.is_get.intValue();
                this.f = fans.num.intValue();
                this.b = fans.open.intValue();
                this.k = fans.left_time.intValue();
                this.l = this.k;
                Size size = starInfo.top_size;
                this.g = size.width.intValue();
                this.h = size.height.intValue();
                Size size2 = starInfo.head_size;
                this.i = size2.width.intValue();
                this.j = size2.height.intValue();
            }
            this.m = starInfo.trade != null;
            if (this.m) {
                if (starInfo.trade.time != null) {
                    this.n = starInfo.trade.time.intValue();
                }
                this.o = starInfo.trade.url;
            }
        }
    }
}
