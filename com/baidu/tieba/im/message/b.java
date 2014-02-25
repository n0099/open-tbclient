package com.baidu.tieba.im.message;

import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class b extends s implements com.baidu.tieba.im.coder.g, com.baidu.tieba.im.messageCenter.c {
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

    public long b() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public long c() {
        return this.q;
    }

    public void b(long j) {
        this.q = j;
    }

    public boolean d() {
        return this.s;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public int e() {
        return this.p;
    }

    public void a(int i) {
        this.p = i;
    }

    public Object f() {
        return this.d;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    public UserData g() {
        return this.l;
    }

    public void a(UserData userData) {
        this.l = userData;
    }

    public UserData h() {
        return this.m;
    }

    public void b(UserData userData) {
        this.m = userData;
    }

    public int i() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public long j() {
        return this.f;
    }

    public void c(long j) {
        this.f = j;
    }

    public String k() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public long l() {
        return this.g;
    }

    public void d(long j) {
        this.g = j;
    }

    public long m() {
        return this.k;
    }

    public void e(long j) {
        this.k = j;
    }

    public MsgLocalData n() {
        return this.n;
    }

    public void a(MsgLocalData msgLocalData) {
        this.n = msgLocalData;
    }

    public MsgCacheData o() {
        return this.o;
    }

    public void a(MsgCacheData msgCacheData) {
        this.o = msgCacheData;
    }

    public long p() {
        return this.h;
    }

    public void f(long j) {
        this.h = j;
    }

    public int q() {
        return this.i;
    }

    public void c(int i) {
        this.i = i;
    }

    public int r() {
        return this.j;
    }

    public void d(int i) {
        this.j = i;
    }

    public boolean s() {
        return this.r;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public long t() {
        return this.t;
    }

    public void g(long j) {
        this.t = j;
    }

    @Override // com.baidu.tieba.im.messageCenter.c
    public boolean a(s sVar) {
        return sVar != null && (sVar instanceof b) && ((b) sVar).j() == this.f;
    }

    public String toString() {
        return "ChatMessage{msgType=" + this.c + ", objContent=" + this.d + ", content='" + this.e + "', recordId=" + this.f + ", msgId=" + this.g + ", time=" + this.h + ", width=" + this.i + ", height=" + this.j + ", userId=" + this.k + ", userInfo=" + this.l + ", toUserInfo=" + this.m + ", localData=" + this.n + ", cacheData=" + this.o + ", progressValue=" + this.p + ", mToUserId=" + this.q + ", isGifLoadSuccess=" + this.r + ", isUploading=" + this.s + ", logTime=" + this.t + ", mTShowIconInfo=" + this.u + '}';
    }
}
