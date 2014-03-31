package com.baidu.tieba.im.message.a;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.message.websockt.d {
    private long a;
    private int b;
    public boolean c;
    private Object d;
    private String e;
    private long f;
    private long g;
    private long h;
    private int i;
    private int j;
    private long k;
    private UserData l;
    private UserData m;
    private MsgLocalData n;
    private transient MsgCacheData o;
    private int p;
    private long q;
    private String r;
    private String s;
    private String t;
    private long u;
    private boolean v;
    private boolean w;
    private long x;
    private LinkedList<IconData> y;

    public a(int i) {
        super(i);
        this.p = 0;
        this.v = true;
        this.w = false;
    }

    public final String i() {
        return this.r;
    }

    public final void a(String str) {
        this.r = str;
    }

    public final long j() {
        return this.a;
    }

    public final void b(long j) {
        this.a = j;
    }

    public final long l() {
        return this.q;
    }

    public final void c(long j) {
        this.q = j;
    }

    public final String m() {
        return this.s;
    }

    public final void b(String str) {
        this.s = str;
    }

    public final String n() {
        return this.t;
    }

    public final void c(String str) {
        this.t = str;
    }

    public final void d(long j) {
        this.u = j;
    }

    public final boolean o() {
        return this.w;
    }

    public final void a(boolean z) {
        this.w = z;
    }

    public final int p() {
        return this.p;
    }

    public final void d(int i) {
        this.p = i;
    }

    public final Object q() {
        return this.d;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final UserData r() {
        return this.l;
    }

    public final void a(UserData userData) {
        this.l = userData;
    }

    public final UserData s() {
        return this.m;
    }

    public final void b(UserData userData) {
        this.m = userData;
    }

    public final int t() {
        return this.b;
    }

    public final void e(int i) {
        this.b = i;
    }

    public final long u() {
        return this.f;
    }

    public final void e(long j) {
        this.f = j;
    }

    public final String v() {
        return this.e;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final long w() {
        return this.g;
    }

    public final void f(long j) {
        this.g = j;
    }

    public final long x() {
        return this.k;
    }

    public final void g(long j) {
        this.k = j;
    }

    public final MsgLocalData y() {
        return this.n;
    }

    public final void a(MsgLocalData msgLocalData) {
        this.n = msgLocalData;
    }

    public final MsgCacheData z() {
        return this.o;
    }

    public final void a(MsgCacheData msgCacheData) {
        this.o = msgCacheData;
    }

    public final long A() {
        return this.h;
    }

    public final void h(long j) {
        this.h = j;
    }

    public final int B() {
        return this.i;
    }

    public final void f(int i) {
        this.i = i;
    }

    public final int C() {
        return this.j;
    }

    public final void h(int i) {
        this.j = i;
    }

    public final boolean D() {
        return this.v;
    }

    public final void b(boolean z) {
        this.v = z;
    }

    public final long E() {
        return this.x;
    }

    public final void i(long j) {
        this.x = j;
    }

    public String toString() {
        return "ChatMessage{msgType=" + this.b + ", objContent=" + this.d + ", content='" + this.e + "', recordId=" + this.f + ", msgId=" + this.g + ", time=" + this.h + ", width=" + this.i + ", height=" + this.j + ", userId=" + this.k + ", userInfo=" + this.l + ", toUserInfo=" + this.m + ", localData=" + this.n + ", cacheData=" + this.o + ", progressValue=" + this.p + ", mToUserId=" + this.q + ", isGifLoadSuccess=" + this.v + ", isUploading=" + this.w + ", logTime=" + this.x + ", mTShowIconInfo=" + this.y + '}';
    }
}
