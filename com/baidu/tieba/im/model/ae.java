package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.LocalViewSize;
/* loaded from: classes.dex */
public class ae {
    private static int b = -1;
    private static int c = -2;
    private static int d = -3;
    private static int e = 2230203;
    public com.baidu.tieba.im.message.b a;
    private String h;
    private int j;
    private int k;
    private int l;
    private int m;
    private ai f = null;
    private ah g = null;
    private String i = null;
    private ag n = null;

    public ae(String str, int i, int i2, int i3, int i4) {
        this.h = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.h = str;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        LocalViewSize.ImageSize c2 = LocalViewSize.a().c();
        LocalViewSize.ImageSize d2 = LocalViewSize.a().d();
        if (this.j <= 0) {
            this.j = c2.width;
        }
        if (this.k <= 0) {
            this.k = c2.height;
        }
        if (this.l <= 0) {
            this.l = d2.width;
        }
        if (this.m <= 0) {
            this.m = d2.height;
        }
    }

    public void a() {
        if (this.n == null) {
            this.n = new ag(this);
            this.n.execute(new String[0]);
        }
    }

    public void b() {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    public void a(ai aiVar) {
        this.f = aiVar;
    }

    public void a(ah ahVar) {
        this.g = ahVar;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        this.a = bVar;
    }
}
