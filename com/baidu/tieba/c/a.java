package com.baidu.tieba.c;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private s<String> b = null;
    private s<String> c = null;
    private s<String> d = null;
    private s<String> e = null;
    private s<String> f = null;
    private s<String> g = null;
    private s<String> h = null;
    private s<String> i = null;
    private s<String> j = null;
    private s<String> k = null;
    private s<String> l = null;
    private s<byte[]> m = null;
    private s<byte[]> n = null;
    private s<byte[]> o = null;
    private s<String> p = null;
    private s<byte[]> q = null;
    private s<String> r = null;
    private s<String> s = null;
    private s<String> t = null;
    private s<byte[]> u = null;
    private s<String> v = null;
    private s<String> w = null;

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private a() {
    }

    public s<String> b() {
        if (this.b == null) {
            this.b = BdCacheService.c().a("tb.pb_mark", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.b;
    }

    public s<String> c() {
        if (this.d == null) {
            this.d = BdCacheService.c().a("tb.pb_normal", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 1);
        }
        return this.d;
    }

    public s<String> d() {
        if (this.c == null) {
            this.c = BdCacheService.c().a("tb.pb_editor", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.c;
    }

    public s<byte[]> e() {
        if (this.m == null) {
            this.m = BdCacheService.c().b("tb.im_frsgroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.m;
    }

    public s<byte[]> f() {
        if (this.u == null) {
            this.u = BdCacheService.c().b("tb.im_hotgroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 30);
        }
        return this.u;
    }

    public s<String> g() {
        if (this.e == null) {
            this.e = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.e;
    }

    public s<String> h() {
        if (this.p == null) {
            this.p = BdCacheService.c().a("tb.im_group_search_history", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.p;
    }

    public void i() {
        if (this.p != null) {
            BdCacheService.c().a(this.p);
            this.p = null;
        }
    }

    public s<String> j() {
        if (this.f == null) {
            this.f = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.f;
    }

    public s<String> k() {
        if (this.g == null) {
            this.g = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.g;
    }

    public s<String> l() {
        if (this.h == null) {
            this.h = BdCacheService.c().a("tb.my_bookmarks", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.h;
    }

    public s<String> m() {
        if (this.i == null) {
            this.i = BdCacheService.c().a("tb.my_posts", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.i;
    }

    public s<String> n() {
        if (this.j == null) {
            this.j = BdCacheService.c().a("tb.my_forums", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.j;
    }

    public s<String> o() {
        if (this.k == null) {
            this.k = BdCacheService.c().a("tb.square", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.k;
    }

    public s<String> p() {
        if (this.l == null) {
            this.l = BdCacheService.c().a("tb.first_dir", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.l;
    }

    public s<byte[]> q() {
        if (this.n == null) {
            this.n = BdCacheService.c().b("tb.im_groupinfo", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.n;
    }

    public s<byte[]> r() {
        if (this.o == null) {
            this.o = BdCacheService.c().b("tb.im_groupactivity", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.n;
    }

    public s<byte[]> s() {
        if (this.q == null) {
            this.q = BdCacheService.c().b("tb.im_entergroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 10);
        }
        return this.q;
    }

    public s<byte[]> t() {
        if (this.q == null) {
            this.q = BdCacheService.c().b("tb.im_enterforum_groupinfo", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 10);
        }
        return this.q;
    }

    public s<String> u() {
        if (this.r == null) {
            this.r = BdCacheService.c().a("tb.im_group_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.r;
    }

    public s<String> v() {
        if (this.s == null) {
            this.s = BdCacheService.c().a("tb.im_personal_chat_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.s;
    }

    public s<String> w() {
        if (this.t == null) {
            this.t = BdCacheService.c().a("tb.pic_gif", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.t;
    }

    public s<String> x() {
        if (this.w == null) {
            this.w = BdCacheService.c().a("tb_face_package", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 30);
        }
        return this.w;
    }
}
