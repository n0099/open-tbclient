package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j extends i implements bg {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    public j() {
        a(1);
    }

    public boolean a() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public String c() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String e() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String f() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public int g() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public int h() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public void f(String str) {
        this.i = str;
    }

    public int i() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.l = str;
    }

    public void i(String str) {
        this.m = str;
    }

    public void j(String str) {
        this.n = str;
    }

    public int j() {
        return this.o;
    }

    public void f(int i) {
        this.o = i;
    }

    public boolean k() {
        return this.q;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public boolean l() {
        return this.r;
    }

    public void c(boolean z) {
        this.r = z;
    }

    public boolean m() {
        return this.s;
    }

    public void d(boolean z) {
        this.s = z;
    }

    @Override // com.baidu.tbadk.core.util.bg
    public LinkedList<bf> getImages() {
        LinkedList<bf> linkedList = new LinkedList<>();
        bf bfVar = new bf();
        bfVar.a = this.e;
        bfVar.d = 10;
        linkedList.add(bfVar);
        return linkedList;
    }
}
