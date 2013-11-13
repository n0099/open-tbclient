package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.message.ChatMessage;
/* loaded from: classes.dex */
public class r {
    private static int b = -1;
    private static int c = -2;
    private static int d = -3;
    private static int e = 2230203;

    /* renamed from: a  reason: collision with root package name */
    public ChatMessage f1760a;
    private String g;
    private int i;
    private int j;
    private int k;
    private int l;
    private u f = null;
    private String h = null;
    private t m = null;

    public r(String str, int i, int i2, int i3, int i4) {
        this.g = null;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.g = str;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        LocalViewSize.ImageSize c2 = LocalViewSize.a().c();
        LocalViewSize.ImageSize d2 = LocalViewSize.a().d();
        if (this.i <= 0) {
            this.i = c2.width;
        }
        if (this.j <= 0) {
            this.j = c2.height;
        }
        if (this.k <= 0) {
            this.k = d2.width;
        }
        if (this.l <= 0) {
            this.l = d2.height;
        }
    }

    public void a() {
        if (this.m == null) {
            this.m = new t(this);
            this.m.execute(new String[0]);
        }
    }

    public void b() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
    }

    public void a(u uVar) {
        this.f = uVar;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(ChatMessage chatMessage) {
        this.f1760a = chatMessage;
    }
}
