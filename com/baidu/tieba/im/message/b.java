package com.baidu.tieba.im.message;

import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
/* loaded from: classes.dex */
public abstract class b extends n implements com.baidu.tieba.im.coder.g, com.baidu.tieba.im.messageCenter.c {
    private int a;
    private Object b;
    private String c;
    private long d;
    private long e;
    private long f;
    private int g;
    private int h;
    private long i;
    private UserData j;
    private UserData k;
    private MsgLocalData l;
    private transient MsgCacheData m;
    private long o;
    private long q;
    private int n = 0;
    private boolean p = false;

    public long b() {
        return this.o;
    }

    public void a(long j) {
        this.o = j;
    }

    public boolean c() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public int d() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
    }

    public Object e() {
        return this.b;
    }

    public void a(Object obj) {
        this.b = obj;
    }

    public UserData f() {
        return this.j;
    }

    public void a(UserData userData) {
        this.j = userData;
    }

    public UserData g() {
        return this.k;
    }

    public void b(UserData userData) {
        this.k = userData;
    }

    public int h() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public long i() {
        return this.d;
    }

    public void b(long j) {
        this.d = j;
    }

    public String j() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public long k() {
        return this.e;
    }

    public void c(long j) {
        this.e = j;
    }

    public long l() {
        return this.i;
    }

    public void d(long j) {
        this.i = j;
    }

    public MsgLocalData m() {
        return this.l;
    }

    public void a(MsgLocalData msgLocalData) {
        this.l = msgLocalData;
    }

    public MsgCacheData n() {
        return this.m;
    }

    public void a(MsgCacheData msgCacheData) {
        this.m = msgCacheData;
    }

    public long o() {
        return this.f;
    }

    public void e(long j) {
        this.f = j;
    }

    public int p() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public int q() {
        return this.h;
    }

    public void d(int i) {
        this.h = i;
    }

    public long r() {
        return this.q;
    }

    public void f(long j) {
        this.q = j;
    }

    @Override // com.baidu.tieba.im.messageCenter.c
    public boolean a(n nVar) {
        return nVar != null && (nVar instanceof b) && ((b) nVar).i() == this.d;
    }
}
