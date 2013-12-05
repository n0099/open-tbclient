package com.baidu.tieba.im.data;

import com.baidu.tieba.util.ak;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e extends d implements ak {

    /* renamed from: a  reason: collision with root package name */
    private String f1649a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;
    private boolean p;

    public e() {
        a(1);
    }

    public boolean a() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public String c() {
        return this.f1649a;
    }

    public void a(String str) {
        this.f1649a = str;
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

    public void f(String str) {
        this.h = str;
    }

    public void g(String str) {
        this.i = str;
    }

    public int i() {
        return this.j;
    }

    public void d(int i) {
        this.j = i;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void j(String str) {
        this.m = str;
    }

    public void k(String str) {
        this.n = str;
    }

    public int j() {
        return this.o;
    }

    public void e(int i) {
        this.o = i;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
