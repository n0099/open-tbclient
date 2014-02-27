package com.baidu.tieba.im.data;

import com.baidu.tieba.util.av;
import com.baidu.tieba.util.aw;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class i extends h implements aw {
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

    public i() {
        a(1);
    }

    public final boolean a() {
        return this.p;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final String c() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String d() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String e() {
        return this.d;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final String f() {
        return this.e;
    }

    public final void e(String str) {
        this.e = str;
    }

    public final int g() {
        return this.f;
    }

    public final void b(int i) {
        this.f = i;
    }

    public final int h() {
        return this.g;
    }

    public final void c(int i) {
        this.g = i;
    }

    public final void d(int i) {
        this.h = i;
    }

    public final void f(String str) {
        this.i = str;
    }

    public final int i() {
        return this.j;
    }

    public final void e(int i) {
        this.j = i;
    }

    public final void g(String str) {
        this.k = str;
    }

    public final void h(String str) {
        this.l = str;
    }

    public final void i(String str) {
        this.m = str;
    }

    public final void j(String str) {
        this.n = str;
    }

    public final int j() {
        return this.o;
    }

    public final void f(int i) {
        this.o = i;
    }

    public final boolean k() {
        return this.q;
    }

    public final void b(boolean z) {
        this.q = z;
    }

    public final boolean l() {
        return this.r;
    }

    public final void c(boolean z) {
        this.r = z;
    }

    @Override // com.baidu.tieba.util.aw
    public final LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.aw
    public final LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public final LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public final boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.aw
    public final LinkedList<av> getImagesWithEmotions() {
        return null;
    }

    public final boolean m() {
        return this.s;
    }

    public final void d(boolean z) {
        this.s = z;
    }
}
