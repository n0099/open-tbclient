package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.message.ChatMessage;
/* loaded from: classes.dex */
public class t {
    private static int b = -1;
    private static int c = -2;
    private static int d = -3;
    private static int e = 2230203;

    /* renamed from: a  reason: collision with root package name */
    public ChatMessage f1829a;
    private String h;
    private int j;
    private int k;
    private int l;
    private int m;
    private x f = null;
    private w g = null;
    private String i = null;
    private v n = null;

    public t(String str, int i, int i2, int i3, int i4) {
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
            this.n = new v(this);
            this.n.execute(new String[0]);
        }
    }

    public void b() {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    public void a(x xVar) {
        this.f = xVar;
    }

    public void a(w wVar) {
        this.g = wVar;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(ChatMessage chatMessage) {
        this.f1829a = chatMessage;
    }
}
