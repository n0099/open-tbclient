package com.baidu.tieba.im.message;

import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
/* loaded from: classes.dex */
public abstract class b extends o implements com.baidu.tieba.im.coder.g, com.baidu.tieba.im.messageCenter.c {
    public boolean a;
    private int b;
    private Object c;
    private String d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long j;
    private UserData k;
    private UserData l;
    private MsgLocalData m;
    private transient MsgCacheData n;
    private long p;
    private long s;
    private int o = 0;
    private boolean q = true;
    private boolean r = false;

    public long b() {
        return this.p;
    }

    public void a(long j) {
        this.p = j;
    }

    public boolean c() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public int d() {
        return this.o;
    }

    public void a(int i) {
        this.o = i;
    }

    public Object e() {
        return this.c;
    }

    public void a(Object obj) {
        this.c = obj;
    }

    public UserData f() {
        return this.k;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData g() {
        return this.l;
    }

    public void b(UserData userData) {
        this.l = userData;
    }

    public int h() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public long i() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
    }

    public String j() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public long k() {
        return this.f;
    }

    public void c(long j) {
        this.f = j;
    }

    public long l() {
        return this.j;
    }

    public void d(long j) {
        this.j = j;
    }

    public MsgLocalData m() {
        return this.m;
    }

    public void a(MsgLocalData msgLocalData) {
        this.m = msgLocalData;
    }

    public MsgCacheData n() {
        return this.n;
    }

    public void a(MsgCacheData msgCacheData) {
        this.n = msgCacheData;
    }

    public long o() {
        return this.g;
    }

    public void e(long j) {
        this.g = j;
    }

    public int p() {
        return this.h;
    }

    public void c(int i) {
        this.h = i;
    }

    public int q() {
        return this.i;
    }

    public void d(int i) {
        this.i = i;
    }

    public boolean r() {
        return this.q;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public long s() {
        return this.s;
    }

    public void f(long j) {
        this.s = j;
    }

    @Override // com.baidu.tieba.im.messageCenter.c
    public boolean a(o oVar) {
        return oVar != null && (oVar instanceof b) && ((b) oVar).i() == this.e;
    }
}
