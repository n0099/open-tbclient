package com.baidu.tieba.im.message;

import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class b extends s implements com.baidu.tieba.im.coder.g, com.baidu.tieba.im.messageCenter.b {
    public boolean a;
    private long b;
    private int c;
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
    private long q;
    private long t;
    private LinkedList<IconData> u;
    private int p = 0;
    private boolean r = true;
    private boolean s = false;

    public final long b() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final long c() {
        return this.q;
    }

    public final void b(long j) {
        this.q = j;
    }

    public final boolean d() {
        return this.s;
    }

    public final void a(boolean z) {
        this.s = z;
    }

    public final int e() {
        return this.p;
    }

    public final void a(int i) {
        this.p = i;
    }

    public final Object f() {
        return this.d;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final UserData g() {
        return this.l;
    }

    public final void a(UserData userData) {
        this.l = userData;
    }

    public final UserData h() {
        return this.m;
    }

    public final void b(UserData userData) {
        this.m = userData;
    }

    public final int i() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final long j() {
        return this.f;
    }

    public final void c(long j) {
        this.f = j;
    }

    public final String k() {
        return this.e;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final long l() {
        return this.g;
    }

    public final void d(long j) {
        this.g = j;
    }

    public final long m() {
        return this.k;
    }

    public final void e(long j) {
        this.k = j;
    }

    public final MsgLocalData n() {
        return this.n;
    }

    public final void a(MsgLocalData msgLocalData) {
        this.n = msgLocalData;
    }

    public final MsgCacheData o() {
        return this.o;
    }

    public final void a(MsgCacheData msgCacheData) {
        this.o = msgCacheData;
    }

    public final long p() {
        return this.h;
    }

    public final void f(long j) {
        this.h = j;
    }

    public final int q() {
        return this.i;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final int r() {
        return this.j;
    }

    public final void d(int i) {
        this.j = i;
    }

    public final boolean s() {
        return this.r;
    }

    public final void b(boolean z) {
        this.r = z;
    }

    public final long t() {
        return this.t;
    }

    public final void g(long j) {
        this.t = j;
    }

    @Override // com.baidu.tieba.im.messageCenter.b
    public final boolean a(s sVar) {
        return sVar != null && (sVar instanceof b) && ((b) sVar).f == this.f;
    }

    public String toString() {
        return "ChatMessage{msgType=" + this.c + ", objContent=" + this.d + ", content='" + this.e + "', recordId=" + this.f + ", msgId=" + this.g + ", time=" + this.h + ", width=" + this.i + ", height=" + this.j + ", userId=" + this.k + ", userInfo=" + this.l + ", toUserInfo=" + this.m + ", localData=" + this.n + ", cacheData=" + this.o + ", progressValue=" + this.p + ", mToUserId=" + this.q + ", isGifLoadSuccess=" + this.r + ", isUploading=" + this.s + ", logTime=" + this.t + ", mTShowIconInfo=" + this.u + '}';
    }
}
