package com.baidu.tbadk.game;

import java.util.List;
import tbclient.GameInfo;
/* loaded from: classes.dex */
public class b {
    private String a;
    private String b;
    private int c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String l;
    private List<String> m;
    private String n;
    private int o;
    private String p;
    private String q;
    private long r;
    private long s;
    private long t;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public int e() {
        return this.e;
    }

    public void a(Integer num) {
        this.e = num.intValue();
    }

    public String f() {
        return this.f;
    }

    public void d(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void e(String str) {
        this.g = str;
    }

    public String h() {
        return this.h;
    }

    public void f(String str) {
        this.h = str;
    }

    public int i() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public List<String> j() {
        return this.m;
    }

    public void a(List<String> list) {
        this.m = list;
    }

    public long k() {
        return this.r;
    }

    public void a(long j) {
        this.r = j;
    }

    public long l() {
        return this.s;
    }

    public void b(long j) {
        this.s = j;
    }

    public long m() {
        return this.t;
    }

    public void c(long j) {
        this.t = j;
    }

    public String n() {
        return this.p;
    }

    public void j(String str) {
        this.p = str;
    }

    public String o() {
        return this.q;
    }

    public void k(String str) {
        this.q = str;
    }

    public String p() {
        return this.n;
    }

    public void l(String str) {
        this.n = str;
    }

    public void c(int i) {
        this.o = i;
    }

    public static b a(GameInfo gameInfo) {
        if (gameInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.g(gameInfo.apple_id);
        bVar.h(gameInfo.bundle_id);
        bVar.a(gameInfo.game_id);
        bVar.f(gameInfo.game_link);
        bVar.b(gameInfo.game_name);
        bVar.a(gameInfo.game_pic);
        bVar.c(gameInfo.icon_url);
        bVar.a(gameInfo.game_type.intValue());
        bVar.b(gameInfo.mark.intValue());
        bVar.d(gameInfo.package_link);
        bVar.e(gameInfo.package_size);
        bVar.a(gameInfo.player_num);
        bVar.i(gameInfo.schema_url);
        bVar.l(gameInfo.introduce);
        bVar.k(gameInfo.launch_component);
        bVar.j(gameInfo.andr_pk_name);
        return bVar;
    }
}
